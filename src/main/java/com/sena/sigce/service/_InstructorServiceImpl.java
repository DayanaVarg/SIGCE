package com.sena.sigce.service;

import com.sena.sigce.model.Instructor;
import com.sena.sigce.repository.instructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class _InstructorServiceImpl implements IInstructorService {


    @Autowired
    private instructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll() ;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findByDocumento(String identificacion_Ins) {
        return instructorRepository.findByDocumento(identificacion_Ins);
    }

    @Override
    public Instructor findValidar(String documento, String tipoDoc, String password) {
        return instructorRepository.findValidar(documento, tipoDoc, password);
    }

    @Override
    public Optional<Instructor> findById(String identificacion_Ins) {
        return instructorRepository.findById(identificacion_Ins);
    }

    
}
