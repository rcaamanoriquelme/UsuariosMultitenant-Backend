package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioLocalDTO;

public interface MaestroPaisComercioLocalRepository extends JpaRepository<MaestroPaisComercioLocalDTO, Long> {

    @Query(value = "select ROW_NUMBER() OVER () AS id, "
            + "CONCAT(lou.loc_numero, ',', pa.pa_codigo, ',', co.co_codigo) as sistema_cod, "
            + "CONCAT(lou.loc_descripcion, ' + ', pa.pa_nombre, ' + ', co.co_nombre) as sistema_cyl "
            + "from ctm.irs_locales lou "
            + "left join ctm.cua_pais pa on lou.cod_pais = pa.pa_codigo "
            + "left join ctm.cua_comercio co on co.co_codigo = lou.cod_comercio "
            + "where pa.pa_activo = 'S' and co.co_activo = 'S' and lou.loc_activo = 'S' "
            + "and pa.pa_codigo in :paCodigos and co.co_codigo in :coCodigos "
            + "group by pa_nombre, lou.loc_numero, pa.pa_codigo, co.co_codigo, lou.loc_descripcion, pa.pa_nombre, co.co_nombre", nativeQuery = true)
    List<MaestroPaisComercioLocalDTO> getAllCadenaLocal(@Param("paCodigos") List<Integer> paCodigos, @Param("coCodigos") List<Integer> coCodigos);
}