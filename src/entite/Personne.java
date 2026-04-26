package entite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {
    protected String nom;
    protected String prenom;
    protected String email;
    protected double tel;
    protected Map<String,Compte> comptes = new HashMap<>();

    
    public Map<String, Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Map<String, Compte> comptes) {
		this.comptes = comptes;
	}

	public Personne() {
    }

    public Personne(String nom, String prenom, String email, double tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }
}
