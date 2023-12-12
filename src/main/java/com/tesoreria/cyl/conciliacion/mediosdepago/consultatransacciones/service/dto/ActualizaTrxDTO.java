package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActualizaTrxDTO {
	
	private Long id_trx;
	private String estado_con;
	private String trx_if_apr;
	private String per_motivo_anulacion;
	private String estado_liq;
	
}
