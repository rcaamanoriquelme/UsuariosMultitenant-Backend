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
@Table(schema = "cyl", name = "pw_tipotrx_emi", 
indexes = {
        @Index(name = "f_emi_tte", columnList = "id_emisor"),
        @Index(name = "f_ttx_tte", columnList = "id_tipotrx"),
        @Index(name = "idxtipotrxemi", columnList = "tte_codigo, id_emisor")
    })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwTipotrxEmi {
	
	@Id
	@Column(name = "id_tipotrx_emi", length = 8, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipotrxEmi;
	
	@Column(name = "id_tipotrx", length = 8, nullable = false)
	private Long idTipotrx;
	
	@Column(name = "id_emisor", length = 8, nullable = false)
	private Long idEmisor;
	
	@Column(name = "tte_codigo", length = 10)
	private String tteCodigo;
	
	@Column(name = "tte_nombre", length = 100)
	private String tteNombre;
	
	@Column(name = "tte_fcrea")
	private LocalDate tteFcrea;
	
	@Column(name = "tte_fmod")
	private LocalDate tteFmod;
	
	@Column(name = "tte_ucrea", length = 100)
	private String tteUcrea;
	
	@Column(name = "tte_umod", length = 100)
	private String tteUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;
	
	@Column(name = "factor", columnDefinition = "int8 default 1")
	private Integer factor;
	
	@Column(name = "fcuad", columnDefinition = "varchar(1) default '1'::character varying")
	private String fcuad;
	
	@Column(name = "tte_flgvtaanul", columnDefinition = "numeric(38) default '1'::numeric")
	private Double tteFlgvtaanul;
	
	@Column(name = "tte_chktrx", columnDefinition = "varchar(1) default 'N'::character varying")
	private String tteChktrx;

}
