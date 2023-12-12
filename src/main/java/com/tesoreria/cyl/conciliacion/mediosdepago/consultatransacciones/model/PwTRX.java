package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(schema = "cyl", name = "pw_trx", 
indexes = {
        @Index(name = "f_emi_trx_new", columnList = "id_emisor"),
        @Index(name = "f_est_trx_new", columnList = "id_estado_trx"),
        @Index(name = "f_loc_trx_new", columnList = "id_local"),
        @Index(name = "f_tar_trx_new", columnList = "id_tarjeta"),
        @Index(name = "f_tiporech_trx_new", columnList = "id_tipo_rechazo"),
        @Index(name = "f_trx_x_com_new", columnList = "id_comercio"),
        @Index(name = "f_tte_trx_new", columnList = "id_tipotrx_emi"),
        @Index(name = "idx_liq_id_new", columnList = "liq_id"),
        @Index(name = "idx_pw_idcon_new", columnList = "trx_idcon"),
        @Index(name = "idx_pw_moncua1_new", columnList = "id_emisor, trx_fecha, trx_cuotas, id_comercio, ecn_estado_con, eli_estado_liq"),
        @Index(name = "idx_pw_moncua2_new", columnList = "trx_fecha"),
        @Index(name = "idx_resumenliq_fec_new", columnList = "id_emisor, trx_fecha, ecn_estado_con, eli_estado_liq"),
        @Index(name = "idx_resumenliq_loc_new", columnList = "id_emisor, id_local, trx_fecha, ecn_estado_con, eli_estado_liq"),
        @Index(name = "idx_trx1_new", columnList = "id_emisor, trx_estado_prec, eli_estado_liq, ecn_estado_con, trx_fecha"),
        @Index(name = "idx_trx_dadif_new", columnList = "id_emisor, trx_fecha, trx_if_da_dif"),
        @Index(name = "idx_trx_estemifec_new", columnList = "id_estado_trx, id_emisor, trx_fecha"),
        @Index(name = "idx_trx_feconori_new", columnList = "trx_fechacont, trx_origen"),
        @Index(name = "idx_trx_idinfliq_new", columnList = "id_comercio, trx_idcon, id_emisor, id_tarjeta, id_local, trx_fecha, trx_hora, trx_pos, trx_boleta, trx_monto, trx_cuotas, ecn_estado_con"),
        @Index(name = "idx_trx_ifsaldov_new", columnList = "id_emisor, id_local, trx_sociedad, trx_fecha"),
        @Index(name = "ref3238_new", columnList = "ecn_estado_con"),
        @Index(name = "ref3937_new", columnList = "eli_estado_liq"),
        @Index(name = "trx_cad_fk_new", columnList = "id_cadena")
    })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PwTRX {
	
	@Id
	@Column(name = "id_trx", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTrx;
	
    @Column(name = "id_tipotrx_emi", nullable = false)
    private Long idTipoTrxEmi;

    @Column(name = "id_tipo_rechazo")
    private Long idTipoRechazo;

    @Column(name = "id_tarjeta", nullable = false)
    private Long idTarjeta;

    @Column(name = "id_local", nullable = false)
    private Long idLocal;

    @Column(name = "id_comercio", nullable = false)
    private Long idComercio;

    @Column(name = "id_estado_trx", nullable = false)
    private Long idEstadoTrx;

    @Column(name = "id_emisor", nullable = false)
    private Long idEmisor;

    @Column(name = "trx_num")
    private Long trxNum;

    @Column(name = "trx_fecha")
    private LocalDateTime trxFecha;

    @Column(name = "trx_hora")
    private LocalDateTime trxHora;

    @Column(name = "trx_pos")
    private Long trxPos;

    @Column(name = "trx_boleta")
    private Long trxBoleta;

    @Column(name = "trx_monto")
    private Double trxMonto;

    @Column(name = "trx_cuotas")
    private Long trxCuotas;

    @Column(name = "trx_4dig")
    private Long trx4Dig;

    @Column(name = "trx_t_fecha")
    private LocalDateTime trxTFecha;

    @Column(name = "trx_t_rpta")
    private Double trxTRpta;

    @Column(name = "trx_idcon", length = 50)
    private String trxIdCon;

    @Column(name = "trx_numtarjeta", length = 50)
    private String trxNumTarjeta;

    @Column(name = "trx_codautor", length = 20)
    private String trxCodAutor;

    @Column(name = "trx_pais", length = 3)
    private String trxPais;

    @Column(name = "trx_vend_caj", length = 10)
    private String trxVendCaj;

    @Column(name = "eli_estado_liq", nullable = false, columnDefinition = "varchar(3) default 'REC'")
    private String eliEstadoLiq;

    @Column(name = "ecn_estado_con", nullable = false, columnDefinition = "varchar(3) default 'REC'")
    private String ecnEstadoCon;

    @Column(name = "trx_montoliquidado")
    private Double trxMontoLiquidado;

    @Column(name = "trx_estado_prec", columnDefinition = "int8 default 0")
    private Long trxEstadoPrec;

    @Column(name = "trx_nro_lote")
    private Long trxNroLote;

    @Column(name = "trx_cuotasliquidadas")
    private Long trxCuotasLiquidadas;

    @Column(name = "con_id")
    private Long conId;

    @Column(name = "liq_id")
    private Long liqId;

    @Column(name = "trx_estadoifliq", columnDefinition = "varchar(1) default 'N'")
    private String trxEstadoIfLiq;

    @Column(name = "id_mpago", length = 38)
    private BigDecimal idMpago;

    @Column(name = "trx_if_all", columnDefinition = "varchar(1) default 'N'")
    private String trxIfAll;

    @Column(name = "trx_pin", length = 38)
    private BigDecimal trxPin;

    @Column(name = "trx_if_apr", columnDefinition = "varchar(1) default 'N'")
    private String trxIfApr;

    @Column(name = "trx_if_da_dif", columnDefinition = "varchar(1) default 'N'")
    private String trxIfDaDif;

    @Column(name = "trx_origen", columnDefinition = "varchar(1) default 'C'")
    private String trxOrigen;

    @Column(name = "id_cadena", length = 38, nullable = false)
    private BigDecimal idCadena;

    @Column(name = "trx_vuelto")
    private Double trxVuelto;

    @Column(name = "trx_fechacont")
    private LocalDateTime trxFechaCont;

    @Column(name = "trx_borrado", columnDefinition = "varchar(1) default 'N'")
    private String trxBorrado;

    @Column(name = "trx_sociedad", length = 4)
    private String trxSociedad;

    @Column(name = "trx_usuario7", length = 50)
    private String trxUsuario7;

    @Column(name = "trx_usuario6", length = 50)
    private String trxUsuario6;

    @Column(name = "trx_usuario1")
    private Double trxUsuario1;

    @Column(name = "trx_usuario2")
    private Double trxUsuario2;

    @Column(name = "trx_usuario3")
    private Double trxUsuario3;

    @Column(name = "trx_usuario4")
    private LocalDateTime trxUsuario4;

    @Column(name = "trx_usuario5")
    private LocalDateTime trxUsuario5;

    @Column(name = "trx_usuario8", length = 50)
    private String trxUsuario8;

    @Column(name = "trx_donacion")
    private Double trxDonacion;

}
