package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEstadoCon;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.projection.EstadoConDisponibleProjection;

@Repository
public interface PwEstadoConRepository extends CrudRepository<PwEstadoCon, String>{
	
	List<PwEstadoCon> findByActivo(String activo, Sort orden);
	
	@Query(value = "SELECT ecn.ecnEstadoCon as ecnestado, ecn.ecnDescripcion as ecndescripcion FROM PwTransEstadoCon tec "
			+ "JOIN PwEstadoCon ecn ON ecn.ecnEstadoCon = tec.id.tecEstadoDestino "
			+ "WHERE tec.id.tecEstadoOrigen = :idestado "
			+ "AND tec.id.idEmisor = :idemisor ")
	List<EstadoConDisponibleProjection> getListaEstadoConciliacionDisponible(@Param("idestado") String estado, @Param("idemisor") Integer emisor);

}
