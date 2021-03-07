#!/bin/bash

#############################################################################################
# Declaração das constantes do script
#############################################################################################

PROJECT_NAME="visto-api"
PROJECT_VERSION="v1"

DIST_DIR="dist"
TARGET_DIR="target"
SCRIPTS_DIR="scripts"
PYTHON_DIR="python"
DOCKER_DIR="docker"

MVN_SKIP_TESTS="true"

#############################################################################################
# Efetua a criação do diretório dist
#############################################################################################

echo "Verificando a existência do diretório $DIST_DIR..."

if [ -e dist ]; then
	echo "Removendo o diretório $DIST_DIR..."
	rm -Rf dist
fi

echo "Criando o diretório $DIST_DIR..."
mkdir dist

#############################################################################################
# Efetua a compilação do projeto
#############################################################################################

echo "Compilando o projeto $PROJECT_NAME:$PROJECT_VERSION, por favor aguarde..."
sh -c "exec mvn clean compile install -DskipTests=$MVN_SKIP_TESTS"

return_code=$?

if [ $return_code -ne 0 ]; then
	echo "Falha na compilação do projeto => Erro : $return_code"
	exit $return_code
fi

#############################################################################################
# Copia os arquivos para o diretório de distribuição
#############################################################################################

echo "Copiando os arquivos para o diretório $DIST_DIR..."

cp $SCRIPTS_DIR/start-services.sh $DIST_DIR
echo "Arquivo $SCRIPTS_DIR/start-services.sh copiado com sucesso"
chmod +x $DIST_DIR/start-services.sh

cp $TARGET_DIR/*.jar $DIST_DIR
echo "Arquivos $TARGET_DIR/*.jar copiado(s) com sucesso"

cp $PYTHON_DIR/message-receiver.py $DIST_DIR
echo "Arquivos $PYTHON_DIR/message-receiver.py copiado(s) com sucesso"
chmod +x $DIST_DIR/message-receiver.py

cp $DOCKER_DIR/api/Dockerfile $DIST_DIR
echo "Arquivos $DOCKER_DIR/api/Dockerfile copiado com sucesso"

#############################################################################################
# Efetua a geração do container docker
#############################################################################################

echo "Entrando no diretório $DIST_DIR..."
cd $DIST_DIR

echo "Removendo a imagem docker $PROJECT_NAME:$PROJECT_VERSION..."
sh -c "exec docker rmi $PROJECT_NAME:$PROJECT_VERSION"

echo "Gerando a imagem do projeto $PROJECT_NAME:$PROJECT_VERSION, por favor aguarde..."
sh -c "exec docker build -t$PROJECT_NAME:$PROJECT_VERSION ."

return_code=$?

if [ $return_code -ne 0 ]; then
	echo "Falha na geração da imagem do projeto => Erro : $return_code"
	exit $return_code
fi

#############################################################################################
# Encerra a execução do script
#############################################################################################

echo "Imagem do projeto $PROJECT_NAME:$PROJECT_VERSION gerada com sucesso"

exit 0