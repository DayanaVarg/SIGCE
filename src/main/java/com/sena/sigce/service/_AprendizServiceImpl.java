package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.sigce.model.Aprendiz;
import com.sena.sigce.repository.aprendizRepository;
  

@Service
public class _AprendizServiceImpl implements IAprendizService {

    @Autowired
    private aprendizRepository aprendizRepository;

    // Obtencion de datos para la consulta (Listar)
    @Override
    public List<Aprendiz> findAll() {
        return (List<Aprendiz>) aprendizRepository.findAll();
    }

     // Obtencion de datos para registrar un Aprendiz 

    @Override
    public Aprendiz save(Aprendiz aprendiz) {
       return aprendizRepository.save(aprendiz);
    }

    //Lista por identificacion

   @Override
    public Aprendiz findByDocumento(String identificacion_Apr) {
        return aprendizRepository.findByDocumento(identificacion_Apr);

    }

    @Override
    public Aprendiz findValidar(String documento, String tipoDoc, String password) {
        return aprendizRepository.findValidar(documento, tipoDoc, password);
    }

    @Override
    public Optional<Aprendiz> findById(String identificacion_Apr) {
        return aprendizRepository.findById(identificacion_Apr);
    }


}
