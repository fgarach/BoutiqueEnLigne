/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.test;

import boutiqueEnLigne.entity.Article;
import boutiqueEnLigne.entity.Categorie;
import boutiqueEnLigne.entity.CodePromo;
import boutiqueEnLigne.entity.Commande;
import boutiqueEnLigne.entity.ModeLivraison;
import boutiqueEnLigne.entity.SousCommande;
import boutiqueEnLigne.entity.Utilisateur;
import boutiqueEnLigne.enumeration.Genre;
import boutiqueEnLigne.enumeration.TypeCode;
import boutiqueEnLigne.service.ArticleService;
import boutiqueEnLigne.service.ArticleService2;
import boutiqueEnLigne.service.CategorieService;
import boutiqueEnLigne.service.CodePromoService;
import boutiqueEnLigne.service.CommandeService;
import boutiqueEnLigne.service.DBService;
import boutiqueEnLigne.service.GenerationNouveauCodePromoService;
import boutiqueEnLigne.service.ModeLivraisonService;
import boutiqueEnLigne.service.SousCommandeService;
import boutiqueEnLigne.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import boutiqueEnLigne.spring.SpringConfig;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleService2 articleService2;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ModeLivraisonService modeLivraisonService;
    @Autowired
    private SousCommandeService sousCommandeService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private CodePromoService codePromoService;
    @Autowired
    private DBService dbService;
    @Autowired
    private GenerationNouveauCodePromoService genecodepromoService;

    @Before
    public void initialiserDB() {
        dbService.deleteAll();
        Utilisateur u1 = new Utilisateur(1L, "xx@.fr", "mdp", "addresse", "nom", "prenom", "33000", "bordeaux", "060629594");
        utilisateurService.save(u1);
        Categorie c1 = new Categorie(1L, "vetement");
        categorieService.save(c1);
        Article a1 = new Article(1L, c1, 10L, 10.0, "pantalon bleu", Genre.HOMME);
        articleService.save(a1);
        Article a2 = new Article(2L, c1, 10L, 10.0, "pantalon rose", Genre.FEMME);
        articleService.save(a2);
        Article a3 = new Article(3L, c1, 10L, 10.0, "pantalon court", Genre.ENFANT);
        articleService.save(a3);
        Article a4 = new Article(4L, c1, 10L, 10.0, "pantalon rouge", Genre.MIXTE);
        articleService.save(a4);
        Article a5 = new Article(5L, c1, 10L, 10.0, "chapeau rouge", Genre.MIXTE);
        articleService.save(a5);
        ModeLivraison m1 = new ModeLivraison(1L, "chronopost", 2.5);
        modeLivraisonService.save(m1);
        Commande co1 = new Commande(1L, Date.from(Instant.now()), u1, m1, false, false);
        commandeService.save(co1);
        SousCommande s1 = new SousCommande(1L, a1, co1, 2L);
        sousCommandeService.save(s1);
        SousCommande s2 = new SousCommande(2L, a2, co1, 4L);
        sousCommandeService.save(s2);
    }

    //@Test
    public void doNadaOK() {

    }

    //@Test
    public void testFindCommandesOk() {
        System.out.println("***********************************");

        List<Commande> commandes = commandeService.findByLivre(false);
        for (Commande tmp : commandes) {
            System.out.println(tmp.getDateCommande());
        }
    }

    //@Test
    public void testFindArticleOk() {
        System.out.println("***********************************");

        List<Article> articles = articleService.findByCategorieId(1L);
        for (Article tmp : articles) {
            System.out.println(tmp.getNom());
        }
        System.out.println("***********************************");

        List<Article> articles2 = articleService.findByNomContainingIgnoreCase("pant");
        for (Article tmp : articles2) {
            System.out.println(tmp.getNom());
        }
        System.out.println("***********************************");

        List<Article> articles3 = articleService.findByNomContainingIgnoreCaseAndCategorieId("rouge", 1L);
        for (Article tmp : articles3) {
            System.out.println(tmp.getNom());
        }
        System.out.println("***********************************");

        List<Article> articles4 = articleService.findByGenre(Genre.HOMME);
        for (Article tmp : articles4) {
            System.out.println(tmp.getNom());
        }
         System.out.println("*********************xxxxxxxxxxxxxx**************");

        List<Article> articles5 = articleService2.findByGenreOrderByPrixAsc(Genre.FEMME);
        for (Article tmp : articles5) {
            System.out.println(tmp.getNom());
        }
        System.out.println("*********************xxxxxxxxxxxxxx**************");

        List<Article> articles6 = articleService2.findByGenreOrderByPrixAsc(Genre.HOMME);
        for (Article tmp : articles6) {
            System.out.println(tmp.getNom());
        }
        
    }
    
    //@Test
    public void testRechbyMail(){
        Utilisateur u = utilisateurService.findByMail("xx@.fr");
        
            System.out.println(u.getNom());
        
    }
    //@Test
    public void testGenerationMDP(){
        
        genecodepromoService.generate(6, TypeCode.REMISE,50.0);

    }
    
    //@Test
    public void testFindCode(){
        CodePromo promos = codePromoService.findByCode("pA3f7U");
        
            System.out.println(promos.getCode());
        
    }
    
    @Test
    public void testFonctionnalite(){
        
    }

}
