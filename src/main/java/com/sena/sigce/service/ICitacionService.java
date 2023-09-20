package com.sena.sigce.service;

import java.util.List;

import com.sena.sigce.model.Citacion;

public interface ICitacionService {
    
    
    //LISTAR

    List<Citacion> findAll();

    //Registrar Citacion
    Citacion save (Citacion citacion);

     //Listar por identificacion
    Citacion findByDocumento(Integer idCitacion);
}
