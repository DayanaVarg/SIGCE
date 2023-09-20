package com.sena.sigce.controllers;

import com.sena.sigce.model.Instructor;
import com.sena.sigce.service.IArticuloService;
import com.sena.sigce.service.ICitacionService;
import com.sena.sigce.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("/Instructor")
public class InstructorController {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IInstructorService instructord;

    @Autowired
    private ICitacionService citaciond;
    
    @Autowired
    private IArticuloService articulod;


    // Agregar instructor

    @PostMapping("/registroInstructor")
    public String registroIns(@ModelAttribute Instructor instructor, Model model){
        if(instructor != null){
            instructord.save(instructor);
            model.addAttribute("MensajeExitoso", "Se ha registrado exitosamente.");
        }else{
            model.addAttribute("MensajeError", "Error en el registro del instructor.");
        }
        
        return "index";
    }

    //LISTAR INSTRUCTORES

    @GetMapping(value="/listarInstructores")
    public String listar(Model m){
        m.addAttribute("instructor", instructord.findAll());
        return "instructor/listarInstructores";
    }

     @GetMapping(value="/menuInstructor")
    public String menu(Model model){
        model.addAttribute("citacion", citaciond);
        model.addAttribute("articulo", articulod.findAll());
        return "citacion/registrarCitacion";
    }

     @GetMapping(value="/actualizarIns")
    public String datosApr(@RequestParam("identificacion_Ins") String identificacion_Ins,  Model m){
        m.addAttribute("instructor", instructord.findByDocumento(identificacion_Ins));
    
        return "instructor/actualizarInstructor";
    }

    //Actualizar instructor
    @PostMapping("/actualizar")
    public String actualizar( Model model, Instructor instructor) {
        Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());
        
        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setCorreo_Ins(instructor.getCorreo_Ins());
            instructord.save(ins);

            return "redirect:/Instructor/listarInstructores";
        } else {
    
            // El instruct no existe
            return "redirect:/Instructor/listarInstructores";
        }
    }

    //actualizar esatdo instructor
    
    @PostMapping("/actualizarEst")
    public String actualizarEst( Model model, Instructor instructor) {
         Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());
        
        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setEstado(instructor.getEstado());
            instructord.save(ins);
    
           return "redirect:/Instructor/listarInstructores";
        } else {
  
            return "redirect:/Instructor/listarInstructores";
        }
    }
}
