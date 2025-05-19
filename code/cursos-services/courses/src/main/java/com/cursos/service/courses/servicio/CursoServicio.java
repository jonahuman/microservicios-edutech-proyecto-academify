package com.cursos.service.courses.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursos.service.courses.entidades.Curso;
import com.cursos.service.courses.repositorio.CursoRepository;

@Service
public class CursoServicio {
    @Autowired
    private CursoRepository cursoRepository;
    
    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }
    
    public Curso getCursoById(int id) {
        return cursoRepository.findById(id).orElse(null);
    }
    
    public Curso save(Curso curso) {
        Curso nuevoCurso = cursoRepository.save(curso);
        return nuevoCurso;
    }
    
    public void delete(int id) {
        cursoRepository.deleteById(id);
    }
}
