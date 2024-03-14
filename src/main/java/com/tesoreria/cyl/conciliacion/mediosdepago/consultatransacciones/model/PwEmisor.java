package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "cylm", name = "pw_emisor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwEmisor implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_emisor", length = 22, nullable = false)
	@SequenceGenerator(name = "seq_id_emisor", sequenceName = "seq_id_emisor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_emisor")
	private Long idEmisor;
	
	@Column(name = "emi_codigo", length = 10)
	private String emiCodigo;
	
	@Column(name = "emi_nombre", length = 100)
	private String emiNombre;
	
	@Column(name = "emi_fcrea")
	private LocalDateTime emiFcrea;
	
	@Column(name = "emi_fmod")
	private LocalDateTime emiFmod;
	
	@Column(name = "emi_ucrea", length = 100)
	private String emiUcrea;
	
	@Column(name = "emi_umod", length = 100)
	private String emiUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;
	
	@Column(name = "emi_idemisorifliq", length = 4)
	private String emiIdemisorifliq;
	
	@Column(name = "id_mix_modulo", length = 38)
	private Long idMixModulo;
	
	@Column(name = "emi_codsap", length = 10)
	private String emiCodsap;

}
