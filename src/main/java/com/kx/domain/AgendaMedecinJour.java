package com.kx.domain;

import com.kx.entities.Medecin;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KX on 13/01/2017.
 */
public class AgendaMedecinJour implements Serializable{
    private Medecin medecin;
    private Date jour;
    private CreneauMedecinJour[] creneauxMedecinJour;

    public AgendaMedecinJour() {
    }

    public AgendaMedecinJour(Medecin medecin, Date jour, CreneauMedecinJour[] creneauxMedecinJour) {
        this.medecin = medecin;
        this.jour = jour;
        this.creneauxMedecinJour = creneauxMedecinJour;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for(CreneauMedecinJour cr : creneauxMedecinJour){
            str.append(" ");
            str.append(cr.toString());
        }
        return String.format("Agenda [%s,%s,%s]",medecin, new SimpleDateFormat().format(jour),str);
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public CreneauMedecinJour[] getCreneauxMedecinJour() {
        return creneauxMedecinJour;
    }

    public void setCreneauxMedecinJour(CreneauMedecinJour[] creneauxMedecinJour) {
        this.creneauxMedecinJour = creneauxMedecinJour;
    }
}


