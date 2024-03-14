package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.IrsPerfiles;

@Repository
public interface PerfilesRepository extends JpaRepository<IrsPerfiles, String> {

    List<IrsPerfiles> findByPerSistema(String perSistema);

    // Otros métodos de consulta personalizados si es necesario
}
