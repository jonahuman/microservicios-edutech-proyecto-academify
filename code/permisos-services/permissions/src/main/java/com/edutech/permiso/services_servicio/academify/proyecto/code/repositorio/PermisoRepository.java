package com.edutech.permiso.services_servicio.academify.proyecto.code.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.permiso.services_servicio.academify.proyecto.code.entidad.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    // findAll() -- Retorna todos los permisos
    // findById(Integer id) -- Retorna un permiso según su id
    // save(Permiso permiso) -- Guarda o agrega un nuevo permiso. Si el id ya existe, actualiza el permiso
    // deleteById(Integer id) -- Elimina un permiso según su id
}
