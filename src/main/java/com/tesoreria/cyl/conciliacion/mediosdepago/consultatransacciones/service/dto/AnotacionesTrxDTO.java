package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnotacionesTrxDTO {
	
	private Long lan_id;
	private String lan_fecha;
	private String lan_hora;
	private String lan_anotacion;
	private Long id_usuario;
	private String usu_nombre;

}
