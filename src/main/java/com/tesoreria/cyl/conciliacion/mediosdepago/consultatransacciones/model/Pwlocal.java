package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.io.Serializable;
import java.time.LocalDate;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(schema = "cylm", name = "pw_local")

public class Pwlocal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_local")
	@SequenceGenerator(name = "seq_id_local", sequenceName = "seq_id_local", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_local")
	private Long id_local;
	
    @Column(name = "loc_codigo")
    private String loc_codigo;

	@Column(name = "loc_nombre")
	private String  loc_nombre;
	
	@Column(name = "loc_fcrea")
	private LocalDate  loc_fcrea;
	
	@Column(name = "loc_fmod")
	private LocalDate  loc_fmod;
	
    @Column(name = "loc_ucrea")
    private String loc_ucrea;

	@Column(name = "loc_umod")
	private String  loc_umod;
	
    @Column(name = "activo")
    private String activo;

	@Column(name = "loc_codsap")
	private String  loc_codsap;
	
    @Column(name = "loc_sociesap")
    private String loc_sociesap;

	@Column(name = "id_cadena")
	private Integer  idCadena;
	
	@Column(name = "loc_migrado")
	private String  loc_migrado;
	
    @Column(name = "loc_fvigencia_lm")
    private LocalDate loc_fvigencia_lm;

	@Column(name = "loc_codigo_ctecom")
	private String  loc_codigo_ctecom;
	
    @Column(name = "cad_codigo_ctecom")
    private String cad_codigo_ctecom;	


}
