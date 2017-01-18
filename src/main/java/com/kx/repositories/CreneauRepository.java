package com.kx.repositories;

import com.kx.entities.Creneau;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KX on 13/01/2017.
 */
public interface CreneauRepository extends CrudRepository<Creneau,Long> {
    @Query("select c from Creneau c where c.medecin.id = ?1")
    public Iterable<Creneau> getAllCreneaux(long idMedecin);

}
