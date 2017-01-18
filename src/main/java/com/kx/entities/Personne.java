package com.kx.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by KX on 13/01/2017.
 */
@MappedSuperclass
public class Personne extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    @Column(length = 5)
    private String titre;
    @Column(length = 20)
    private String nom;
    @Column(length = 20)
    private String prenom;

    public Personne(String titre, String nom, String prenom) {
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne() {
    }

    @Override
    public String toString() {
        return "{" +
                "id='"+id +'\'' +
                "version='"+ version +'\''+
                "titre='" + titre + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
}
