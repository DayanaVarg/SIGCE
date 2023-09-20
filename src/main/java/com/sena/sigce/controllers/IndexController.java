package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sigce.model.Aprendiz;
import com.sena.sigce.model.Funcionario;
import com.sena.sigce.model.Instructor;
import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.IFuncionarioService;
import com.sena.sigce.service.IInstructorService;

@Controller
@RequestMapping("/")
public class IndexController {

       @PersistenceContext
    private EntityManager em;

    @Autowired
    private IInstructorService instructord;

    @Autowired
    private IAprendizService aprendizd;
    
    @Autowired
    private IFuncionarioService funcionarod;
    
    
    @GetMapping(value = "/login")
    public String index(){
        return "index";
    }

    @PostMapping("/validarServlet")
    public String validacion(Model model, String documento, String tipoDoc, String password){

         // Buscar el usuario para la validación
        Funcionario funcionario = funcionarod.findValidar(documento, tipoDoc, password);
        Instructor instructor = instructord.findValidar(documento, tipoDoc, password);
        Aprendiz aprendiz = aprendizd.findValidar(documento, tipoDoc, password);
        

         if (funcionario != null) {
             // El usuario es un Funcionario o Aprendiz, redireccionar al menú correspondiente.
            return "redirect:/Funcionario/menuFuncionario";
         } else if (instructor != null) {
             // El usuario no es un Funcionario o no existe, redireccionar al formulario de registro.
            return "redirect:/Instructor/menuInstructor";
         } else if (aprendiz != null) {
             // El usuario no es un Funcionario o no existe, redireccionar al formulario de registro.
            return "redirect:/Aprendiz/menuAprendiz";
         }else{
            model.addAttribute("MensajeError", "La información del usuario es inválida");
         }

         return "index";
    }
}
