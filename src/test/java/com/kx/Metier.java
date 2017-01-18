package com.kx;

import com.kx.config.DomainAndPersistenceConfig;
import com.kx.domain.AgendaMedecinJour;
import com.kx.entities.Client;
import com.kx.entities.Creneau;
import com.kx.entities.Medecin;
import com.kx.metier.IMetier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by KX on 15/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DomainAndPersistenceConfig.class)
public class Metier {

    @Autowired
    private IMetier metier;

    private void display(String message, Iterable<?> elements){
        System.out.println(message);
        for (Object element : elements){
            System.out.println(element);
        }
        System.out.println("\n");
    }

    @Test
    public void test1(){
        List<Client> clientList = metier.getAllClients();
        display("La liste des clients : ", clientList);

        List<Medecin> medecinList = metier.getAllMedecins();
        display("La liste des medecins : ",medecinList);

        Medecin medecin = medecinList.get(0);
        System.out.println("Voici le medecin choisi : "+medecin);

        List<Creneau> creneauList = metier.getAllcreneaux(medecin.getId());
        display(String.format("la liste des creneaux du medecin %s",medecin), creneauList);

        Date jour = new Date();
        //Les RDV du medecin au jour J
        AgendaMedecinJour agendaMedecinJour = metier.getAgenaMedecinJour(medecin.getId(),jour);
        display(String.format("Les RDV du medecin %s le jour %s", medecin.getId(), jour),metier.getRvMedecinJour(medecin.getId(),jour));
    }
}
