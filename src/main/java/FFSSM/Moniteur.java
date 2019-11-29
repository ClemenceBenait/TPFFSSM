/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public List<Embauche> employeurs = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur, ou null
     */
    public Club employeurActuel() {
         if(employeurs.isEmpty()){
             return null;
         } else {
         if(employeurs.get(employeurs.size()-1).estTerminee()){
             return null;
         } else {
                 return employeurs.get(employeurs.size()-1).getEmployeur();
         }
         }
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {  
        if (! employeurs.isEmpty()) {
            Embauche derniereEmbauche = employeurs.get(employeurs.size() - 1);
            if (null == derniereEmbauche.getFin())
                derniereEmbauche.setFin(debutNouvelle);            
        }
        
         Embauche newEmbauche = new Embauche(debutNouvelle, this, employeur);
        employeurs.add(newEmbauche);	    
    }

    public List<Embauche> emplois() {
         return employeurs;
    }

}
