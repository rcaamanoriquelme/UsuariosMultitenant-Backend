package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEstadoLiq;

@Repository
public interface PwEstadoLiqRepository extends CrudRepository<PwEstadoLiq, String>{
	
	List<PwEstadoLiq> findByActivo(String activo);

}
