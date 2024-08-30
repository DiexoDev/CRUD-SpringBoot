package com.app.CRUD_SpringBoot.service;

import com.app.CRUD_SpringBoot.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    public List<Estudiante> listarTodosLosEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerEstudiantePorId(Long id);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Long id);

}
