package com.kx.metier;

import com.kx.domain.AgendaMedecinJour;
import com.kx.domain.CreneauMedecinJour;
import com.kx.entities.Client;
import com.kx.entities.Creneau;
import com.kx.entities.Medecin;
import com.kx.entities.Rv;
import com.kx.repositories.ClientRepository;
import com.google.common.collect.Lists;
import com.kx.repositories.CreneauRepository;
import com.kx.repositories.MedecinRepository;
import com.kx.repositories.RvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by KX on 14/01/2017.
 */
@Service
public class Metier implements IMetier{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    CreneauRepository creneauRepository;
    @Autowired
    RvRepository rvRepository;

    @Override
    public List<Client> getAllClients() {
        return Lists.newArrayList( clientRepository.findAll());
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return Lists.newArrayList(medecinRepository.findAll());
    }

    @Override
    public List<Creneau> getAllcreneaux(long idMedecin) {
        return Lists.newArrayList(creneauRepository.findAll());
    }

    @Override
    public List<Rv> getRvMedecinJour(long idMedecin, Date jour) {
        return Lists.newArrayList(rvRepository.getRvMedecinJour(idMedecin, jour));
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Medecin getMedecinById(long id) {
        return medecinRepository.findOne(id);
    }

    @Override
    public Creneau getCreneauById(long id) {
        return creneauRepository.findOne(id);
    }

    @Override
    public Rv getRvById(long id) {
        return rvRepository.findOne(id);
    }

    @Override
    public Rv ajouterRv(Creneau creneau, Client client, Date jour) {
        Rv rv = new Rv(creneau,client,jour);
        return rvRepository.save(rv);
    }

    @Override
    public void supprimerRv(Rv rv) {
        rvRepository.delete(rv);
    }

    @Override
    public AgendaMedecinJour getAgenaMedecinJour(long idMedecin, Date jour) {
        /*Je liste tous les creneaux du medecin
            Je liste tous ses RDV
            je crée un Map<idCreneauDeChaqueRDV,RDV>
            Desormais j'ai une Map avec tous ses RDV couplés à l'id des creneaux pendant lesquels se deroulent le RDV
         */
        List<Creneau> creneauxHoraires = getAllcreneaux(idMedecin);
        List<Rv> reservations = getRvMedecinJour(idMedecin,jour);
        Map<Long,Rv> hReservations = new Hashtable<Long,Rv>();

        for (Rv resa : reservations){
            hReservations.put(resa.getCreneau().getId(),resa);
        }

        /*
        Ici je cree un agenda pour le medecin.
        un agenda comporte tous les créneaux disponibles dans lesquels chaque creneaux occupé sont valorisé
        ou verrouillés pour une ecriture.

        Je sette tous les champs de l'agenda
        les creneaux sont vierges
        puis je recopie dans les creneaux, tous les creneaux specifiques
        Si l'un des ces creneaux figure dans la map precedente, cela signifie qu'il ya deja un rdv à ce creneau
        Je sette alors le RDV de cet creneau avec le RDV de la map qui porte le meme id de creneau
         */
        CreneauMedecinJour[] creneauxMedecinJour = new CreneauMedecinJour[creneauxHoraires.size()];
        AgendaMedecinJour agendaMedecinJour = new AgendaMedecinJour();
        agendaMedecinJour.setMedecin(getMedecinById(idMedecin));
        agendaMedecinJour.setJour(jour);
        agendaMedecinJour.setCreneauxMedecinJour(creneauxMedecinJour);

        for(int i=0; i<creneauxHoraires.size();i++) {
            creneauxMedecinJour[i] = new CreneauMedecinJour();
            Creneau creneauBusy = creneauxHoraires.get(i);
            creneauxMedecinJour[i].setCreneau(creneauBusy);
            Long idCreneauBusy = creneauBusy.getId();
            if (hReservations.containsKey(idCreneauBusy))
            {
                creneauxMedecinJour[i].setRv(hReservations.get(creneauBusy));
            }
        }
        return agendaMedecinJour;
    }
}
