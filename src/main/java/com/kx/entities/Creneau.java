package com.kx.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by KX on 13/01/2017.
 */
public class Creneau extends AbstractEntity {
    private int hdebut;
    private int mdebut;
    private int hfin;
    private int mfin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    private Medecin medecin;

    @Column(name = "id_medecin", insertable = false,updatable = false)
    private long idMedecin;

    public Creneau() {
    }

    public Creneau(int hdebut, int mdebut, int hfin, int mfin, Medecin medecin) {
        this.hdebut = hdebut;
        this.mdebut = mdebut;
        this.hfin = hfin;
        this.mfin = mfin;
        this.medecin = medecin;
    }

    public int getHdebut() {
        return hdebut;
    }

    public void setHdebut(int hdebut) {
        this.hdebut = hdebut;
    }

    public int getMdebut() {
        return mdebut;
    }

    public void setMdebut(int mdebut) {
        this.mdebut = mdebut;
    }

    public int getHfin() {
        return hfin;
    }

    public void setHfin(int hfin) {
        this.hfin = hfin;
    }

    public int getMfin() {
        return mfin;
    }

    public void setMfin(int mfin) {
        this.mfin = mfin;
    }

    public long getIdMedecin() {
        return idMedecin;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public String toString (){
        return String.format("Créneau[%d, %d, %d, %d:%d, %d:%d]", id, version, idMedecin, hdebut,
                mdebut, hfin, mfin);
    }
}
