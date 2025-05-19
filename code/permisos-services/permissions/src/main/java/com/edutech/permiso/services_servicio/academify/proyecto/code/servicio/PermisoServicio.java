package com.edutech.permiso.services_servicio.academify.proyecto.code.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.permiso.services_servicio.academify.proyecto.code.entidad.Permiso;
import com.edutech.permiso.services_servicio.academify.proyecto.code.repositorio.PermisoRepository;

@Service
public class PermisoServicio {
    
    @Autowired
    private PermisoRepository permisoRepository;
    
    public List<Permiso> getAll() {
        return permisoRepository.findAll();
    }
    
    public Permiso getPermisoById(int id) {
        return permisoRepository.findById(id).orElse(null);
    }   // Retorna un permiso según su ID desde la base BY FLERR
    
    public Permiso save(Permiso permiso) {
        Permiso nuevoPermiso = permisoRepository.save(permiso);
        return nuevoPermiso;
    }
    
    public void delete(int id) {
        permisoRepository.deleteById(id);
    }
    
    public Permiso update(Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}







