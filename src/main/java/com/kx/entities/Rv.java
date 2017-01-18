package com.kx.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KX on 13/01/2017.
 */
public class Rv extends AbstractEntity {

    @Temporal(TemporalType.DATE)
    Date jour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creneau")
    private Creneau creneau;

    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private long id_client;

    @JoinColumn(name = "id_creneau" ,insertable =false,updatable = false)
    private long id_creneau;

    public Rv() {
    }

    public Rv(Creneau creneau, Client client, Date jour) {
        this.creneau = creneau;
        this.client = client;
        this.jour = jour;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public long getId_client() {
        return id_client;
    }

    public long getId_creneau() {
        return id_creneau;
    }
}

