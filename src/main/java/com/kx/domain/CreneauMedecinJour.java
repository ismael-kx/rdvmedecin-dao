package com.kx.domain;

import com.kx.entities.Creneau;
import com.kx.entities.Rv;

import java.io.Serializable;

/**
 * Created by KX on 13/01/2017.
 */
public class CreneauMedecinJour implements Serializable {
    private Rv rv;
    private Creneau creneau;

    public CreneauMedecinJour() {
    }

    public CreneauMedecinJour(Rv rv, Creneau creneau) {
        this.rv = rv;
        this.creneau = creneau;
    }

    public Rv getRv() {
        return rv;
    }

    public void setRv(Rv rv) {
        this.rv = rv;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s] ",creneau,rv);
    }
}
