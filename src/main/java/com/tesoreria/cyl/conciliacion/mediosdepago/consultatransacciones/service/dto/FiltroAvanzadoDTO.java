package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiltroAvanzadoDTO {
	
	private Long id_cadena;
	private List<Integer> locales;
	private Long id_emisor;
	private Long id_operador;
	private LocalDate f_ini;
	private LocalDate f_fin;
	private Long boleta; // n° boleta
	private Double monto; // monto
	private String codautor; // codautor
	private String idcon; // idcon
	private String trx_numtarjeta; // num_tarjeta
	
	private Long id_usuario;
	private Boolean is_peru_enabled;
	private Long id_comercio; //DEPRECADO
	private Boolean is_itl_enabled; //DEPRECADO
	private Boolean is_petrobras_enabled; //DEPRECADO
	private String per_codigo_grupo_banco; //DEPRECADO
	private String per_cuenta_contable; //DEPRECADO
	private String vale; //DEPRECADO
	private Long es_vale; //DEPRECADO
	private String per_motivo_anulacion; //DEPRECADO

}
