/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Article;
import boutiqueEnLigne.entity.CodePromo;
import boutiqueEnLigne.entity.Commande;
import boutiqueEnLigne.entity.SousCommande;
import boutiqueEnLigne.exception.StockInsuffisant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PaiementService {
    
    @Autowired
    CommandeService commandeService;
    @Autowired
    GestionStockService gestionStockService;
    
    public void calculPrixTotal(Commande c, CodePromo cp){
        
    }
    
    public void paiement(Commande c) throws StockInsuffisant{
        
        List<SousCommande> sousCommandes = new ArrayList<SousCommande>();
        sousCommandes = c.getSouscommandes();
        for (SousCommande tmp : sousCommandes) {
            Long q = tmp.getQuantite();
            Article a = tmp.getArticle();
            gestionStockService.enleveStock(a, q);
        }
        c.setPaye(true);
        commandeService.save(c);
        
        
    }
    
}
