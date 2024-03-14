package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioCadenaLocalDTO;

import java.util.List;

@Repository
public interface MaestroPaisComercioCadenaLocalRepository extends JpaRepository<MaestroPaisComercioCadenaLocalDTO, Long> {

    @Query(value = "select ROW_NUMBER() OVER () AS id,CONCAT (cp.pa_codigo, ',', pc.com_codigo, ',', pc2.cad_codigo, ',', pl.loc_codigo) as sistema_cod, CONCAT(cp.pa_nombre, ' + ', pc.com_nombre, ' + ', pc2.cad_nombre, ' + ', pl.loc_nombre) as sistema_cyl \r\n"
    		+ "from ctm.cua_pais cp\r\n"
    		+ "inner join cylm.pw_comercio pc on pc.id_pais = cp.pa_codigo \r\n"
    		+ "inner join cylm.pw_cadena pc2 on pc.id_comercio = pc2.id_comercio\r\n"
    		+ "inner join cylm.pw_local pl on pl.id_comercio = pc.id_comercio ", nativeQuery = true)
    List<MaestroPaisComercioCadenaLocalDTO> getAllCadenaLocal();

    // Puedes agregar otros métodos personalizados si es necesario

}
