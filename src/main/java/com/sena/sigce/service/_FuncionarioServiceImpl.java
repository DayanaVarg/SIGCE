package com.sena.sigce.service;

import com.sena.sigce.model.Funcionario;
import com.sena.sigce.repository.funcionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class _FuncionarioServiceImpl implements IFuncionarioService {

    @Autowired
    private funcionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario findByDocumento(String identificacion_Fun) {
        return funcionarioRepository.findByDocumento(identificacion_Fun);
    }

    @Override
    public Funcionario findValidar(String documento, String tipoDoc, String password) {
      return funcionarioRepository.findValidar(documento, tipoDoc, password);
    }

   
}
