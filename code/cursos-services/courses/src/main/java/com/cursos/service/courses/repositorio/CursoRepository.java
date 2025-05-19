package com.cursos.service.courses.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cursos.service.courses.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}