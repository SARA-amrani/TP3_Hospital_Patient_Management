# Gestion des Patients avec Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA et Spring Security

## Introduction

Ce projet a été réalisé dans le cadre de l'activité pratique n°3 dirigée par M. Mohamed Youssfi. Il s'agit d'une application web JEE permettant de gérer les patients à l'aide de technologies modernes telles que Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA et Spring Security. L'application permet d'ajouter, modifier, chercher, supprimer et afficher des patients avec pagination, ainsi que de gérer la sécurité des accès utilisateurs/admins.

## Technologies utilisées

🔙 Backend
<p> <img src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white" /> <img src="https://img.shields.io/badge/Spring%20Boot-3.2+-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" /> <img src="https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white" /> <img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white" /> <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" /> </p>
🎨 Frontend
<p> <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" /> <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" /> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" /> </p>
🗄️ Base de données
<p> <img src="https://img.shields.io/badge/H2-1A237E?style=for-the-badge&logo=h2&logoColor=white" /> <img src="https://img.shields.io/badge/SQL-4479A1?style=for-the-badge&logo=postgresql&logoColor=white" /> </p>
⚙️ Build Tool
<p> <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" /> </p>

Technologies utilisées :
Backend : Java 17, Spring Boot 3.2+, Spring MVC, Spring Data JPA, Spring Security

Frontend : Thymeleaf, HTML/CSS

Base de données : H2 ou autre DB relationnelle

Build : Maven

    Java 17
    
    Spring Boot 3.2+
    
    Spring MVC
    
    Spring Data JPA
    
    Spring Security
    
    Thymeleaf
    
    H2 Database (ou autre DB supportée)
    
    Maven
    
    HTML/CSS

## Objectifs fonctionnels

    Afficher la liste des patients
    
    Ajouter un patient avec formulaire validé
    
    Modifier les informations d'un patient
    
    Supprimer un patient (restriction ADMIN)
    
    Recherche par mot clé (nom)
    
    Pagination des patients
    
    Authentification via Spring Security
    
    Différenciation des rôles : USER, ADMIN

## Structure du projet

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

Explication des classes et interfaces

Entités

Patient : représente un patient avec id, nom, date de naissance, malade (boolean), score.

AppUser : utilisateur du système (nom d'utilisateur, mot de passe, liste des rôles).

AppRole : rôle d'un utilisateur (USER, ADMIN).

Repositories

PatientRepository : interface qui hérite de JpaRepository pour CRUD + méthodes de recherche.

AppUserRepository : pour chercher un utilisateur par username.

AppRoleRepository : pour chercher un rôle par nom.

Services de sécurité

AccountService : interface de gestion des utilisateurs et rôles.

AccountServiceImpl : implémentation avec méthodes pour enregistrer un utilisateur et l’assigner à un rôle.

UserDetailServiceImpl : implémente UserDetailsService pour l’intégration avec Spring Security.

SecurityConfig : configuration de sécurité (authentification InMemory ou JDBC, autorisation par URL).

Contrôleurs Web

PatientController : gère les routes comme /patients, /formPatient, /editPatient, /deletePatient. Utilise Model pour afficher ou récupérer les données.

SecurityController : gère la redirection vers login, page non autorisée.

Fichiers Thymeleaf (templates)

patients.html : affiche la liste paginée des patients avec options de recherche/suppression.

formPatient.html : formulaire d'ajout ou modification.

editPatient.html : formulaire pré-rempli pour modification.

login.html : page d’authentification.

notAuthorized.html : message d’accès refusé.

template1.html : modèle de base utilisé dans les autres templates (header/footer).

Configuration & Script SQL

application.properties : contient la configuration de la base, JPA, Thymeleaf, port, etc.

schema.sql : initialise les tables en base de données (AppUser, AppRole, etc.).

Fonctionnement de l'application

Lancement de l'application via la classe HopitalApplication.

L'utilisateur est redirigé vers la page de login.

Selon le rôle (USER ou ADMIN), il peut accéder aux différentes fonctionnalités.

Affichage des patients avec pagination et recherche.

Les utilisateurs peuvent ajouter ou éditer un patient.

Seul un ADMIN peut supprimer un patient.

Captures d'écran

(Ajoutez ici les captures de votre interface : page de login, liste des patients, formulaire, erreur 403, etc.)

Exemples :


Conclusion

Cette activité pratique a permis de comprendre les fondements du développement web fullstack avec Spring Boot. Nous avons exploré la gestion des entités via JPA, la création de contrôleurs Spring MVC, le rendu dynamique avec Thymeleaf, et enfin la sécurité avec Spring Security. Le projet est extensible et peut être enrichi avec des tests unitaires, une base de données plus robuste, ou encore l’intégration d’une API REST.

Auteur : Mohamed Youssfi (cours) | Réalisé par : [Votre Nom]