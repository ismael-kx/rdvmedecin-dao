package com.kx.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by KX on 13/01/2017.
 */
@Entity
@Table(name = "medecins")
public class Medecin extends Personne {
    private static final long serialVersionUID = 1L;

    public Medecin(){
    }

    public Medecin(String titre, String nom, String prenom) {
        super(titre, nom, prenom);
    }

    @Override
    public String toString() {
        return String.format("Medecin [%s] ", super.toString());
    }
}
