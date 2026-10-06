# TP1 Java - Hibernate JPA

Dans ce TP, j'ai travaille avec Java, Hibernate, JPA et la base de donnees H2.
Le but est de creer une entite `Article`, inserer des donnees, puis verifier le resultat avec la console Web H2.

## Modification de la configuration Hibernate

J'ai remplace `create-drop` par `update` dans le fichier `persistence.xml`.
Avec `update`, Hibernate garde la structure de la base pendant que l'application reste lancee.

![Configuration Hibernate](docs/images/01-configuration-hibernate.png)

## Lancement de la console H2

J'ai ajoute le demarrage de la console H2 dans la classe principale avec le port `8082`.
Comme ca, je peux ouvrir la base dans le navigateur.

![Console H2 dans Java](docs/images/02-console-h2.png)

## Connexion a la base H2

Pour se connecter, j'utilise l'adresse `http://localhost:8082`.
Les informations de connexion sont :

- Driver Class : `org.h2.Driver`
- JDBC URL : `jdbc:h2:mem:testdb`
- User Name : `sa`
- Password : vide

![Connexion H2](docs/images/03-connexion-h2.png)

## Table generee par Hibernate

Apres l'execution, Hibernate cree la table `ARTICLE`.
Cette table contient les colonnes de l'entite Java.

![Table Article](docs/images/04-table-article.png)

## Verification avec SQL

J'ai execute une requete SQL pour afficher les donnees inserees dans la table.

```sql
SELECT * FROM ARTICLE;
```

![Requete SQL](docs/images/05-requete-sql.png)

## Resultat final

Le resultat montre que les articles sont bien inseres dans la base H2.
La console permet donc de verifier facilement le contenu de la base.

![Resultat final](docs/images/06-resultat-final.png)
