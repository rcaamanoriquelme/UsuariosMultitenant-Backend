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
@Table(schema = "cyl", name = "pw_estado_liq")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwEstadoLiq {
	
	@Id
	@Column(name = "eli_estado_liq", length = 3, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String eliEstadoLiq;
	
	@Column(name = "eli_descripcion", length = 15)
	private String eliDescripcion;
	
	@Column(name = "eli_fcrea")
	private LocalDate eliFcrea;
	
	@Column(name = "eli_fmod")
	private LocalDate eliFmod;
	
	@Column(name = "eli_ucrea", length = 100)
	private String eliUcrea;
	
	@Column(name = "eli_umod", length = 100)
	private String eliUmod;
	
	@Column(name = "activo", length = 1)
	private String activo;

}
