package com.app.CRUD_SpringBoot.service;

import com.app.CRUD_SpringBoot.entity.Estudiante;
import com.app.CRUD_SpringBoot.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteRepository repository;

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repository.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repository.deleteById(id);
    }


}
