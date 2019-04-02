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


## LOCAL 

On descend dans le projet spring-boot : 

```bash
cd batch;
```

### Compilation

```bash
docker run -it --rm --name hub-icc -v "/tmp/hub-icc/.m2:/root/.m2" -v "$(pwd)":/usr/src/3-jdk-11-slim -w /usr/src/3-jdk-11-slim maven:3-jdk-11-slim mvn clean install
```

### Génération du fichier rdf

```bash
docker run -it --rm --name hub-icc -v "/tmp/hub-icc/.m2:/root/.m2" -v "$(pwd)":/usr/src/3-jdk-11-slim -w /usr/src/3-jdk-11-slim maven:3-jdk-11-slim mvn spring-boot:run
```

La création du fichier RDF se fait au démarrage du projet via un command line runner et se trouve dans dans le dossier target/generated.rdf.

On retourne ensuite à la racine du projet :

```bash
cd ..
```

### Création de l'image docker

```bash
docker build -t scubicc/sparql
```

### Démarrage de l'image docker en local 

```bash
docker run -p 3030:3030 scubicc/sparql
```

### Configuration apache en attendant la mise en place coté fabricc

création d'un fichier de conf "fabricc.univ-poitiers.fr.conf" dans le dossier /etc/apache2/sites-availables

```bash
#Handle call to fabricc.univ-poitiers.fr 
<VirtualHost *:80>
	ServerName fabricc.univ-poitiers.fr
	DocumentRoot "/var/www/fabricc.univ-poitiers"
	<Directory "/var/www/fabricc.univ-poitiers">
		Options FollowSymLinks
		AllowOverride all
		Require all granted
	</Directory>
	ErrorLog /var/log/apache2/error.fabricc.univ-poitiers.log
	CustomLog /var/log/apache2/access.fabricc.univ-poitiers.log combined
</VirtualHost>
```

création du dossier permettant d'accès aux fichiers html générés lors du démarrage du projet.

```bash
sudo mkdir -p /var/www/fabricc.univ-poitiers
```

déplacement des sources htmls dans le dossier cible

```bash 
sudo rm -rf /var/www/fabricc.univ-poitiers/def;
sudo cp -R target/html /var/www/fabricc.univ-poitiers/def;
```

déclarer le site comme opérationnel 

```bash 
sudo a2ensite fabricc.univ-poitiers.fr;
sudo systemctl reload apache2;
```

modification du fichier /etc/hosts pour prendre en compte l'url : 

```bash
## Fabricc 
127.0.0.1	fabricc.univ-poitiers.fr
```

## SERVER

### Déploiement sur le repository Docker public

L'image docker est publié automatiquement lors d'un push sur la branche.

Vous pouvez la démarrer via la commande suivante :

```bash
docker run -p 3030:3030 scubicc/sparql:latest
```



