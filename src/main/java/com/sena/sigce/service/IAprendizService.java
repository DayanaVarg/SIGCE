package com.sena.sigce.service;


import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Aprendiz;

public interface IAprendizService {

    //Listar
    List<Aprendiz> findAll();

    // REGISTRAR APRENDIZ
    Aprendiz save (Aprendiz aprendiz);

    //Listar por identificacion
     Aprendiz findByDocumento(String identificacion_Apr);

     //Validacion
     Aprendiz findValidar(String documento, String tipoDoc, String password);

    //listar por id (actualizar)
    Optional<Aprendiz> findById(String identificacion_Apr);
}
