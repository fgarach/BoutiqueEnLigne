/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.ModeLivraison;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface ModeLivraisonService extends CrudRepository<ModeLivraison, Long>{
    
}
