package com.sena.sigce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.sigce.model.Citacion;
import com.sena.sigce.repository.citacionRepository;

@Service
public class _CitacionServiceImpl implements ICitacionService{

    @Autowired
    private citacionRepository citacionD;

    @Override
    public List<Citacion> findAll() {
        return (List<Citacion>)citacionD.findAll();
    }

    @Override
    public Citacion save(Citacion citacion) {
       return citacionD.save(citacion);
    }

    @Override
     public Citacion findByDocumento(Integer idCitacion) {
        return citacionD.findByDocumento(idCitacion);
    }

   
    
}
