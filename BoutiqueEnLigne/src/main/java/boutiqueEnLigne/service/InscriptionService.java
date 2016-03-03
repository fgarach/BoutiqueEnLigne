/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Utilisateur;
import boutiqueEnLigne.exception.UtilisateurDejaInscritException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {
    
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private MailService mailService;
    
    public void inscriptionUtilisateur(Utilisateur u) throws UtilisateurDejaInscritException {

        //Utilisateur tmp = rechercherParLogin(u.getLogin());
        //Utilisateur tmp = rechercherParLogin(u.getLogin());
        if(utilisateurService.findByMail(u.getMail())!= null){
            throw new UtilisateurDejaInscritException();
        }
        else{
            utilisateurService.save(u);
            mailService.envoyerMail(u, "Inscription au forum", "Veuillez valider sur le lien");
        }    
        
    }
    
}
