package com.sena.sigce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Citacion;

public interface citacionRepository extends CrudRepository<Citacion, Integer> {
    
    @Query("SELECT c FROM Citacion c WHERE c.idCitacion = :idCitacion")
    Citacion findByDocumento(Integer idCitacion);
}
