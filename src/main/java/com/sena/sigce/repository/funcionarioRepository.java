package com.sena.sigce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Funcionario;


public interface funcionarioRepository extends CrudRepository<Funcionario, Integer>  {

    @Query("SELECT f FROM Funcionario f WHERE f.identificacion_Fun = :identificacion_Fun")
    Funcionario findByDocumento(String identificacion_Fun);

    @Query("SELECT f FROM Funcionario f WHERE f.identificacion_Fun = :documento and f.tipoIde_Fun = :tipoDoc and f.password_Fun= :password ")
    Funcionario findValidar(String documento, String tipoDoc, String password);
}
