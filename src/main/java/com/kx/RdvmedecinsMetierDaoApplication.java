package com.kx;

import com.kx.config.DomainAndPersistenceConfig;
import com.kx.entities.Client;
import com.kx.entities.Creneau;
import com.kx.entities.Rv;
import com.kx.metier.IMetier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication

public class RdvmedecinsMetierDaoApplication {

	public static void main(String[] args) {


		SpringApplication app = new SpringApplication(DomainAndPersistenceConfig.class);
        app.setLogStartupInfo(false);
        ConfigurableApplicationContext context = app.run(args);
        IMetier metier = context.getBean(IMetier.class);

         try {
             // ajouter un RV
             Date jour = new Date();
             System.out.println(String.format("Ajout d'un Rv le [%s] dans le créneau 1 pour le client 1", new SimpleDateFormat("dd/MM/yyyy").format(jour)));
             Client client = (Client) new Client().build(1L, 1L);
             Creneau creneau = (Creneau) new Creneau().build(1L, 1L);
             Rv rv = metier.ajouterRv(creneau, client,jour);
             System.out.println(String.format("Rv ajouté = %s", rv));
             // vérification
             creneau = metier.getCreneauById(1L);
             long idMedecin = creneau.getIdMedecin();
             display("Liste des rendez-vous", metier.getRvMedecinJour(idMedecin, jour));
             } catch (Exception ex) {
             System.out.println("Exception : " + ex.getCause());
             }
     // fermeture du contexte Spring
     context.close();
     }
            // méthode utilitaire - affiche les éléments d'une collection
            private static <T> void display(String message, Iterable<T> elements) {
            System.out.println(message);
            for (T element : elements) {
            System.out.println(element);
            }
         }


}
