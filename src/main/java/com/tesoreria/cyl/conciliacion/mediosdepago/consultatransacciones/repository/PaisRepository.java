package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.CuaPais;

@Repository
public interface PaisRepository extends JpaRepository<CuaPais, Long> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}
