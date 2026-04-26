package entite;

public class Client extends Personne {
    private String adresse;
    private String modePaiement;

    public Client() {
    }

    public Client(String nom, String prenom, String email, double tel, String adresse, String modePaiement) {
        super(nom, prenom, email, tel);
        this.adresse = adresse;
        this.modePaiement = modePaiement;
    }

    @Override
    public String toString() {
        return "Client{" +
                "adresse='" + adresse + '\'' +
                ", modePaiement='" + modePaiement + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", comptes=" + comptes +
                '}';
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }
}
