package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioCadenaLocalDTO;

public interface MaestroPComercioRepository extends JpaRepository<MaestroPaisComercioCadenaLocalDTO, Long> {
	@Query(value = "select CONCAT (cp.pa_codigo, ',', pc.co_codigo) AS id,CONCAT (cp.pa_codigo, ',', pc.co_codigo) as sistema_cod, CONCAT(cp.pa_nombre, ' + ', pc.co_nombre) as sistema_cyl \r\n"
			+ "from ctm.cua_pais cp, ctm.cua_comercio pc", nativeQuery = true)
    List<MaestroPaisComercioCadenaLocalDTO> getAllCadenaLocal();
}
