import repository.BanqueImpListe;
import repository.IBanque;


public class Main {
    public static void main(String[] args) {
        IBanque master = new BanqueImpListe();
        int choix;
        do {
            choix = master.menuPrincipal();
            switch (choix) {
                case 1:
                    System.out.println("GESTION DES CLIENTS");
                    master.gestionClient();
                    break;
                case 2:
                    System.out.println("GESTION DES EMPLOYES");
                    master.gestionEmploye();
                    break;
                case 3:
                    System.out.println("GESTION DES COMPTES");
                    break;
                case 4:
                    System.out.println("*    AUREVOIR    *");
                    break;
            }
        }while (choix != 4);

    }
}