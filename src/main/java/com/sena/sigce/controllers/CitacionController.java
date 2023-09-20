package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.IArticuloService;
import com.sena.sigce.service.ICitacionService;
import com.sena.sigce.service.IInstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sigce.model.Citacion;


@Controller
@RequestMapping("/Citacion")
public class CitacionController {
    
    @PersistenceContext
    private EntityManager em;

   
    @Autowired
    private ICitacionService citaciond;
    @Autowired
    private IArticuloService articulod;
    @Autowired
    private IAprendizService aprendizd;
    @Autowired
    private IInstructorService instructord;

    
    //Vista formulario Registrar Citacion
    @GetMapping(value="/registrarCitacion")
    public String registrar(Model model){
       Citacion citacion = new Citacion();
        model.addAttribute("citacion", citaciond);
        model.addAttribute("articulo", articulod.findAll());
        return "citacion/registrarCitacion";
    }

    //Agregar citacion
    @PostMapping("/add")
    public String add(Citacion citacion){
        citaciond.save(citacion);
        return "redirect:/Citacion/listarCitacionIns";
    }
    //Formulario
    @GetMapping(value="/registrar")
    public String registrar(){
        return "citacion/registrarCitacion";
    }

    //Listar
    @GetMapping(value ="/listarCitacion")
    public String listar(Model model){
        model.addAttribute("citacion", citaciond.findAll());
//        model.addAttribute("articulo", articulod);
//        model.addAttribute("aprendiz", aprendizd);
//        model.addAttribute("instructores", instructord);
        return "citacion/listarCitacion";
    }


     //Listar propias
    @GetMapping(value ="/listarCitacionIns")
    public String listarIns(Model model){
          model.addAttribute("citacion", citaciond.findAll());
//        model.addAttribute("articulo", articulod);
//        model.addAttribute("aprendiz", aprendizd);
//        model.addAttribute("instructores", instructord);
        return "citacion/listarCitacionIns";
        
    }


}
