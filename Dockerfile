# Image pour tester les ontologies et les données du projet.
FROM openjdk:8-jre-alpine
MAINTAINER Stéphane Traumat, stephane.traumat@gmail.com

# Fuseki
VOLUME /fuseki
ENV FUSEKI_BASE /fuseki

# Dossier d'installation
ENV FUSEKI_HOME /jena-fuseki

# Configuration
ENV MAVEN_REPOSITORY https://repo.maven.apache.org/maven2
ENV PACKAGE_PATH org/apache/jena/apache-jena-fuseki
ENV FUSEKI_VERSION 3.9.0

# Démendances
ENV DEPS curl

# Données
COPY données/rdf/mypizza.ttl /jena-fuseki/mypizza.ttl
COPY données/rdf/pizza.owl /jena-fuseki/pizza.owl
COPY norme/0.1/webSem.owl /jena-fuseki/webSem.owl

COPY generatedOwl/generated.rdf /jena-fuseki/generated.rdf

# Installation
WORKDIR /tmp
RUN export DEBIAN_FRONTEND=noninteractive && \
    rm -rf /var/lib/apt/lists/* && \
    apk update && \
    apk add $DEPS && \
    MAVEN_REPOSITORY_PATH=$MAVEN_REPOSITORY/$PACKAGE_PATH/$FUSEKI_VERSION && \
    FILE=apache-jena-fuseki-${FUSEKI_VERSION}.tar.gz && \
    URL=$MAVEN_REPOSITORY_PATH/$FILE && \
    echo Downloading $URL && \
    curl -f -O $URL && \
    tar xzf $FILE  --strip-components=1 --directory $FUSEKI_HOME && \
    rm apache-jena-fuseki-${FUSEKI_VERSION}.tar.gz && \
    rm -rf /var/lib/apt/lists/* && \
    rm -rf /tmp/*

# Configuration du server
COPY shiro.ini /jena-fuseki/shiro.ini
COPY shiro.ini /fuseki/shiro.ini

# Mis en place des scripts helpers
COPY load.sh /jena-fuseki/
COPY tdbloader /jena-fuseki/
RUN chmod 755 /jena-fuseki/load.sh
RUN chmod 755 /jena-fuseki/tdbloader

# Démarrage du server
WORKDIR /jena-fuseki
EXPOSE 3030
CMD ["/jena-fuseki/fuseki-server", "--file=/jena-fuseki/generated.rdf", "/jena-fuseki"]