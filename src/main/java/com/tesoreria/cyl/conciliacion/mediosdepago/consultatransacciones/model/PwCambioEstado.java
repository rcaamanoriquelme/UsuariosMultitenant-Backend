package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "cyl", name = "pw_cambio_estado", 
indexes = {
        @Index(name = "idx_ces_fecha", columnList = "ces_fecha"),
        @Index(name = "idx_id_trx", columnList = "id_trx")
    })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwCambioEstado {
	
	@Id
	@Column(name = "ces_id", length = 38, nullable = false)
	@SequenceGenerator(name = "seq_ces_id", sequenceName = "seq_ces_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ces_id")
	private Long cesId;
	
	@Column(name = "id_trx", length = 38)
	private Long idTrx;
	
	@Column(name = "ces_fecha")
	private Date cesFecha;
	
	@Column(name = "ecn_estado_con", length = 3)
	private String ecnEstadoCon;
	
	@Column(name = "eli_estado_liq", length = 3)
	private String eliEstadoLiq;

}
