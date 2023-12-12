package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleConsultaTransaccionesDTO {
	
	//NUEVA COPNSULTA
	private Long id_trx;
	private String trx_fecha;
	private String trx_hora;
	private String liq_fechapago;
	private BigDecimal id_cadena;
    private String cad_nombre;
	private Long id_local;
	private String loc_nombre;
	private Long trx_pos;
	private Long id_emisor;
	private String emi_nombre;
	private String trx_idcon;
	private String trx_numtarjeta;
	private Long trx_boleta;
	private Long td_tarjeta;
	private String tar_nombre;
	private Long trx_4dig;
	private Double trx_monto;
	private Long trx_cuotas;
	private String trx_codautor;
	private Long id_tipotrx_emi;
	private String tte_nombre;
	private Long id_tipotrx;
	private String ttx_nombre;
	private Long id_estado_trx; //solo basica
	private String etrx_nombre; //solo basica
	private String ecn_estado_con;
	private String ecn_descripcion;
	private String eli_estado_liq;
	private String eli_descripcion;
	private Double trx_montoliquidado;
	private BigDecimal trx_pin; //solo basica
	private String id_mpago; //solo basica
	private String mpa_nombre; //solo basica
	private Long lan_cant;
    private String itl_existe;
    private Double trx_vuelto;
	private Integer id_comercio;
    private Integer ptb_producto;
    private Double ptb_precio;
    private Double ptb_volumen;
    private Integer ptb_autorizacion;
    private String ptb_rut;
    private String ptb_patente;
    private String ptb_tipo_tarjeta;
    private String ptb_sap_eess;
    private String ptb_sap_producto;
    private String ptb_sap_cliente;
    private Character per_cambio_pago;
    private String per_codigo_grupo_banco;
    private String per_nombre_grupo_banco;
    private String per_cuenta_contable;
    private String per_motivo_anulacion;
    private Long id_operador;
    private String ope_nombre;
    
//    public String getTrx_montoFormateado() {
//		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//        DecimalFormat decimalFormat = new DecimalFormat("#,###.00", symbols);
//        return decimalFormat.format(trx_monto);
//    }
//    
//    public String getTrx_montoliquidadoFormateado() {
//		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//        DecimalFormat decimalFormat = new DecimalFormat("#,###.00", symbols);
//        return decimalFormat.format(trx_montoliquidado);
//    }
//    
//    public String getTrx_vueltoFormateado() {
//		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//        DecimalFormat decimalFormat = new DecimalFormat("#,###.00", symbols);
//        return decimalFormat.format(trx_vuelto);
//    }
	
	// CONSULTA ANTIGUA
//	private Long id_trx;
//	private String trx_fecha; //1
//	private Timestamp trx_hora; //1
//	private Date liq_fechapago; //2
//	private BigDecimal id_cadena;
//	private String cad_nombre; //3
//	private Long id_local;
//	private String loc_nombre; //4
//	private Long trx_pos;
//	private Long id_emisor;
//	private String emi_nombre; //5
//	private String trx_idcon;
//	private String trx_numtarjeta;
//	private Long trx_boleta;
//	private String trx_vend_caj;	
//	private Long td_tarjeta;
//	private String tar_nombre;
//	private Long trx_4dig;
//	private Double trx_monto;
//	private Long trx_cuotas;
//	private String trx_codautor;
//	private Long id_tipotrx_emi;
//	private String tte_nombre;
//	private Long id_tipotrx;
//	private String ttx_nombre;
//	private Long id_estado_trx;
//	private String etrx_nombre;
//	private String ecn_estado_con;
//	private String ecn_descripcion;
//	private String eli_estado_liq;
//	private String eli_descripcion;
//	private Double trx_montoliquidado;
//	private BigDecimal trx_pin;
//	private Long id_mpago;
//	private String mpa_nombre;
//	private Integer lan_cant;
//	private String itl_existe;
//	private Double trx_vuelto;
//	private String per_cambio_pago;
//	private String lre_reclamo;
//	private Long lre_cant;
//	private String per_car_operador;
//	private String id_operador;
//	private String per_motivo_anulacion;

}
