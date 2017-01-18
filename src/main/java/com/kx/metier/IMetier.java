package com.kx.metier;

import com.kx.domain.AgendaMedecinJour;
import com.kx.entities.Client;
import com.kx.entities.Creneau;
import com.kx.entities.Medecin;
import com.kx.entities.Rv;

import java.util.Date;
import java.util.List;

/**
 * Created by KX on 13/01/2017.
 */
public interface IMetier {

    public List<Client> getAllClients();

    public List<Medecin> getAllMedecins();

    public List<Creneau> getAllcreneaux(long idMedecin);

    public List<Rv> getRvMedecinJour(long idMedecin, Date jour);

    public Client getClientById(long id);

    public Medecin getMedecinById(long id);

    public Creneau getCreneauById(long id);

    public Rv getRvById(long id);

    public Rv ajouterRv(Creneau creneau,Client client, Date jour);

    public void supprimerRv(Rv rv);

    public AgendaMedecinJour getAgenaMedecinJour(long idMedecin, Date jour);

}
