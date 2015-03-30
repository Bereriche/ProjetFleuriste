/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author akram
 */
public class Membre {

    public Membre() {
    }
    
   private int id_membre;
   private String nom,prenom,adresse,status;

    public Membre(int id_membre, String nom, String prenom, String adresse, String status) {
        this.id_membre = id_membre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.status = status;
    }

    public Membre(int id_membre, String nom, String prenom) {
        this.id_membre = id_membre;
        this.nom = nom;
        this.prenom = prenom;
    }

  
        

    public int getId_membre() {
        return id_membre;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getStatus() {
        return status;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Membre{" + "id_membre=" + id_membre + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", status=" + status + '}';
    }
   
    
}
