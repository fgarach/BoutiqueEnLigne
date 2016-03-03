/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Article;
import boutiqueEnLigne.enumeration.Genre;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface ArticleService extends CrudRepository<Article, Long>{
    
    public List<Article> findByCategorieId(Long id);
    public List<Article> findByCategorieIdOrderByPrixAsc(Long id);
    public List<Article> findByCategorieIdOrderByPrixDesc(Long id);
    public List<Article> findByNomContainingIgnoreCase(String nom);
    public List<Article> findByNomContainingIgnoreCaseOrderByPrixAsc(String nom);
    public List<Article> findByNomContainingIgnoreCaseOrderByPrixDesc(String nom);
    public List<Article> findByNomContainingIgnoreCaseAndCategorieId(String nom, Long id);
    public List<Article> findByNomContainingIgnoreCaseAndCategorieIdOrderByPrixAsc(String nom, Long id);
    public List<Article> findByNomContainingIgnoreCaseAndCategorieIdOrderByPrixDesc(String nom, Long id);
    public List<Article> findByGenre(Genre genre);
//    public List<Article> findByGenreOrderByPrixAsc(Genre genre);
//    public List<Article> findByGenreOrderByPrixDesc(Genre genre);
//    public List<Article> findByNomContainingIgnoreCaseAndGenre(String nom, Genre genre);
//    public List<Article> findByNomContainingIgnoreCaseAndGenreOrderByPrixAsc(String nom, Genre genre);
//    public List<Article> findByNomContainingIgnoreCaseAndGenreOrderByPrixDesc(String nom, Genre genre);
    
}
