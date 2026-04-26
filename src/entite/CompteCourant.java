package entite;

public class CompteCourant extends Compte {
    private double taxe = 0.1;

    @Override
    void retrait(double montant) {
        if ((montant*taxe + montant) > solde) {
            System.out.println("Solde insuffisant");
            return;
        }
        solde = solde - (montant*taxe + montant);
    }
}
