# cris-app

docker run -p 1521:1521 -p 81:81 --name=MyH2Instance oscarfonts/h2

docker run --name='activemq' -it --rm  -e 'ACTIVEMQ_CONFIG_MINMEMORY=512' -e 'ACTIVEMQ_CONFIG_MAXMEMORY=2048' -p 8161:8161 -p 61616:61616 -p 61613:61613 -P webcenter/activemq:latest

