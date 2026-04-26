package entite;

public abstract class Compte {
    protected double solde;
    protected String numCompte;
    protected String typeCompte;

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public void depot(double montant) {
        if (montant <= 0){
            System.out.println("Impossible de faire ce depot !");
            return;
        }
        this.solde = solde + montant;
    }

    abstract void retrait(double montant);

    public Compte() {
    }

    @Override
    public String toString() {
        return "Compte{" +
                "solde=" + solde +
                ", numCompte='" + numCompte + '\'' +
                ", typeCompte='" + typeCompte + '\'' +
                '}';
    }

    public Compte(double solde, String numCompte, String typeCompte) {
        this.solde = solde;
        this.numCompte = numCompte;
        this.typeCompte = typeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }
}
