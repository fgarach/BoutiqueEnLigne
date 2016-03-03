/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Article;
import boutiqueEnLigne.exception.StockInsuffisant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class GestionStockService {
    
    @Autowired
    ArticleService articleService;
    
    public void ajouterStock(Article a, Long stockAdded){
        
       Long stockInit = a.getStock();
       Long stockNew = stockInit + stockAdded;
       a.setStock(stockNew);
       articleService.save(a);
        
    }
    
    public void enleveStock(Article a, Long stockRemoved) throws StockInsuffisant{
       Long stockInit = a.getStock();
       Long stockNew = stockInit - stockRemoved;
       if (stockNew<0){
           throw new StockInsuffisant();
       }
       else {
            a.setStock(stockNew);
            articleService.save(a);
       }
    }
}
