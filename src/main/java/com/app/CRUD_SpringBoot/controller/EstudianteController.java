package com.app.CRUD_SpringBoot.controller;

import com.app.CRUD_SpringBoot.entity.Estudiante;
import com.app.CRUD_SpringBoot.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model model){
        model.addAttribute("estudiantes",service.listarTodosLosEstudiantes());
        return "estudiantes";//Nos retorna al archivo estudiantes
    }
    //Metodo para mostrar el formulario para guardar estudiantes
    @GetMapping("/estudiantes_nuevo")
    public String crearEstudianteFormularioRegistro(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }
    //Metodo para guardar estudiantes en base de datos, al finalizar nos devuelve a estudiantes.
    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        service.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }
    //Metodo para mostrar el formulario de editar
    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("estudiante", service.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    //Metodo para editar un estudiante
    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo){
        Estudiante estudianteExistente = service.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        service.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    //Metodo para eliminar un estudiante
    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        service.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
