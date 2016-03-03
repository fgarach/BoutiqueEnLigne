/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Utilisateur;
import boutiqueEnLigne.exception.MailNonExistant;
import boutiqueEnLigne.exception.MotDePasseIncorrect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConnexionService {
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    public void Connexion(String mail, String mdp) throws MailNonExistant, MotDePasseIncorrect{
        Utilisateur u = utilisateurService.findByMail(mail);

        if (u==null){
            throw new MailNonExistant();
        }
        else if (!u.getMdp().equals(mdp)){
            throw new MotDePasseIncorrect();
        }
 
    }
    
}
