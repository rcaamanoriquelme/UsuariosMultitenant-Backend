package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CambioDeEstadosDTO {
	
	private BigDecimal ces_id;
	private BigDecimal id_trx;
	private String ces_fecha;
	private String ces_hora;
	private String ecn_estado_con;
	private String ecn_descripcion;
	private String eli_estado_liq;
	private String eli_descripcion;

}
