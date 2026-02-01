# 🚀 Task Manager API – Spring Boot

## 📌 Description
API REST développée avec Spring Boot pour gérer des tâches.
Ce projet met en pratique les bonnes pratiques backend modernes :
DTO, validation, pagination, JPA et architecture propre.

---

## 🛠️ Technologies utilisées
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL / MySQL
- Maven
- Git & GitHub

---

## 🧱 Architecture
controller → service → repository → database
dto → mapper → entity


---

## ✨ Fonctionnalités
- Créer une tâche
- Lister les tâches (pagination & tri)
- Rechercher par statut
- Modifier le statut d’une tâche
- Supprimer une tâche
- Validation des données
- Gestion globale des erreurs

---

## ▶️ Lancer le projet

### Prérequis
- Java 17+
- Maven
- PostgreSQL ou MySQL

### Étapes
```bash
git clone https://github.com/MHD-Lamine/task-manager-api.git
cd task-manager-api
mvn spring-boot:run

🌐 Endpoints principaux
Méthode	URL	Description
POST	/api/tasks	                Créer une tâche
GET	/api/tasks	                    Lister (pagination)
GET	/api/tasks/search	            Rechercher par statut
PUT	/api/tasks/{id}/statut	        Modifier statut
DELETE	/api/tasks/{id}	            Supprimer


___________________

- Mohamed Lamine
- DIABATE
___________________

## 🧩 ÉTAPE 10.4 — PETIT NETTOYAGE CLEAN CODE (CHECKLIST)

✔️ Pas d’Entity exposée dans l’API  
✔️ DTO clairs  
✔️ Messages d’erreur lisibles  
✔️ Noms de classes en `*ServiceImpl`  
✔️ `@RestControllerAdvice` présent  
✔️ Pagination activée  
