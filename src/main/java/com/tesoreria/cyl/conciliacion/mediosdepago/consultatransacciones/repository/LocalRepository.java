package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.Pwlocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Pwlocal, Long> {
    // Puedes agregar consultas personalizadas si es necesario
    // Consulta por nombre: Optional<Pwlocal> findByLocNombre(String locNombre);
    // Consulta por código: Optional<Pwlocal> findByLocCodigo(String locCodigo);
}
