package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogAnotacionesDTO {
	private Long id;
	private Date fecha;
	private String anotacion;
	private Long idtrx;
	private Long idusuario;
}
