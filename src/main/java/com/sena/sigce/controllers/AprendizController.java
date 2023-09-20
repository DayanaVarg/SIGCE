package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sena.sigce.model.Ficha;
import com.sena.sigce.model.Programa;
import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.IFichaService;
import com.sena.sigce.service.IProgramaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sena.sigce.model.Aprendiz;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Aprendiz")
public class AprendizController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IAprendizService aprendizd;

    @Autowired
    private IFichaService fichad;

    @Autowired
    private IProgramaService programad;


    //Agregar aprendices 
    @PostMapping("/registrarAprendices")
     public String registroAp(Model model, Aprendiz aprendiz){
        try{
            aprendizd.save(aprendiz);
            model.addAttribute("MensajeExitoso", "Se ha registrado exitosamente.");
        }catch(Exception e){
            model.addAttribute("MensajeError", "Error en el registro del aprendiz.");
        }
        
        return "redirect:/Aprendiz/listarAprendices";
    }

    //Vista registro aprendices
    @GetMapping(value = "/registroAprendiz")
    public String registrar(Model m){
        // //Envía lista de fichas
        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);

        return "aprendiz/listarAprendiz";

    }

    //Menu Aprendiz
    @GetMapping(value="/menuAprendiz")
    public String menu(Model m){
        return "Aprendiz/registrarDescargos";
    }

    //Listar aprendices
    @GetMapping(value="/listarAprendices")
    public String listarAp(Model m){
       m.addAttribute("aprendiz", aprendizd.findAll());

        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);
        List<Programa> programa = programad.findAll();
        m.addAttribute("programa", programa);
        return "aprendiz/listarAprendiz";
    }

    //vista actualizar

    @GetMapping(value="/actualizarApr")
    public String datosApr(@RequestParam("identificacion_Apr") String identificacion_Apr,  Model m){
        m.addAttribute("aprendiz", aprendizd.findByDocumento(identificacion_Apr));
        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);
        List<Programa> programa = programad.findAll();
        m.addAttribute("programa", programa);
        return "aprendiz/actualizarAprendiz";
    }

    @PostMapping("/actualizar")
    public String actualizar( Model model, Aprendiz aprendiz) {
        Optional<Aprendiz> aprendizExistente = aprendizd.findById(aprendiz.getIdentificacion_Apr());
        
        if (aprendizExistente.isPresent()) {
            Aprendiz apre = aprendizExistente.get();
            apre.setCorreo_Apr(aprendiz.getCorreo_Apr());
            aprendizd.save(apre);
    
            return "redirect:/Aprendiz/listarAprendices";
        } else {
    
            // El aprendiz no existe
            return "redirect:/Aprendiz/listarAprendices";
        }
    }

    @PostMapping("/actualizarEst")
    public String actualizarEst( Model model, Aprendiz aprendiz) {
        Optional<Aprendiz> aprendizExistente = aprendizd.findById(aprendiz.getIdentificacion_Apr());
        
        if (aprendizExistente.isPresent()) {
            Aprendiz apre = aprendizExistente.get();
            apre.setEstado(aprendiz.getEstado());
            aprendizd.save(apre);
    
            return "redirect:/Aprendiz/listarAprendices";
        } else {
    
            // El aprendiz no existe
            return "redirect:/Aprendiz/listarAprendices";
        }
    }
}
