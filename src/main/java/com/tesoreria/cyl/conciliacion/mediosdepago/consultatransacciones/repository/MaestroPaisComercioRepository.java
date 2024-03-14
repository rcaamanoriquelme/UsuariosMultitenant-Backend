package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioDTO;

import org.springframework.data.repository.CrudRepository;

public interface MaestroPaisComercioRepository extends CrudRepository<MaestroPaisComercioDTO, Long> {

    @Query(value = "select ROW_NUMBER() OVER () AS id, "
            + "CONCAT(pc2.id_cadena, ',', cp.pa_codigo, ',', pc.co_codigo) as sistema_cod, "
            + "CONCAT(pc.co_nombre, ' + ', pc2.cad_nombre, ' + ', cp.pa_nombre) as sistema_cyl "
            + "from ctm.cua_pais cp, ctm.cua_comercio pc "
            + "inner join cylm.pw_cadena pc2 on pc.co_codigo = pc2.co_codigo "
            + "where cp.pa_codigo in :paCodigos and pc.co_codigo in :coCodigos", nativeQuery = true)
    List<MaestroPaisComercioDTO> obtenerMaestroPaisComercio(
            @Param("paCodigos") List<Integer> paCodigos, @Param("coCodigos") List<Integer> coCodigos);
}