package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTransEstadoCon;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTransEstadoConPK;

@Repository
public interface PwTransEstadoConRepository extends CrudRepository<PwTransEstadoCon, PwTransEstadoConPK>{
	
	

}
