#!/usr/bin/python3

import pika
import sys
import os
import json
import mysql.connector

# Obtem as configurações do listener do rabbitmq.

def get_rabbitmq_configurations():

    host_name = os.getenv('VISTO_RABBITMQ_HOST', 'localhost')
    host_port = os.getenv('VISTO_RABBITMQ_PORT', '5672')
    queue_name = os.getenv('VISTO_RABBITMQ_QUEUE', 'visto-queue')

    return (host_name, host_port, queue_name)

# Obtem as configurações do mysql.

def get_mysql_configurations():

    host_name = os.getenv('VISTO_MYSQL_HOST', 'localhost')
    host_port = os.getenv('VISTO_MYSQL_PORT', '3306')
    database_name = os.getenv('VISTO_MYSQL_DB', 'visto_db')
    user_name = os.getenv('VISTO_MYSQL_USER', 'visto_user')
    user_password = os.getenv('VISTO_MYSQL_PASSWORD', 'M@pg2E07')

    return (host_name, host_port, database_name, user_name, user_password)

# Callback para tratamento das mensagens recebidas.

def on_message_received(ch, method, properties, body):
    
    print("Mensagem recebida : %r" % (body))

    obj = json.loads(body)

    print("idAllocation   : %r" % (obj['idAllocation']))
    print("idCustomer     : %r" % (obj['idCustomer']))
    print("startDate      : %r" % (obj['startDate']))
    print("endDate        : %r" % (obj['endDate']))
    print("remaining days : %r" % (obj['remainingDays']))

    database_persist(obj)

# Efetua a gravação dos dados no banco.

def database_persist(obj):

    sql = "INSERT INTO remaining_days (id_allocation, id_customer, start_date, end_date, remaining_days) \
            VALUES (%r, %r, %r, %r, %r)" % (obj["idAllocation"], obj["idCustomer"], obj["startDate"], obj["endDate"], obj["remainingDays"])

    (host_name, host_port, database_name, user_name, user_password) = get_mysql_configurations()

    connection = mysql.connector.connect(
        host=host_name,
        port=host_port,
        database=database_name,
        user=user_name,
        password=user_password
    )

    cursor = connection.cursor()

    cursor.execute(sql)

    connection.commit()

    cursor.close()

    connection.close()

# Método principal do módulo.

def main():

    # Recupera as configurações do listener.

    host_name, host_port, queue_name = get_rabbitmq_configurations()
    
    print("Iniciando o listener de mensagens...")
    print("host name  : %r" % (host_name))
    print("host port  : %r" % (host_port))
    print("queue name : %r" % (queue_name))

    # Efetua a conexão com o broker.

    print("Iniciando a conexão...")
    connection = pika.BlockingConnection(pika.ConnectionParameters(
        host=host_name, 
        port=int(host_port))
    )

    channel = connection.channel()

    # Efetua a criação da fila de mensagens.

    channel.queue_declare(queue=queue_name, durable=True)

    # Configura o listener de mensagens.

    channel.basic_consume(
        queue=queue_name, 
        on_message_callback=on_message_received, 
        auto_ack=True
    )

    print("Conexão iniciada com sucesso")

    # Aguarda pelas mensagens da fila.

    print("Aguardando pelas mensagens...")
    print('Pressione [CTRL + C] para encerrar')

    # Efetua o tratamento do encerramento do listener.

    try:

        channel.start_consuming()

    except KeyboardInterrupt:

        print("Encerrando o listener....")

        print("Encerrando o consumidor...")
        channel.stop_consuming()
        print("Consumidor encerrado com sucesso")

        print("Encerrando a conexão...")
        connection.close()
        print("Conexão encerrada com sucesso")

        try:
            sys.exit(0)
        except:
            os._exit(0)

# Entry-point principal do módulo.

if (__name__ == '__main__'):
    main()

