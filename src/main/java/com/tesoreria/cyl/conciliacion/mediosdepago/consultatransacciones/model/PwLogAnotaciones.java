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
@Table(schema = "cyl", name = "pw_log_anotaciones", 
indexes = {
        @Index(name = "idx_lan_trx", columnList = "id_trx"),
        @Index(name = "ref2241", columnList = "id_usuario")
    })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwLogAnotaciones {
	
	@Id
	@Column(name = "lan_id", length = 8, nullable = false)
	@SequenceGenerator(name = "seq_lan_id", sequenceName = "seq_lan_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lan_id")
	private Long lanId;
	
	@Column(name = "lan_fecha")
	private Date lanFecha;
	
	@Column(name = "lan_anotacion", length = 500)
	private String lanAnotacion;
	
	@Column(name = "id_trx", length = 8, nullable = false)
	private Long idTrx;
	
	@Column(name = "id_usuario", length = 8, nullable = false)
	private Long idUsuario;
	
}
