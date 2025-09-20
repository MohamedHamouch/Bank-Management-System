# Bank Management System

## Description du projet

Le Bank Management System est une application console Java qui simule les opérations bancaires de base. Ce système permet de gérer différents types de comptes bancaires (comptes courants et comptes d'épargne) et d'effectuer diverses opérations financières.

### Fonctionnalités principales :
- **Création de comptes** : Création de comptes courants avec découvert autorisé et comptes d'épargne avec taux d'intérêt
- **Opérations bancaires** : Dépôts, retraits et virements entre comptes
- **Consultation** : Vérification du solde, historique des opérations et détails du compte
- **Gestion des opérations** : Suivi automatique de toutes les transactions avec horodatage
- **Validation des données** : Contrôle de saisie avec gestion d'erreurs robuste

## Technologies utilisées

- **Java 8** : Langage de programmation principal
- **Java Collections Framework** : Utilisation de `HashMap` et `ArrayList`
- **Java Time API** : Gestion des dates avec `LocalDate`
- **UUID** : Génération d'identifiants uniques pour les opérations
- **Scanner** : Interface utilisateur en mode console
- **IntelliJ IDEA** : Environnement de développement intégré

## Structure du projet

```
Bank-Management-System/
├── src/
│   ├── Main.java                           # Point d'entrée de l'application
│   ├── controllers/
│   │   ├── AccountController.java          # Contrôleur pour les opérations sur les comptes
│   │   └── MenuController.java             # Contrôleur pour l'interface utilisateur
│   ├── helpers/
│   │   └── InputHelper.java                # Utilitaires pour la saisie utilisateur
│   ├── models/
│   │   ├── Account.java                    # Classe abstraite de base pour les comptes
│   │   ├── CurrentAccount.java             # Implémentation du compte courant
│   │   ├── SavingAccount.java              # Implémentation du compte d'épargne
│   │   ├── Operation.java                  # Classe abstraite pour les opérations
│   │   ├── Deposit.java                    # Opération de dépôt
│   │   └── Withdrawal.java                 # Opération de retrait
│   └── services/
│       └── AccountService.java             # Service métier pour la gestion des comptes
├── UML/
│   └── BMS-Class-Diagram.png              # Diagramme de classes UML
├── .idea/                                  # Configuration IntelliJ IDEA
├── README.md                               # Documentation du projet
├── .gitignore                             # Fichiers ignorés par Git
└── Bank-Management-System.iml             # Fichier de module IntelliJ
```

### Architecture du projet :

- **MVC Pattern** : Séparation entre modèles, vues (console) et contrôleurs
- **Service Layer** : [`AccountService`](src/services/AccountService.java) pour la logique métier
- **Helper Classes** : [`InputHelper`](src/helpers/InputHelper.java) pour la validation des saisies
- **Polymorphisme** : Classes [`CurrentAccount`](src/models/CurrentAccount.java) et [`SavingAccount`](src/models/SavingAccount.java) héritant d'[`Account`](src/models/Account.java)

## Prérequis

### Logiciels requis :
- **Java Development Kit (JDK) 8** ou version supérieure
- **Git** pour le clonage du repository
- **IntelliJ IDEA** (recommandé) ou tout autre IDE Java

### Installation et exécution :

1. **Cloner le repository** :
```bash
git clone https://github.com/votre-username/Bank-Management-System.git
cd Bank-Management-System
```

2. **Compiler le projet** :
```bash
javac -d out -cp src src/**/*.java src/*.java
```

3. **Exécuter l'application** :
```bash
java -cp out Main
```

### Utilisation avec IntelliJ IDEA :
1. Ouvrir le projet dans IntelliJ IDEA
2. Configurer le SDK Java 8
3. Exécuter la classe [`Main`](src/Main.java)

### Format des numéros de compte :
- Les numéros de compte suivent le format `CPT-XXXXX` (ex: CPT-00001)
- Génération automatique lors de la création d'un compte

### Types de comptes disponibles :
- **Compte Courant** : Permet un découvert autorisé
- **Compte d'Épargne** : Calcul automatique des intérêts basé sur le taux configuré

---

*Développé avec Java 8 - Système de Gestion Bancaire*