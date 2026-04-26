package repository;

import entite.Client;
import entite.Compte;
import entite.Employe;

public interface IBanque {
    Compte scanCompte();
    Client scanClient();
    Employe scanEmploye();
    void addCompte();
    void addClient();
    void addEmploye();
    void printAllClient();
    void printAllEmploye();
    int menuPrincipal();
    void gestionClient();
    void gestionEmploye();
    void gestionCompte();
}
