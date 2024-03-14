package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MaestroPaisComercioDTOPK implements Serializable {
	
	@Column(name = "id")
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
