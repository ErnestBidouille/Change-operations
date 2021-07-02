# Change Opération

Projet pour le cours de master 2 webservices / micro services

Ce utilise un submodule : [Currency-exchange-rates](https://github.com/ErnestBidouille/Currency-exchange-rates)

Il necessite docker ainsi que docker-compose pour être utilisé dans les meilleures conditions.

## Installation

Cloner le repo : 

```bash
git clone https://github.com/ErnestBidouille/Change-operations
```

Puis initialiser le submodule :

```bash
git submodule init
```

Utilisez cette commande pour packager les micro-services : 

Windows :

```cmd
mvnw package -DskipTests && Currency-exchange-rates\mvnw package -DskipTests
```

Linux :

```bash
./mvnw package -DskipTests && ./Currency-exchange-rates/mvnw package -DskipTests
```

## Lancement

```bash
docker-compose up -d
```

Si erreur au lancement : relancer la commande, l'initialisation de mysql est parfois trop longue pour que les micro-services puissent se connecter dessus directement.

