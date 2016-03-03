/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.CodePromo;
import boutiqueEnLigne.entity.Commande;
import boutiqueEnLigne.entity.SousCommande;
import static boutiqueEnLigne.enumeration.TypeCode.POURCENTAGE;
import boutiqueEnLigne.exception.CodePromoInvalide;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CommandeService2 {
    
    @Autowired
    CommandeService commandeService;
    
    @Autowired
    CodePromoService codePromoService;
    
    //public void ajouterArticle => quantité 
    
    //public void supprimerSousCommande

    
    public void calculPrixTotalSansRemise(Commande c){
        c.setPrixtotalsansremise(0.0);
        Double prixProv = 0.0;
        List<SousCommande> sousCommandes = new ArrayList<SousCommande>();
        sousCommandes = c.getSouscommandes();
        for (SousCommande tmp : sousCommandes) {
            Double prixArt =tmp.getArticle().getPrix();
            Double prixSousCom = prixArt*tmp.getQuantite();
            prixProv = prixProv + prixSousCom;
        }
        c.setPrixtotalsansremise(prixProv);
    }
    
    public void calculPrixTotalAvecRemise(Commande c, String cp) throws CodePromoInvalide{
        
        this.calculPrixTotalSansRemise(c);
        Double prixSansRemise  = c.getPrixtotalsansremise();
        
        
        CodePromo codepromo = codePromoService.findByCode(cp);
        Double prixavecremise = 0.0;
        if (codepromo==null){
            throw new CodePromoInvalide();
        }
        else {
            if (codepromo.getTypecode() == POURCENTAGE ){
                prixavecremise = prixSansRemise *((100-codepromo.getValeur())/100);
            }
            else{
                prixavecremise = prixSansRemise - codepromo.getValeur();
            }
        }
        if (prixavecremise<0){
            c.setPrixtotalavecremise(0.0);
        }
        else{
            c.setPrixtotalavecremise(prixavecremise);
        }
        commandeService.save(c);

    }
    
}
