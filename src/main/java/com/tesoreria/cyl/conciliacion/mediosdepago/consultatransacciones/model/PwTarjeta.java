package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "cyl", name = "pw_tarjeta", 
indexes = {
        @Index(name = "f_emi_tar", columnList = "id_emisor"),
        @Index(name = "idxtarjetas", columnList = "tar_codigo, id_emisor")
    })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwTarjeta {
	
	@Id
	@Column(name = "id_tarjeta", length = 8, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTarjeta;
	
	@Column(name = "id_emisor", length = 8, nullable = false)
	private Long idEmisor;
	
	@Column(name = "tar_codigo", length = 15)
	private String tarCodigo;
	
	@Column(name = "tar_nombre", length = 100)
	private String tarNombre;
	
	@Column(name = "tar_fcrea")
	private LocalDate tarFcrea;
	
	@Column(name = "tar_fmod")
	private LocalDate tarFmod;
	
	@Column(name = "tar_ucrea", length = 100)
	private String tarUcrea;
	
	@Column(name = "tar_umod", length = 100)
	private String tarUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;
	
	@Column(name = "tar_ttarjetaifliq", length = 2)
	private String tarTtarjetaifliq;

}
