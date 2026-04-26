package repository;

import entite.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BanqueImpListe implements IBanque{
    Map<String, Compte> comptes = new HashMap<>();
    Map<String, Client> clients = new HashMap<>();
    Map<String, Employe> employes = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public Compte scanCompte() {
        System.out.println("Entrez le numero du compte");
        String numcompte = sc.nextLine();
        System.out.println("Entrez le solde du compte");
        double sold = sc.nextDouble();
        sc.nextLine();
        System.out.println("Entrez le type du compte");
        String type = sc.nextLine();
        Compte c;
        if (type.equalsIgnoreCase("epargne")) {
            c = new CompteEpargne();
        }else {
            c = new CompteCourant();
        }
        c.setNumCompte(numcompte);
        c.setSolde(sold);
        c.setTypeCompte(type);
        return c;
    }

    @Override
    public Client scanClient() {
        Client c;
        System.out.println("Entrez le nom du client");
        String nom = sc.nextLine();
        System.out.println("Entrez le prenom du client");
        String prenom = sc.nextLine();
        System.out.println("Entrez l'email du client");
        String email = sc.nextLine();
        System.out.println("Entrez le telephone du client");
        double telephone = sc.nextDouble();
        sc.nextLine();
        System.out.println("Entrez l'adresse du client");
        String adresse = sc.nextLine();
        System.out.println("Entrez le mode de paiement du client");
        String mode = sc.nextLine();
        c = new Client(nom, prenom, email, telephone, adresse, mode);
        return c;
    }

    @Override
    public Employe scanEmploye() {
        System.out.println("Entrez le nom de l'employe");
        String nom = sc.nextLine();
        System.out.println("Entrez le prenom de l'employe");
        String prenom = sc.nextLine();
        System.out.println("Entrez l'email de l'employe");
        String email = sc.nextLine();
        System.out.println("Entrez le telephone de l'employe");
        double telephone = sc.nextDouble();
        sc.nextLine();
        System.out.println("Entrez le salaire de l'employe");
        double salaire = sc.nextDouble();
        sc.nextLine();
        Employe e = new Employe(nom, prenom, email, telephone, salaire);
        return e;
    }

    @Override
    public void addCompte() {
        Compte c = scanCompte();
        comptes.put(c.getNumCompte(), c);
        System.out.println("COMPTE AJOUTE AVEC SUCCES");
    }

    @Override
    public void addClient() {
        Client c = scanClient();
        clients.put(c.getEmail(), c);
        System.out.println("CLIENT AJOUTE AVEC SUCCES");
    }

    @Override
    public void addEmploye() {
        Employe e = scanEmploye();
        employes.put(e.getEmail(), e);
        System.out.println("EMPLOYE AJOUTE AVEC SUCCES");
    }

    @Override
    public void printAllClient() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client trouve");
        } else {
            clients.values().forEach(System.out::println);
        }
    }

    @Override
    public void printAllEmploye() {
        if (employes.isEmpty()) {
            System.out.println("Aucun employe trouve");
        } else {
            employes.values().forEach(System.out::println);
        }
    }

    @Override
    public int menuPrincipal() {
        int choix;
        do {
            System.out.println("1. Gerer les client");
            System.out.println("2. Gerer les employes");
            System.out.println("3. Gerer les comptes");
            System.out.println("4. Quitter !");
            choix = sc.nextInt();
        }while (choix < 1 || choix > 4);
        return choix;
    }

    @Override
    public void gestionClient() {
        int choice;
        do {
            do {
                System.out.println("1. Ajouter un client");
                System.out.println("2. Afficher un client");
                System.out.println("3. Supprimer un client ");
                System.out.println("4. Modifier un client ");
                System.out.println("5. Quitter !");
                System.out.println("Faites votre choix");
                choice = sc.nextInt();
                sc.nextLine();
            }while (choice < 1 || choice > 5);
            switch (choice) {
                case 1:
                    System.out.println("AJOUTER UN CLIENT");
                    Client c = scanClient();
                    Compte comptecli = scanCompte();
                    Map<String, Compte> mapcomptecli = c.getComptes();
                    mapcomptecli.put(comptecli.getNumCompte(), comptecli);
                    c.setComptes(mapcomptecli);
                    clients.put(c.getEmail(),c);
                    comptes.put(comptecli.getNumCompte(), comptecli);
                    System.out.println("CLIENT AJOUTER AVEC SUCCES");
                    break;
                case 2:
                    System.out.println("AFFICHER UN CLIENT");
                    clients.values().forEach(System.out::println);
                    //clients.forEach((key, value) -> System.out.println(value));
                    /*for (Client cli : clients.values()) {
                        System.out.println(cli);
                    }*/
                    break;
                case 3:
                    System.out.println("SUPPRIMER UN CLIENT");
                    System.out.println("Entrez l'email du client a supprimer");
                    String emailSup = sc.nextLine();
                    if (clients.containsKey(emailSup)) {
                        clients.remove(emailSup);
                        System.out.println("CLIENT SUPPRIME AVEC SUCCES");
                    } else {
                        System.out.println("CLIENT INTROUVABLE");
                    }
                    break;

                case 4:
                    System.out.println("MODIFIER UN CLIENT");
                    System.out.println("Entrez l'email du client a modifier");
                    String emailMod = sc.nextLine();
                    if (clients.containsKey(emailMod)) {
                        Client cMod = scanClient();
                        clients.put(emailMod, cMod);
                        System.out.println("CLIENT MODIFIE AVEC SUCCES");
                    } else {
                        System.out.println("CLIENT INTROUVABLE");
                    }
                    break;
            }
        }while (choice != 5);

    }

    @Override
    public void gestionEmploye() {
        int choix;
        do {
            do {
                System.out.println("1. Ajouter un employe");
                System.out.println("2. Afficher un employe");
                System.out.println("3. Supprimer un employe ");
                System.out.println("4. Modifier un employe  ");
                System.out.println("5. Quitter !");
                System.out.println("Faites votre choix");
                choix = sc.nextInt();
                sc.nextLine();
            }while (choix < 1 || choix > 5);
            switch(choix) {
                case 1:
                    System.out.println("AJOUTER UN EMPLOYE");
                    Employe e = scanEmploye();
                    Compte compteemp = scanCompte();
                    Map<String, Compte> mapcompteemp = e.getComptes();
                    mapcompteemp.put(compteemp.getNumCompte(), compteemp);
                    e.setComptes(mapcompteemp);
                    employes.put(e.getEmail(), e);
                    comptes.put(compteemp.getNumCompte(), compteemp);
                    System.out.println("EMPLOYE AJOUTER AVEC SUCCES");
                    break;
                case 2:
                    System.out.println("AFFICHER UN EMPLOYE");
                    employes.values().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("SUPPRIMER UN EMPLOYE");
                    System.out.println("Entrez l'email de l'employe a supprimer");
                    String emailSup = sc.nextLine();
                    if (employes.containsKey(emailSup)) {
                        employes.remove(emailSup);
                        System.out.println("EMPLOYE SUPPRIME AVEC SUCCES");
                    } else {
                        System.out.println("EMPLOYE INTROUVABLE");
                    }
                    break;

                case 4:
                    System.out.println("MODIFIER UN EMPLOYE");
                    System.out.println("Entrez l'email de l'employe a modifier");
                    String emailMod = sc.nextLine();
                    if (employes.containsKey(emailMod)) {
                        Employe eMod = scanEmploye();
                        employes.put(emailMod, eMod);
                        System.out.println("EMPLOYE MODIFIE AVEC SUCCES");
                    } else {
                        System.out.println("EMPLOYE INTROUVABLE");
                    }
                    break;
            }
        }while (choix != 5);


    }

    @Override
    public void gestionCompte() {
        int choix;
        do {
            do {
                System.out.println("1. Ajouter un compte");
                System.out.println("2. Afficher tous les compte");
                System.out.println("3. Supprimer un compte ");
                System.out.println("4. Modifier un compte ");
                System.out.println("5. Quitter !");
                choix = sc.nextInt();
            }while (choix < 1 || choix > 5);
            switch(choix) {
                case 1:
                    System.out.println("AJOUTER UN COMPTE");
                    Compte c = scanCompte();
                    comptes.put(c.getNumCompte(), c);
                    System.out.println("COMPTE AJOUTE AVEC SUCCES");
                    break;
                case 2:
                    System.out.println("AFFICHER LES COMPTES");
                    comptes.values().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("SUPPRIMER UN COMPTE");
                    System.out.println("Entrez le numero du compte");
                    String numSup = sc.next();
                    if (comptes.containsKey(numSup)) {
                        comptes.remove(numSup);
                        System.out.println("COMPTE SUPPRIME AVEC SUCCES");
                    } else {
                        System.out.println("COMPTE INTROUVABLE");
                    }
                    break;
                case 4:
                    System.out.println("MODIFIER UN COMPTE");
                    System.out.println("Entrez le numero du compte");
                    String numMod = sc.next();
                    if (comptes.containsKey(numMod)) {
                        Compte cMod = scanCompte();
                        comptes.put(numMod, cMod);
                        System.out.println("COMPTE MODIFIE AVEC SUCCES");
                    } else {
                        System.out.println("COMPTE INTROUVABLE");
                    }
                    break;
            }
        }while (choix != 5);


    }
}
