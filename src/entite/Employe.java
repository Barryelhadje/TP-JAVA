package entite;

public class Employe extends Personne{
    private double salaire;

    public Employe() {
    }

    public Employe(String nom, String prenom, String email, double tel, double salaire) {
        super(nom, prenom, email, tel);
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "salaire=" + salaire +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", comptes=" + comptes +
                '}';
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
