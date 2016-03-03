/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.CodePromo;
import boutiqueEnLigne.enumeration.TypeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class GenerationNouveauCodePromoService {
    
    @Autowired
    CodePromoService codePromoService;
    
    public void generate(int length, TypeCode tc, Double valeur)
{
	    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
	    String pass = "";
	    for(int x=0;x<length;x++)
	    {
	       int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
	       pass += chars.charAt(i);
	    }
	    System.out.println(pass);
            CodePromo cp = new CodePromo();
            cp.setCode(pass);
            cp.setTypecode(tc);
            cp.setValeur(valeur);
            codePromoService.save(cp);
	    
}
    
}
