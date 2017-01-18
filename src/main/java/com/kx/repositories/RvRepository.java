package com.kx.repositories;

import com.kx.entities.Rv;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by KX on 13/01/2017.
 */
public interface RvRepository extends CrudRepository<Rv,Long> {

    @Query("select rv from Rv rv left join rv.client c left join rv.creneau cr where rv.medecin.id=?1 and rv.jour=?2")
    public Iterable<Rv> getRvMedecinJour(long idMedecin, Date jour);
}
