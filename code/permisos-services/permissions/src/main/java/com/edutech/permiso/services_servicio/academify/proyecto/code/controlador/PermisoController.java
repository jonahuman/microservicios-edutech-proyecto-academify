package com.edutech.permiso.services_servicio.academify.proyecto.code.controlador;

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

import com.edutech.permiso.services_servicio.academify.proyecto.code.entidad.Permiso;
import com.edutech.permiso.services_servicio.academify.proyecto.code.servicio.PermisoServicio;

@RestController
@RequestMapping("/api/permisos")  // Cambiado para usar una ruta base estándar
public class PermisoController {
    
    @Autowired
    private PermisoServicio permisoServicio;
    
    @GetMapping
    public ResponseEntity<List<Permiso>> listarPermisos() {
        List<Permiso> permisos = permisoServicio.getAll();
        if (permisos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(permisos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Permiso> obtenerPermiso(@PathVariable("id") int id) {
        Permiso permiso = permisoServicio.getPermisoById(id);
        if (permiso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permiso);
    }
    
    @PostMapping
    public ResponseEntity<Permiso> guardarPermiso(@RequestBody Permiso permiso) {
        Permiso nuevoPermiso = permisoServicio.save(permiso);
        return ResponseEntity.ok(nuevoPermiso);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Permiso> actualizarPermiso(@PathVariable("id") int id, @RequestBody Permiso permiso) {
        permiso.setId(id);
        Permiso permisoActualizado = permisoServicio.update(permiso);
        if (permisoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permisoActualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable("id") int id) {
        Permiso permiso = permisoServicio.getPermisoById(id);
        if (permiso == null) {
            return ResponseEntity.notFound().build();
        }
        permisoServicio.delete(id);
        return ResponseEntity.ok().build();
    }
}
// Este controlador maneja las operaciones CRUD para la entidad Permiso.