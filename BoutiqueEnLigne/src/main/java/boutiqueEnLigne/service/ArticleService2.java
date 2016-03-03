/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Article;
import boutiqueEnLigne.enumeration.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ArticleService2 {

    @PersistenceContext
    private EntityManager em;

    public List<Article> findByGenreOrderByPrixAsc(Genre genre) {
        if (genre == Genre.ENFANT) {
            Query query = em.createQuery("SELECT a FROM Article a WHERE a.genre =:mon_genre");
            query.setParameter("mon_genre", Genre.ENFANT);
            return query.getResultList();
        }
        if (genre == Genre.FEMME) {
            Query query = em.createQuery("SELECT a FROM Article a WHERE a.genre =:mon_genre");
            query.setParameter("mon_genre", Genre.FEMME);
            Query query2 = em.createQuery("SELECT a FROM Article a WHERE a.genre =:mon_genre2");
            query2.setParameter("mon_genre2", Genre.MIXTE);
            List<Article> articles = new ArrayList<>();
            articles = query.getResultList();
            List<Article> articles2 = new ArrayList<>();
            articles2 = query2.getResultList();
            articles2.addAll(articles);
            return articles2;
        }
        if (genre == Genre.HOMME) {
            Query query = em.createQuery("SELECT a FROM Article a WHERE a.genre =:mon_genre");
            query.setParameter("mon_genre", Genre.HOMME);
            Query query2 = em.createQuery("SELECT a FROM Article a WHERE a.genre =:mon_genre2");
            query2.setParameter("mon_genre2", Genre.MIXTE);
            List<Article> articles = new ArrayList<>();
            articles = query.getResultList();
            List<Article> articles2 = new ArrayList<>();
            articles2 = query2.getResultList();
            articles2.addAll(articles);
            return articles2;
        }
        if (genre == Genre.MIXTE) {
            Query query = em.createQuery("SELECT a FROM Article a WHERE a.genre =:mon_genre");
            query.setParameter("mon_genre", Genre.MIXTE);
            return query.getResultList();
        } else {
            return em.createQuery("SELECT * FROM Article a").getResultList();
        }
    }

}
