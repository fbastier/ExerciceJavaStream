package com.bastier;

public class Personne {

    private String nom, prenom, genre, ville;
    private int annee_naissance;
    private double salaire;

    public Personne(String nom, String prenom, String genre, int annee_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.annee_naissance = annee_naissance;
    }

    public Personne(String nom, String prenom, String genre, int annee, double salaire, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.salaire = salaire;
        this.ville = ville;
        annee_naissance = annee;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getAnnee_naissance() {
        return annee_naissance;
    }

    public void setAnnee_naissance(int annee_naissance) {
        this.annee_naissance = annee_naissance;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", ville='" + ville + '\'' +
                ", annee_naissance=" + annee_naissance +
                ", salaire=" + salaire +
                '}';
    }
}
