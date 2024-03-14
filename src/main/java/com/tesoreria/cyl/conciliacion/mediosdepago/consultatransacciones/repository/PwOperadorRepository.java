package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwOperador;

@Repository
public interface PwOperadorRepository extends CrudRepository<PwOperador, Long>{
	
	List<PwOperador> findAll();
	
	List<PwOperador> findByIdEmisor(Integer emisor);

}
