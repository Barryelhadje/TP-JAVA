package entite;

public class CompteEpargne extends Compte {
    @Override
    void retrait(double montant) {
        if (montant > solde) {
            System.out.println("Solde Insuffisant");
            return;
        }
        solde = solde - montant;
    }
}
