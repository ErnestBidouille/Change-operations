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
git submodule init && git submodule update
```

Utilisez cette commande pour packager les micro-services : 

Windows :

```cmd
mvnw package -DskipTests && cd Currency-exchange-rates && mvnw package -DskipTests && cd ..
```

Linux :

```bash
./mvnw package -DskipTests && cd Currency-exchange-rates && ./mvnw package -DskipTests && cd ..
```

## Lancement

```bash
docker-compose up -d --build
```

Si erreur au lancement : relancer la commande, l'initialisation de mysql est parfois trop longue pour que les micro-services puissent se connecter dessus directement.

