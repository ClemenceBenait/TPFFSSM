package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;


public class Plongeur extends Personne{
	
    public int niveau;
    public GroupeSanguin groupeS;
    public List<Licence> licences = new LinkedList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
     public GroupeSanguin getGroupeS() {
        return groupeS;
    }

    public void setGroupeS(GroupeSanguin groupeS) {
        this.groupeS = groupeS;
    }
    
    public void ajoutLicence(Licence l) {
        licences.add(l);
        
    }
    
    public Licence derniereLicence() {
        return licences.get(licences.size()-1);
    }
}
