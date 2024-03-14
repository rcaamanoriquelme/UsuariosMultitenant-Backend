package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEmisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmisorRepository extends JpaRepository<PwEmisor, Long> {
    // Puedes añadir consultas personalizadas si es necesario
}
