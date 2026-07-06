Projet Spring Boot – Produits App

Ce projet est une application Spring Boot réalisée dans le cadre des TPs.
Elle permet de gérer des utilisateurs, des rôles et des produits avec une API REST sécurisée (JWT).

 Prérequis

Avant de lancer le projet, vous devez avoir :

* Java 17 installé
* Git installé
* Un IDE (IntelliJ, Eclipse ou Spring Tool Suite)
 Installation

1. Cloner le projet

```bash
git clone https://github.com/Amazighiahub/CoursSI4.git
cd CoursSI4

 Lancer le projet

 Sur Windows :

```bash
mvnw.cmd spring-boot:run
```
 Sur Mac / Linux :

```bash
./mvnw spring-boot:run
```

 Accès à l'application

Une fois le projet lancé :

* API : [http://localhost:8080](http://localhost:8080)
* Swagger (documentation) : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

 Base de données (IMPORTANT)

Le projet utilise MySQL.

### Étapes :

1. Installer MySQL
2. Créer une base de données :

```sql
CREATE DATABASE cours;
```

3. Modifier le fichier :

```
src/main/resources/application.properties
```

4. Ajouter vos informations :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cours
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
 🔐 Authentification

Le projet utilise JWT :

1. S'inscrire (register)
2. Se connecter (login)
3. Utiliser le token pour accéder aux routes sécurisées

 📁 Structure du projet

* controller → API REST
* service → logique métier
* repositorie → accès base de données
* entities → modèles
* dto → objets de transfert
* security → gestion JWT
* config → configuration



 ❗ Problèmes fréquents

 Port 8080 déjà utilisé

Solution : changer le port dans `application.properties`

`properties
server.port=8081



## 👩‍💻 Auteur

Souhila GUERFI
TP Spring Boot – ESIEA

