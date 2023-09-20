package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Instructor;

public interface IInstructorService {
    
    // LISTAR
    List<Instructor> findAll();

    // REGISTRAR INSTRUCTOR
    Instructor save (Instructor instructor);

    //Listar por identificacion
    Instructor findByDocumento(String identificacion_Ins);

    //Validar
    Instructor findValidar(String documento, String tipoDoc, String password);

    //lista Actualizar
    Optional<Instructor> findById(String identificacion_Ins);
}
