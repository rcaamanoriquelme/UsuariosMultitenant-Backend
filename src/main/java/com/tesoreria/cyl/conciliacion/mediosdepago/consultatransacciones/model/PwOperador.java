package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

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
@Table(schema = "cyl", name = "pw_operador")
public class PwOperador {
	
	@Id
	@Column(name= "id_operador", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOperador;
	
	@Column(name = "id_emisor")
	private Integer idEmisor;
	
	@Column(name = "ope_codigo", length = 10)
	private String opeCodigo;
	
	@Column(name = "ope_nombre", length = 100)
	private String opeNombre;
	
	@Column(name = "ope_fcrea")
	private LocalDateTime opeFcrea;
	
	@Column(name = "ope_fmod")
	private LocalDateTime opeFmod;
	
	@Column(name = "ope_ucrea", length = 100)
	private String opeUcrea;
	
	@Column(name = "ope_umod", length = 100)
	private String opeUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;

}
