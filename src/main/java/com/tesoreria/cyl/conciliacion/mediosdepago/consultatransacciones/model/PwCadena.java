package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "cyl", name = "pw_cadena")
public class PwCadena implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cadena", length = 38, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCadena;
	
	@Column(name = "id_comercio", length = 38, nullable = false)
	private Long idComercio;
	
	@Column(name = "cad_codigo", length = 10)
	private String cadCodigo;
	
	@Column(name = "cad_nombre", length = 100)
	private String cadNombre;
	
	@Column(name = "cad_fcrea")
	private LocalDateTime cadFcrea;
	
	@Column(name = "cad_fmod")
	private LocalDateTime cadFmod;
	
	@Column(name = "cad_ucrea", length = 100)
	private String cadUcrea;
	
	@Column(name = "cad_umod", length = 100)
	private String cadUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;
	
	

}
