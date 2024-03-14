package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwUsuario;

@Repository
public interface PwUsuarioRepository extends JpaRepository<PwUsuario, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
	List<PwUsuario> findUsuariosByActivo(String activo);
}