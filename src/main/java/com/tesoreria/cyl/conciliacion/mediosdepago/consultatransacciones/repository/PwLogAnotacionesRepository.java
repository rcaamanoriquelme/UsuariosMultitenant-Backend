package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwLogAnotaciones;

@Repository
public interface PwLogAnotacionesRepository extends CrudRepository<PwLogAnotaciones, Long>{

}
