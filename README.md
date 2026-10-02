# Projet API REST - Gestion de Consultations Médicales

## Aperçu du Projet
Ce projet consiste à construire une API (Interface de Programmation d'Application) REST sécurisée basée sur le cadre de travail (framework) Spring. L'application permet la gestion de consultations médicales reliant des patients, des médecins et des médicaments, et se connecte à une base de données MongoDB[cite: 1].

## Technologies et Outils
* **Cadre de travail (Framework) :** Spring v6, Spring Boot v3, Spring Web, Spring Security[cite: 1].
* **Base de données :** MongoDB[cite: 1].
* **Documentation :** OpenAPI Specification (Swagger) pour l'API, et Javadoc pour le code source[cite: 1].
* **Qualité du code :** SonarQube pour l'évaluation et la réduction de la dette technique[cite: 1].
* **Tests :** Spring Boot Tests[cite: 1].

## Fonctionnalités Principales
* **Authentification :** Connexion via identifiant et mot de passe pour obtenir un jeton (token) JWT[cite: 1].
* **Gestion des Patients :** Récupération avec pagination et recherche optionnelle par nom ou numéro de sécurité sociale[cite: 1].
* **Gestion des Médecins :** Récupération avec pagination et recherche optionnelle par nom ou matricule[cite: 1].
* **Gestion des Consultations :**
    * Liste paginée des consultations pour un patient donné[cite: 1].
    * Ajout, modification ou suppression d'une consultation[cite: 1].
    * Possibilité d'attacher un document (fichier) à une consultation[cite: 1].
* **Prescriptions :** Détail et modification des médicaments prescrits lors d'une consultation[cite: 1].

## Architecture et Bonnes Pratiques
* **Structure en couches :** Contrôleur (Controller), Services, et Couches d'accès aux données (Repositories)[cite: 1].
* **Transfert de données :** Utilisation du modèle DTO (Objet de Transfert de Données)[cite: 1].
* **Qualité et sécurité :** Respect des principes de conception SOLID, configuration des règles de sécurité (CORS, CSRF), journalisation (logs), et gestion stricte des exceptions[cite: 1].
