/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    
    @OneToMany (mappedBy = "commande")
    List<SousCommande> souscommandes = new ArrayList<SousCommande>();
    
    @ManyToOne
    @JoinColumn ( name = "utilisateur_id")
    private Utilisateur client;
    
    @ManyToOne
    @JoinColumn ( name = "modelivraison_id")
    private ModeLivraison modelivraison;
    
    private Double prixtotalsansremise;
    
    private Double prixtotalavecremise;
    
    private boolean paye;
    
    private boolean livre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Double getPrixtotalsansremise() {
        return prixtotalsansremise;
    }

    public void setPrixtotalsansremise(Double prixtotalsansremise) {
        this.prixtotalsansremise = prixtotalsansremise;
    }

    public Double getPrixtotalavecremise() {
        return prixtotalavecremise;
    }

    public void setPrixtotalavecremise(Double prixtotalavecremise) {
        this.prixtotalavecremise = prixtotalavecremise;
    }
    
    
    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public List<SousCommande> getSouscommandes() {
        return souscommandes;
    }

    public void setSouscommande(List<SousCommande> souscommandes) {
        this.souscommandes = souscommandes;
    }

    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }

    public ModeLivraison getModelivraison() {
        return modelivraison;
    }

    public void setModelivraison(ModeLivraison modelivraison) {
        this.modelivraison = modelivraison;
    }

    public Commande(Long id, Date dateCommande, Utilisateur client, ModeLivraison modelivraison, boolean paye, boolean livre) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.client = client;
        this.modelivraison = modelivraison;
        this.paye = paye;
        this.livre = livre;
    }
    
    public Commande() {
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boutiqueEnLigne.entity.Commande[ id=" + id + " ]";
    }
    
}
