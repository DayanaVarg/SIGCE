package com.sena.sigce.service;

import java.util.List;
import com.sena.sigce.model.Funcionario;

public interface IFuncionarioService {
    
     // LISTAR
    List<Funcionario> findAll();

    // REGISTRAR FUNCIONARIO
    Funcionario save (Funcionario funcionario);
    //Listar por identificacion
    Funcionario findByDocumento(String identificacion_Fun);

    //Validar
    Funcionario findValidar(String documento, String tipoDoc, String password);
}
