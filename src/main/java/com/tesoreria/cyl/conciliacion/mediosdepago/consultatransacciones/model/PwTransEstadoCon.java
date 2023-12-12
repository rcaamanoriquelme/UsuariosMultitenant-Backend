package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "cyl", name = "pw_trans_estado_con", 
indexes = {
        @Index(name = "idx_tec_emiest", columnList = "id_emisor, tec_estado_origen")
    })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwTransEstadoCon {
	
	@EmbeddedId
	private PwTransEstadoConPK id;
	
	@Column(name = "tec_fcrea")
	private LocalDate tecFcrea;
	
	@Column(name = "tec_fmod")
	private LocalDate tecFmod;
	
	@Column(name = "tec_ucrea", length = 100)
	private String tecUcrea;
	
	@Column(name = "tec_umod", length = 100)
	private String tecUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;

}
