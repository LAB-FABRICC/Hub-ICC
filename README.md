# Hub-ICC

## Objectifs.
1. Créer deux ontologies décrivant les formations et les laboratoires avec [Protégé](https://protege.stanford.edu/).
1. Stocker & Publier les données en Open Data avec [Jena](https://jena.apache.org/).
1. Rendre ses données visible ET liées sur des plateformes comme [lodlive](http://en.lodlive.it/).
1. Permettre de lancer des requêtes SPARQL sur les données et expérimenter la fusion de graph avec [Fuseki](https://jena.apache.org/documentation/fuseki2/index.html).

## Image docker.
L'image docker contient :
* [Jena](https://jena.apache.org/).
* [Fuseki](https://jena.apache.org/documentation/fuseki2/index.html).
* L'ensemble des données.

Vous pouvez la lancer avec la commande : `docker run -p 3030:3030 NOM_IMAGE`. 

L'application est ensuite disponible à l'adresse [http://localhost:3030/](http://localhost:3030/).

## Technologies.
* [Resource Description Framework (RDF)](https://fr.wikipedia.org/wiki/Resource_Description_Framework) est un modèle de graphe permettant de décrire les ressources utilisées ainsi que leurs métadonnées, 
* [RDF Schema ou RDFS](https://fr.wikipedia.org/wiki/RDF_Schema) est un langage fournissant de quoi hiérarchiser des classes et propriétés ou encore de définir des ontologies.
* [Web Ontology Language](https://fr.wikipedia.org/wiki/Web_Ontology_Language) ou (OWL) est une extension du RDFS.
* [SPARQL](https://fr.wikipedia.org/wiki/SPARQL) : Equivalent du SQL mais pensé par le W3C afin d'assurer l'interopérabilité des données du web.


## Run with docker

```bash
cd batch;
```

### build

```bash
docker run -it --rm --name hub-icc -v "/tmp/hub-icc/.m2:/root/.m2" -v "$(pwd)":/usr/src/3-jdk-11-slim -w /usr/src/3-jdk-11-slim maven:3-jdk-11-slim mvn clean install
```

### run

```bash
docker run -it --rm --name hub-icc -v "/tmp/hub-icc/.m2:/root/.m2" -v "$(pwd)":/usr/src/3-jdk-11-slim -w /usr/src/3-jdk-11-slim maven:3-jdk-11-slim mvn spring-boot:run
```

La création des fichiers owl se fait au démarrage du projet. Ils sont générés dans le répertoire à la racine `generatedOwl`