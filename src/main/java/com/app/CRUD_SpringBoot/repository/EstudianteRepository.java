package com.app.CRUD_SpringBoot.repository;

import com.app.CRUD_SpringBoot.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
//Estudiante la clase y el tipo de dato del ID que es Long.
}
