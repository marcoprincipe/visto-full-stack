-- #################################################################################
-- # Define o banco de dados a ser utilizado
-- #################################################################################

use visto_db;

-- #################################################################################
-- # Inclui os dados na tabela de clientes
-- #################################################################################

INSERT INTO customers (code, name)
VALUES (1, 'Cliente de Teste 001');

INSERT INTO customers (code, name)
VALUES (2, 'Cliente de Teste 002');

INSERT INTO customers (code, name)
VALUES (3, 'Cliente de Teste 003');

INSERT INTO customers (code, name)
VALUES (4, 'Cliente de Teste 004');

INSERT INTO customers (code, name)
VALUES (5, 'Cliente de Teste 005');

-- #################################################################################
-- # Inclui os dados na tabela de veículos
-- #################################################################################

INSERT INTO vehicles (plate, brand, model)
VALUES ('AAA-1111', 'VolksWagen', 'Fusca 1964');

INSERT INTO vehicles (plate, brand, model)
VALUES ('BBB-2222', 'VolksWagen', 'Fusca 1965');

INSERT INTO vehicles (plate, brand, model)
VALUES ('CCC-3333', 'VolksWagen', 'Fusca 1966');

INSERT INTO vehicles (plate, brand, model)
VALUES ('DDD-4444', 'VolksWagen', 'Fusca 1967');

INSERT INTO vehicles (plate, brand, model)
VALUES ('EEE-4444', 'VolksWagen', 'Fusca 1968');

-- #################################################################################
-- # Inclui os dados na tabela de alocações
-- #################################################################################

INSERT INTO allocations (id_customer, id_vehicle, start_date, end_date)
VALUES (1, 1, '2021-02-26 00:00:00', '2021-03-01 00:00:00');

INSERT INTO allocations (id_customer, id_vehicle, start_date, end_date)
VALUES (2, 2, '2021-03-01 00:00:00', '2021-03-08 00:00:00');

INSERT INTO allocations (id_customer, id_vehicle, start_date, end_date)
VALUES (3, 3, '2021-03-09 00:00:00', '2021-03-16 00:00:00');

INSERT INTO allocations (id_customer, id_vehicle, start_date, end_date)
VALUES (4, 4, '2021-02-17 00:00:00', '2021-03-24 00:00:00');

INSERT INTO allocations (id_customer, id_vehicle, start_date, end_date)
VALUES (5, 5, '2021-02-25 00:00:00', '2021-04-01 00:00:00');



