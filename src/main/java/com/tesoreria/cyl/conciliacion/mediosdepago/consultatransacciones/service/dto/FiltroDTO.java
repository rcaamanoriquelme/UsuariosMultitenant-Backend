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
public class FiltroDTO {
	
	private Long id_cadena;
	private Long id_local;
	private Long id_emisor;
	private Long id_operador;
	private Long id_tarjeta;
	private Long id_tipo_trx;
	private List<String> estado_con;
	private List<String> estado_liq;
	private LocalDate fechainicio;
	private LocalDate fechatermino;
	private Boolean is_itl_enabled; //DEPRECADO
	private Boolean is_mediopago_enabled; //DEPRECADO
	private Integer id_usuario;
	private Boolean is_peru_enabled;
	private Integer id_estado_trx; //DEPRECADO
	private Long idcomercio; //DEPRECADO
	private Long es_vale; //DEPRECADO
	private Boolean is_petrobras_enabled; //DEPRECADO
	private String per_codigo_grupo_banco; //DEPRECADO
	private String per_cuenta_contable; //DEPRECADO
	private String per_motivo_anulacion; //DEPRECADO
	
}	
