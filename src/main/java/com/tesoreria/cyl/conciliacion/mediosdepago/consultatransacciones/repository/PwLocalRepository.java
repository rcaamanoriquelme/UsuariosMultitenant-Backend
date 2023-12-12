package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.Pwlocal;

@Repository
public interface PwLocalRepository extends CrudRepository<Pwlocal, Long>{
	
	List<Pwlocal> findByIdCadena(Integer cadena);

}
