/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public Calendar date;

	public int profondeur;

	public int duree;
        
        public Set<Plongeur> palanquee = new HashSet<>();

	public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Plongeur participant) {
		palanquee.add(participant);
	}

	public Calendar getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
            boolean result=true;
		for (Plongeur p:palanquee){
                    if(! p.derniereLicence().estValide(Calendar.getInstance())){
                        result = false;
                        break;
                    }
                }
                return result;
	}

}
