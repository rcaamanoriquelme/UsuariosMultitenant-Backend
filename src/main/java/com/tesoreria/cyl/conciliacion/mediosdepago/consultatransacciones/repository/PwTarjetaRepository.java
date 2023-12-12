package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTarjeta;

@Repository
public interface PwTarjetaRepository extends CrudRepository<PwTarjeta, Long>{
	
	List<PwTarjeta> findByIdEmisorAndActivo(Integer emisor, String activo);
	
}
