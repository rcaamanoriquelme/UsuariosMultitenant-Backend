package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEmisor;

@Repository
public interface PwEmisorRepository extends CrudRepository<PwEmisor, Long>{

}
