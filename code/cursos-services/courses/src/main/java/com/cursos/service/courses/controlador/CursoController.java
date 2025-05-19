package com.cursos.service.courses.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursos.service.courses.entidades.Curso;
import com.cursos.service.courses.servicio.CursoServicio;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoServicio cursoService;
    
    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.getAll();
        if(cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable("id") int id) {
        Curso curso = cursoService.getCursoById(id);
        if(curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }
    
    @PostMapping
    public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.save(curso);
        return ResponseEntity.ok(nuevoCurso);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable("id") int id, @RequestBody Curso curso) {
        curso.setId(id);
        Curso cursoActualizado = cursoService.save(curso);
        return ResponseEntity.ok(cursoActualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable("id") int id) {
        cursoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
