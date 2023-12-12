package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PwTransEstadoConPK {
	
	@Column(name = "id_emisor", nullable = false)
	private Long idEmisor;
	
	@Column(name = "tec_estado_origen", length = 3, nullable = false)
	private String tecEstadoOrigen;
	
	@Column(name = "tec_estado_destino", length = 3, nullable = false)
	private String tecEstadoDestino;

}
