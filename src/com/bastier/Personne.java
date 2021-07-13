package com.bastier;

public class Personne {

    private String nom, prenom, genre;
    private int annee_naissance;

    public Personne(String nom, String prenom, String genre, int annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        annee_naissance = annee;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGenre() {
        return genre;
    }

    public int getAnnee_naissance() {
        return annee_naissance;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", annee_naissance=" + annee_naissance +
                '}';
    }
}
