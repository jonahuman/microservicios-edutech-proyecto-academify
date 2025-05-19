package com.cursos.service.courses.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cursos.service.courses.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    /*
    * findAll() --> Retorna todos los cursos
    * findById(Integer id) --> Retorna un curso según su id
    * save(Curso curso) --> Guarda o agrega un nuevo curso.
    * Si el id ya existe, actualiza el curso
    * deleteById(Integer id) --> Elimina un curso según su id
    */
}