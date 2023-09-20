package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sigce.service.ICitacionService;
import com.sena.sigce.service.IFuncionarioService;
import com.sena.sigce.service.IProgramaService;


@Controller
@RequestMapping("/Funcionario")
public class FuncionarioController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IFuncionarioService funcionariod;

    @Autowired
    private ICitacionService citaciond;

    @GetMapping(value="/menuFuncionario")
    public String menu(Model model){
        model.addAttribute("citacion", citaciond.findAll());
        return "citacion/listarCitacion";
    }
    
}
