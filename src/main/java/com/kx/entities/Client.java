package com.kx.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by KX on 13/01/2017.
 */
@Component
@Table(name = "clients")
public class Client extends Personne {
    private static final long serialVersionUID = 1L;

    public Client(){
    }

    public Client(String titre, String nom, String prenom) {
        super(titre, nom, prenom);
    }

    @Override
    public String toString() {
        return String.format("Client [%s] ", super.toString());
    }


}
