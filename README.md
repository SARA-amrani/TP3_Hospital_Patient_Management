#  Gestion des Patients - Spring Boot App

> Mise en œuvre de Spring MVC, Spring Data JPA, Thymeleaf, et Spring Security

---

##  Sommaire

- [Introduction](#introduction)
- [Objectif](#objectif)
- [Technologies utilisées](#technologies-utilisées)
- [Architecture du projet](#architecture-du-projet)
- [Structure du projet](#-structure-du-projet)
- [Fonctionnalités](#-fonctionnalités)
- [Explication des composants](#-explication-des-composants)
- [Lancer l'application](#-lancer-lapplication)
- [Conclusion](#-conclusion)

---
## Introduction

Ce projet consiste en une application web de gestion des patients pour un hôpital, développée avec Spring Boot. L'application intègre Spring MVC pour la couche web, Spring Data JPA pour la persistance des données, Thymeleaf comme moteur de templates et Spring Security pour la gestion de l'authentification et des autorisations.

---
##  Objectif

Créer une application web de gestion des patients en utilisant Spring Boot, avec les fonctionnalités suivantes :
- Affichage des patients avec pagination
- Modifier les informations d'un patient
- Recherche par mot-clé
- Suppression des patients
- Formulaire d’ajout/édition avec validation
- Sécurité avec Spring Security
- Authentification via Spring Security
- Différenciation des rôles : USER, ADMIN
- 
---
## Technologies utilisées

###  Backend
<p>
  <img src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2+-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
</p>

###  Frontend
<p>
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" />
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" />
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" />
</p>

###  Base de données
<p>
  <img src="https://img.shields.io/badge/H2-1A237E?style=for-the-badge&logo=h2&logoColor=white" />
</p>

###  Outils
<p>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />
</p>

---
##  Architecture du projet
![](captures/photo1.png)


    src/
    └── main/
    ├── java/ma.enset.tp3_springmvc_hopital/
    │   ├── entities/           # Contient les entités JPA (Patient, AppUser, AppRole)
    │   ├── repository/         # Contient les interfaces de repository JPA
    │   ├── security/
    │   │   ├── entities/     # Entités de sécurité (AppUser, AppRole)
    │   │   ├── repository/   # Repositories des entités de sécurité
    │   │   ├── service/      # Logique métier pour gestion des comptes
    │   │   └── SecurityConfig   # Configuration Spring Security
    │   ├── web/               # Contrôleurs Web MVC
    │   └── HopitalApplication.java # Classe principale Spring Boot
    └── resources/
    ├── templates/           # Fichiers HTML Thymeleaf
    ├── static/              # Ressources statiques
    ├── application.properties
    └── schema.sql           # Initialisation de la base

---
##  Explication des composants
### entities
- Contient les entités JPA qui modélisent les données stockées dans la base.

#### `Patient.java`
> Classe entité mappée à la table `patients`.
![](captures/photo2.png)

### repository
- Contient les interfaces DAO pour accéder aux données via Spring Data JPA.
#### `PatientRepository.java`
> Interface Spring Data JPA pour les opérations CRUD sur les patients avec une méthode de recherche personnalisée.  
![](captures/photo3.png)

### security.entities
- Contient les entités liées à la gestion des utilisateurs et des rôles.
#### `AppUser.java`
> Représente un utilisateur de l’application (admin, user...).
![](captures/photo4.png)

#### `AppRole.java` 
> Représente un rôle attribuable à un utilisateur (ROLE_USER, ROLE_ADMIN).
![](captures/photo5.png)

### security.repository
#### `AppUserRepository`
> DAO pour gérer les utilisateurs (AppUser) dans la base.
![](captures/photo6.png)

#### `AppRoleRepository`
> DAO pour gérer les rôles (AppRole).
![](captures/photo7.png)

### security.service
- Contient les services liés à la gestion de la sécurité et des comptes.

#### `AccountService (interface)`
Déclare les méthodes pour gérer les utilisateurs et les rôles.
![](captures/photo8.png)

#### `AccountServiceImpl (implémentation)` 
    Implémente la logique pour :
       - Ajouter un utilisateur
       - Ajouter un rôle
       - Associer un rôle à un utilisateur
![](captures/photo9.png)
![](captures/photo10.png)

#### `UserDetailServiceImpl` 
> Classe utilisée par Spring Security pour charger les détails d’un utilisateur à partir de la base.
![](captures/photo11.png)

### security.SecurityConfig
    - Contient la configuration de Spring Security :
    
      + Authentification en mémoire (InMemoryUserDetailsManager)
    
      + Configuration des filtres de sécurité (SecurityFilterChain)
    
      + Gestion des droits d’accès selon les rôles (ROLE_USER, ROLE_ADMIN)
![](captures/photo12.png)
![](captures/photo13.png)

### web
- Contient les contrôleurs web (MVC) qui reçoivent les requêtes HTTP.

#### `PatientController` 
> Contrôleur principal :Gère les requêtes HTTP liées aux patients (affichage, suppression, édition).
![](captures/photo14.png)
![](captures/photo15.png)

#### `SecurityController` 
> Contrôleur pour gérer les erreurs de sécurité (ex. accès non autorisé).
![](captures/photo16.png)

#### `HopitalApplication` 
> Classe principale avec l’annotation @SpringBootApplication qui démarre l'application.
![](captures/photo17.png)
![](captures/photo18.png)

### Fichiers de Configuration
#### `application.properties`
> Contient la configuration de la connexion à la base de données, le port du serveur, les paramètres Spring Security, etc.
![](captures/photo19.png)

### Templates HTML (Thymeleaf)
- Situés dans src/main/resources/templates, ils sont utilisés pour afficher l’interface utilisateur :

#### patients.html : 
> Liste paginée des patients.
![](captures/photo25.png)
![](captures/photo26.png)

#### formPatient.html : 
> Formulaire d'ajout d’un nouveau patient.
![](captures/photo22.png)


#### editPatient.html : 
> Formulaire de modification d’un patient existant.
![](captures/photo20.png)
![](captures/photo21.png)


#### login.html : 
> Formulaire de connexion.
![](captures/photo23.png)

#### notAuthorized.html : 
> Affichage d’erreur d’accès interdit.
![](captures/photo24.png)

#### template1.html : 
> Template de base pour layout.
![](captures/photo27.png)
![](captures/photo28.png)

---
## Aperçu de l'application
- Voici les principales interfaces :

### Page de login (login.html)
![](captures/photo29.png)
- Cette application de gestion des patients permet aux utilisateurs authentifiés d'accéder à différentes fonctionnalités selon leur rôle :
#### Rôle Admin :
  - L'administrateur a un accès complet au système :
       Consulter la liste des patients
       Modifier les informations d’un patient
       Supprimer un patient

![](captures/photo30.png)
![](captures/photo31.png)
![](captures/photo32.png)
![](captures/photo37.png)


#### Rôle User :
    - L’utilisateur avec le rôle USER dispose d’un accès limité :
         Peut voir la liste des patients
         Peut rechercher un patient par mot-clé
         Ne peut pas modifier ni supprimer les patients

![](captures/photo34.png)
![](captures/photo35.png)

### Liste des patients avec pagination et recherche (patients.html)
![](captures/photo36.png)

### Formulaire d’édition (editPatient.html)
![](captures/photo38.png)
![](captures/photo39.png)

### Page d’erreur d’accès (notAuthorized.html)
![](captures/photo33.png)

---
## Conclusion
Ce projet de gestion des patients dans un hôpital illustre une application complète basée sur le framework Spring Boot MVC, en intégrant la gestion de la sécurité avec Spring Security, une base de données relationnelle via JPA/Hibernate, et une interface utilisateur dynamique avec Thymeleaf.
Grâce à une architecture bien structurée en couches (entités, repository, service, web), cette application facilite la maintenance, l’extension et la réutilisabilité du code.

Ce travail m’a permis de mettre en pratique mes compétences en développement web full-stack Java, tout en respectant les bonnes pratiques d’architecture logicielle.


### Réalisé par : Sara EL AMRANI (GLSID)
### D’après les cours de M. Mohamed Youssfi


