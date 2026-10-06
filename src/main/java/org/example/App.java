package org.example;

/**
 * Hello world!
 *
 */


import  org.example.model.Article;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Création de l'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");

        // Insertion de Articles
        insererArticles(emf);

        // Lecture des Articles
        lireArticles(emf);

        // Fermeture de l'EntityManagerFactory
        emf.close();
    }

    private static void insererArticles(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Création de quelques Articles
            Article p1 = new Article("Laptop", new BigDecimal("999.99"));
            Article p2 = new Article("Smartphone", new BigDecimal("499.99"));
            Article p3 = new Article("Tablette", new BigDecimal("299.99"));

            // Persistance des Articles
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            em.getTransaction().commit();
            System.out.println("Articles insérés avec succès !");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void lireArticles(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            // Requête JPQL pour récupérer tous les Articles
            List<Article> Articles = em.createQuery("SELECT p FROM Article p", Article.class)
                    .getResultList();

            System.out.println("\nListe des Articles :");
            for (Article Article : Articles) {
                System.out.println(Article);
            }

            // Recherche d'un Article par ID
            System.out.println("\nRecherche du Article avec ID=2 :");
            Article Article = em.find(Article.class, 2L);
            if (Article != null) {
                System.out.println(Article);
            } else {
                System.out.println("Article non trouvé");
            }
        } finally {
            em.close();
        }
    }
}