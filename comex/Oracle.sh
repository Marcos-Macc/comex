#Criando container com nome oracle no docker
docker run -d --name oracle -p 1521:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe

docker container logs -f oracle

# Criando Volume e um container ORACLE dentro do volume
docker volume create oracle-volume

docker run -d --name oracle-volume -p 1521:1521 -e ORACLE_PASSWORD=admin -v oracle-volume:/opt/oracle/oradata gvenzl/oracle-xe