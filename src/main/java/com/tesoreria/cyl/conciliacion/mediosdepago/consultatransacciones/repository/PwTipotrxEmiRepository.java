package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTipotrxEmi;

@Repository
public interface PwTipotrxEmiRepository extends CrudRepository<PwTipotrxEmi, Long>{
	
	List<PwTipotrxEmi> findByIdEmisorAndActivo(Integer emisor, String activo);

}
