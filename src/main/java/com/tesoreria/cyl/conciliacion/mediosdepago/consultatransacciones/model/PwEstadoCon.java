package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.time.LocalDate;

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

@Entity
@Table(schema = "cyl", name = "pw_estado_con")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwEstadoCon {
	
	@Id
	@Column(name = "ecn_estado_con", length = 3, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ecnEstadoCon;
	
	@Column(name = "ecn_descripcion", length = 15)
	private String ecnDescripcion;
	
	@Column(name = "ecn_ctasap_pos", length = 3)
	private String ecnCtasapPos;
	
	@Column(name = "ecn_ctasap_neg", length = 3)
	private String ecnCtasapNeg;
	
	@Column(name = "ecn_fcrea")
	private LocalDate ecnFcrea;
	
	@Column(name = "ecn_fmod")
	private LocalDate ecnFmod;
	
	@Column(name = "ecn_ucrea", length = 100)
	private String ecnUcrea;
	
	@Column(name = "ecn_umod", length = 100)
	private String ecnUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;

}
