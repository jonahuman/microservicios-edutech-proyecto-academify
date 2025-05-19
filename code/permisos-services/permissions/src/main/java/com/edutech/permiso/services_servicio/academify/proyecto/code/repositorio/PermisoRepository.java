package com.edutech.permiso.services_servicio.academify.proyecto.code.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.permiso.services_servicio.academify.proyecto.code.entidad.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

}
