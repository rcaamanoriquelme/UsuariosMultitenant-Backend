package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.DetalleConsultaTransaccionesDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.FiltroAvanzadoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class ConsultaTransaccionesAvanzadasService {
	
	private final Logger logger = Logger.getLogger(ConsultaTransaccionesService.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * MÉTODO PARA TRAER DETALLE DE CONSULTA TRANSACCIONES BASADO EN LOS FILTROS AVANZADOS
	 */
	@Transactional
	public List<DetalleConsultaTransaccionesDTO> getDetalleConsultaTransaccionesByFiltroAvanzado(FiltroAvanzadoDTO filtroAvanzado) {
		List<DetalleConsultaTransaccionesDTO> listDetallePedidoNoConciliadosDTO = new ArrayList<>();
		try {
			listDetallePedidoNoConciliadosDTO = getResumenByFiltro(filtroAvanzado);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
			logger.log(Level.SEVERE, "ERROR AL TRAER DETALLE DE CONSULTA TRANSACCIONES", e.getMessage());
		}
		return listDetallePedidoNoConciliadosDTO;
	}
	
	/*
	 * MÉTODO PARA CONSTRUIR LA QUERY EN BASE A LOS FILTROS
	 */
	@SuppressWarnings("unchecked")
	public List<DetalleConsultaTransaccionesDTO> getResumenByFiltro(FiltroAvanzadoDTO filtro) {
		
		String pgsqlQuery = "SELECT "
				+ "TRX.ID_TRX, "
				+ "TRX.TRX_FECHA, "
				+ "to_char(TRX.TRX_HORA, 'HH24:MI:SS') AS TRX_HORA, "
				+ "LIQ.LIQ_FECHAPAGO, "
				+ "CAD.ID_CADENA, "
				+ "CAD.CAD_NOMBRE, "
				+ "LOC.ID_LOCAL, "
				+ "LOC.LOC_NOMBRE, "
				+ "TRX.TRX_POS, "
				+ "EMI.ID_EMISOR, "
				+ "EMI.EMI_NOMBRE, "
				+ "TTX.ID_TIPOTRX, "
				+ "TTX.TTX_NOMBRE, "
				+ "TTE.ID_TIPOTRX_EMI, "
				+ "TTE.TTE_NOMBRE, "
				+ "TAR.ID_TARJETA, "
				+ "TAR.TAR_NOMBRE, "
				+ "TRX.TRX_NUMTARJETA, "
				+ "TRX.TRX_BOLETA, "
				+ "TRX.TRX_MONTO, "
				+ "TRX.TRX_CUOTAS, "
				+ "TRX.TRX_4DIG, "
				+ "TRX.TRX_CODAUTOR, "
				+ "ECN.ECN_ESTADO_CON, "
				+ "ECN.ECN_DESCRIPCION, "
				+ "TRX.ELI_ESTADO_LIQ, "
				+ "ELI.ELI_DESCRIPCION, "
				+ "TRX.TRX_MONTOLIQUIDADO, "
				+ "TRX.TRX_IDCON, "
				+ "(SELECT COUNT(LAN_ID) LAN_CANT FROM cyl.PW_LOG_ANOTACIONES WHERE TRX.ID_TRX = ID_TRX) AS LAN_CANT ";
		
		if (filtro.getIs_peru_enabled().equals(true)) {
			pgsqlQuery += ", PER.PER_CAMBIO_PAGO, "
					+ "PER.PER_CODIGO_GRUPO_BANCO, "
					+ "PER.PER_NOMBRE_GRUPO_BANCO, "
					+ "PER.PER_CUENTA_CONTABLE, "
					+ "null as PER_MOTIVO_ANULACION "; //PER.PER_MOTIVO_ANULACION
		} else {
			pgsqlQuery += ", null as PER.PER_CAMBIO_PAGO, "
					+ "null as PER.PER_CODIGO_GRUPO_BANCO, "
					+ "null as PER.PER_NOMBRE_GRUPO_BANCO, "
					+ "null as PER.PER_CUENTA_CONTABLE, "
					+ "null as PER.PER_MOTIVO_ANULACION ";
		}
		
		pgsqlQuery += ", TRX.TRX_VUELTO ";
		
		if (filtro.getEs_vale() != null) {
			pgsqlQuery += ", null as OPE_NOMBRE, "
					+ "null as ID_OPERADOR ";
		} else {
			pgsqlQuery += ", OPE.OPE_NOMBRE, "
					+ "OPE.ID_OPERADOR ";
		}
		
//		if (filtro.getIs_itl_enabled().equals(true)) {
//		pgsqlQuery += ", ITL.ITL_EXISTE ";
//	} else {
//		pgsqlQuery += ", 'N' ITL_EXISTE ";
//	}
	
//	if (filtro.getIs_petrobras_enabled().equals(true)) {
//		pgsqlQuery += ", TRX.ID_COMERCIO, "
//				+ "PTB.PTB_PRODUCTO, "
//				+ "PTB.PTB_PRECIO, "
//				+ "PTB.PTB_VOLUMEN, "
//				+ "PTB.PTB_AUTORIZACION, "
//				+ "PTB.PTB_RUT, "
//				+ "PTB.PTB_PATENTE, "
//				+ "PTB.PTB_TIPO_TARJETA, "
//				+ "PTB.PTB_SAP_EESS, "
//				+ "PTB.PTB_SAP_PRODUCTO, "
//				+ "PTB.PTB_SAP_CLIENTE ";
//	} else {
//		pgsqlQuery += ", null as ID_COMERCIO, "
//				+ "null as PTB_PRODUCTO, "
//				+ "null as PTB_PRECIO, "
//				+ "null as PTB_VOLUMEN, "
//				+ "null as PTB_AUTORIZACION, "
//				+ "null as PTB_RUT, "
//				+ "null as PTB_PATENTE, "
//				+ "null as PTB_TIPO_TARJETA, "
//				+ "null as PTB_SAP_EESS, "
//				+ "null as PTB_SAP_PRODUCTO, "
//				+ "null as PTB_SAP_CLIENTE ";
//	}
		
		String pgsqlQueryTRXJOIN = "FROM cyl.PW_TRX TRX "
				+ "LEFT JOIN cyl.PW_LIQUIDACION LIQ ON LIQ.LIQ_ID = TRX.LIQ_ID "
				+ "AND LIQ.LIQ_FVENTA >=  :f_ini AND LIQ.LIQ_FVENTA <= :f_fin "
				+ "AND LIQ.LIQ_ESTADO IN ('E', 'F') ";
		
		if (filtro.getIs_peru_enabled().equals(true)) {
			pgsqlQueryTRXJOIN += "JOIN cyl.PW_TRX_PERU PER ON TRX.ID_TRX = PER.ID_TRX ";
			
			if (filtro.getPer_codigo_grupo_banco() != null) {
				pgsqlQueryTRXJOIN += "AND PER.PER_CODIGO_GRUPO_BANCO = :per_codigo_grupo_banco ";
			}
			
			if (filtro.getPer_cuenta_contable() != null) {
				pgsqlQueryTRXJOIN += "AND PER.PER_CUENTA_CONTABLE = :per_cuenta_contable ";
			}
			
			if (filtro.getPer_motivo_anulacion() != null) {
				pgsqlQueryTRXJOIN += "AND PER.PER_MOTIVO_ANULACION = :per_motivo_anulacion ";
			}
			
		}
		
		pgsqlQueryTRXJOIN += "JOIN cyl.PW_CADENA CAD ON CAD.ID_CADENA = TRX.ID_CADENA ";
		
		if (filtro.getId_usuario() != null) {
			pgsqlQueryTRXJOIN += "JOIN cyl.PW_USUCAD USUCAD ON USUCAD.ID_CADENA = CAD.ID_CADENA "
					+ "AND USUCAD.ID_USUARIO = :id_usuario ";
		}

		pgsqlQueryTRXJOIN += "JOIN cyl.PW_LOCAL LOC ON LOC.ID_LOCAL = TRX.ID_LOCAL ";
		
		if (filtro.getLocales() != null && !filtro.getLocales().isEmpty()) {
			pgsqlQueryTRXJOIN += "AND  TRX.ID_LOCAL IN (:locales) ";
		}
		
		pgsqlQueryTRXJOIN += "JOIN cyl.PW_EMISOR EMI ON EMI.ID_EMISOR = TRX.ID_EMISOR ";
		
		if (filtro.getId_emisor() != null) {
			pgsqlQueryTRXJOIN += "AND TRX.ID_EMISOR = :id_emisor ";
		}
		
		if (filtro.getVale() != null) {
			pgsqlQueryTRXJOIN += "AND EMI.EMI_CODIGO != :vale ";
		}
		
		pgsqlQueryTRXJOIN += "JOIN cyl.PW_TIPOTRX_EMI TTE ON TTE.ID_TIPOTRX_EMI = TRX.ID_TIPOTRX_EMI "
				+ "JOIN cyl.PW_TIPOTRX TTX ON TTX.ID_TIPOTRX = TTE.ID_TIPOTRX "
				+ "JOIN cyl.PW_TARJETA TAR ON TAR.ID_TARJETA = TRX.ID_TARJETA "
				+ "JOIN cyl.PW_ESTADO_CON ECN ON ECN.ECN_ESTADO_CON = TRX.ECN_ESTADO_CON "
				+ "JOIN cyl.PW_ESTADO_LIQ ELI ON ELI.ELI_ESTADO_LIQ = TRX.ELI_ESTADO_LIQ ";
		
		if (filtro.getEs_vale() == null) {
			pgsqlQueryTRXJOIN += "LEFT JOIN cyl.PW_OPERADOR OPE ON "
					+ "TO_NUMBER(OPE.OPE_CODIGO, '99999') = ( "
					+ "CASE "
					+ "WHEN PER.PER_TIPO_EMISOR IS NOT NULL THEN "
					+ "TO_NUMBER(PER.PER_TIPO_EMISOR, '99999') "
					+ "ELSE "
					+ "TO_NUMBER(COALESCE(NULLIF(PER.PER_CAR_OPERADOR, '0'), PER.PER_CAR_OPERADOR), '99999') "
					+ "END ) ";
			//"TO_NUMBER(DECODE(PER.PER_CAR_OPERADOR,null,'0',PER.PER_CAR_OPERADOR), '99999') "
		}
		
//		if (filtro.getIs_itl_enabled().equals(true)) {
//			pgsqlQueryTRXJOIN += "LEFT JOIN cyl.TBL_ITL ITL ON ITL.ID_TRX = TRX.ID_TRX ";
//		}
		
//		if (filtro.getIs_petrobras_enabled().equals(true)) {
//			pgsqlQueryTRXJOIN += "LEFT JOIN cyl.PW_TRX_PETROBRAS PTB ON PTB.ID_TRX = TRX.ID_TRX ";
//		}
		
		String pgsqlQueryWHERE = "WHERE TRX.TRX_FECHA >= :f_ini "
				+ "AND TRX.TRX_FECHA <= :f_fin ";
		
		if (filtro.getId_comercio() != null) {
			pgsqlQueryWHERE += "AND TRX.ID_COMERCIO = :id_comercio ";
		}
		
		if (filtro.getId_cadena() != null) {
			pgsqlQueryWHERE += "AND TRX.ID_CADENA = :id_cadena ";
		}
		
		if (filtro.getBoleta() != null) {
			pgsqlQueryWHERE += "AND TRX.TRX_BOLETA = :boleta ";
		}
		
		if (filtro.getMonto() != null) {
			pgsqlQueryWHERE += "AND TRX.TRX_MONTO = :monto ";
		}
		
		if (filtro.getCodautor() != null) {
			pgsqlQueryWHERE += "AND TRIM(TRX.TRX_CODAUTOR) = :codautor ";
		}
		
		if (filtro.getIdcon() != null) {
			pgsqlQueryWHERE += "AND TRIM(TRX.TRX_IDCON) = :idcon ";
		}
		
		if (filtro.getTrx_numtarjeta() != null) {
			pgsqlQueryWHERE += "AND TRX.TRX_4DIG = CAST(:trx_numtarjeta AS INTEGER) ";
		}
		
		if (filtro.getId_operador() != null) {
			pgsqlQueryWHERE += "AND OPE.ID_OPERADOR = :id_operador ";
		}
		
//		pgsqlQueryWHERE += "AND TRX.ECN_ESTADO_CON NOT IN ('ANU', 'NCO') "
//				+ "AND TRX.ELI_ESTADO_LIQ NOT IN ('ANU', 'NLI') ";
		pgsqlQueryWHERE += "AND (TRX.ECN_ESTADO_CON != 'NCO' OR TRX.ELI_ESTADO_LIQ != 'NLI') ";
		
		pgsqlQueryWHERE += "ORDER BY TRX.TRX_FECHA, TRX.TRX_HORA ";
		
		pgsqlQuery += pgsqlQueryTRXJOIN + pgsqlQueryWHERE;
		
//		logger.info(pgsqlQuery);
		
		Query query = entityManager.createNativeQuery(pgsqlQuery);
		
		query.setParameter("f_ini", filtro.getF_ini());
		query.setParameter("f_fin", filtro.getF_fin());
		
		if (filtro.getPer_codigo_grupo_banco() != null) {
			query.setParameter("per_codigo_grupo_banco", filtro.getPer_codigo_grupo_banco());
		}
		
		if (filtro.getPer_cuenta_contable() != null) {
			query.setParameter("per_cuenta_contable", filtro.getPer_cuenta_contable());
		}
		
		if (filtro.getPer_motivo_anulacion() != null) {
			query.setParameter("per_motivo_anulacion", filtro.getPer_motivo_anulacion());
		}
		
		if (filtro.getId_usuario() != null) {
			query.setParameter("id_usuario", filtro.getId_usuario());
		}
		
		if (filtro.getLocales() != null && !filtro.getLocales().isEmpty()) {
			query.setParameter("locales", filtro.getLocales());
		}
		
		if (filtro.getId_emisor() != null) {
			query.setParameter("id_emisor", filtro.getId_emisor());
		}
		
		if (filtro.getVale() != null) {
			query.setParameter("vale", filtro.getVale());
		}
		
		if (filtro.getId_comercio() != null) {
			query.setParameter("id_comercio", filtro.getId_comercio());
		}
		
		if (filtro.getId_cadena() != null) {
			query.setParameter("id_cadena", filtro.getId_cadena());
		}
		
		if (filtro.getBoleta() != null) {
			query.setParameter("boleta", filtro.getBoleta());
		}
		
		if (filtro.getMonto() != null) {
			query.setParameter("monto", filtro.getMonto());
		}
		
		if (filtro.getCodautor() != null) {
			query.setParameter("codautor", filtro.getCodautor());
		}
		
		if (filtro.getIdcon() != null) {
			query.setParameter("idcon", filtro.getIdcon());
		}
		
		if (filtro.getTrx_numtarjeta() != null) {
			query.setParameter("trx_numtarjeta", filtro.getTrx_numtarjeta());
		}
		
		if (filtro.getId_operador() != null) {
			query.setParameter("id_operador", filtro.getId_operador());
		}
		
		List<Object[]> resultados = null;
		
		try {
			resultados = query.getResultList();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
			logger.log(Level.SEVERE, "ERROR AL GENERAR QUERY", e.getMessage());
		}
		
		return queryToDetalleConsultaTransaccionesDTO(resultados);
	}
	
	/*
	 * MÉTODO PARA SETEAR LOS RESULTADOS TRAIDOS DE LA QUERY A UN OBJETO TIPO DetallePedidoNoConciliadosDTO
	 * logger.info(detallePedidoNoConciliado[0].getClass().getName()); OBTIENE TIPO PARAMETRO
	 */
	public List<DetalleConsultaTransaccionesDTO> queryToDetalleConsultaTransaccionesDTO(List<Object[]> queryResult) {
		
		List<DetalleConsultaTransaccionesDTO> consultaTransaccionesDTOs = new ArrayList<>();
		queryResult.forEach((detalleConsultaTransacciones) -> {
			
			try {
				DetalleConsultaTransaccionesDTO detalleConsultaTransaccionesDTO = new DetalleConsultaTransaccionesDTO();
				
				try {
					detalleConsultaTransaccionesDTO.setId_trx((Long) detalleConsultaTransacciones[0]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_trx", e.getMessage());
				}
				
				try {
					Timestamp ts = (Timestamp) detalleConsultaTransacciones[1];
					LocalDate localDate = ts.toLocalDateTime().toLocalDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
					String fechaFormateada = localDate.format(formatter);
					detalleConsultaTransaccionesDTO.setTrx_fecha(fechaFormateada);
					
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_fecha", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_hora((String) detalleConsultaTransacciones[2]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_hora", e.getMessage());
				}
				
				try {
					Timestamp ts = (Timestamp) detalleConsultaTransacciones[3];
					LocalDate localDate = ts.toLocalDateTime().toLocalDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
					String fechaFormateada = localDate.format(formatter);
					detalleConsultaTransaccionesDTO.setLiq_fechapago(fechaFormateada);
					
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Liq_fechapago", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setId_cadena((BigDecimal) detalleConsultaTransacciones[4]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_cadena", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setCad_nombre((String) detalleConsultaTransacciones[5]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Cad_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setId_local((Long) detalleConsultaTransacciones[6]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_local", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setLoc_nombre((String) detalleConsultaTransacciones[7]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Loc_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_pos((Long) detalleConsultaTransacciones[8]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_pos", e.getMessage());
				}
				
				try {
					BigDecimal valor = (BigDecimal) detalleConsultaTransacciones[9];
					detalleConsultaTransaccionesDTO.setId_emisor(valor.longValue());
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_emisor", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setEmi_nombre((String) detalleConsultaTransacciones[10]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Emi_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setId_tipotrx((Long) detalleConsultaTransacciones[11]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_tipotrx", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTtx_nombre((String) detalleConsultaTransacciones[12]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ttx_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setId_tipotrx_emi((Long) detalleConsultaTransacciones[13]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_tipotrx_emi", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTte_nombre((String) detalleConsultaTransacciones[14]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Tte_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTd_tarjeta((Long) detalleConsultaTransacciones[15]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Td_tarjeta", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTar_nombre((String) detalleConsultaTransacciones[16]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Tar_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_numtarjeta((String) detalleConsultaTransacciones[17]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_numtarjeta", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_boleta((Long) detalleConsultaTransacciones[18]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_boleta", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_monto((Double) detalleConsultaTransacciones[19]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_monto", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_cuotas((Long) detalleConsultaTransacciones[20]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_cuotas", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_4dig((Long) detalleConsultaTransacciones[21]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_4dig", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_codautor((String) detalleConsultaTransacciones[22]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_codautor", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setEcn_estado_con((String) detalleConsultaTransacciones[23]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ecn_estado_con", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setEcn_descripcion((String) detalleConsultaTransacciones[24]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ecn_descripcion", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setEli_estado_liq((String) detalleConsultaTransacciones[25]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Eli_estado_liq", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setEli_descripcion((String) detalleConsultaTransacciones[26]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Eli_descripcion", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_montoliquidado((Double) detalleConsultaTransacciones[27]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_montoliquidado", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_idcon((String) detalleConsultaTransacciones[28]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_idcon", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setLan_cant((Long) detalleConsultaTransacciones[29]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Lan_cant", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setPer_cambio_pago((Character) detalleConsultaTransacciones[30]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Per_cambio_pago", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setPer_codigo_grupo_banco((String) detalleConsultaTransacciones[31]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Per_codigo_grupo_banco", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setPer_nombre_grupo_banco((String) detalleConsultaTransacciones[32]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Per_nombre_grupo_banco", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setPer_cuenta_contable((String) detalleConsultaTransacciones[33]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Per_cuenta_contable", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setPer_motivo_anulacion((String) detalleConsultaTransacciones[34]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Per_motivo_anulacion", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setTrx_vuelto((Double) detalleConsultaTransacciones[35]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Trx_vuelto", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setOpe_nombre((String) detalleConsultaTransacciones[36]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ope_nombre", e.getMessage());
				}
				
				try {
					detalleConsultaTransaccionesDTO.setId_operador((Long) detalleConsultaTransacciones[37]);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_operador", e.getMessage());
				}
				
//				try {
//					detalleConsultaTransaccionesDTO.setItl_existe((String) detalleConsultaTransacciones[38]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Itl_existe", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setId_comercio((Integer) detalleConsultaTransacciones[39]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Id_comercio", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_producto((Integer) detalleConsultaTransacciones[40]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_producto", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_precio((Double) detalleConsultaTransacciones[41]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_precio", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_volumen((Double) detalleConsultaTransacciones[42]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_volumen", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_autorizacion((Integer) detalleConsultaTransacciones[43]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_autorizacion", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_rut((String) detalleConsultaTransacciones[44]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_rut", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_patente((String) detalleConsultaTransacciones[45]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_patente", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_tipo_tarjeta((String) detalleConsultaTransacciones[46]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_tipo_tarjeta", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_sap_eess((String) detalleConsultaTransacciones[47]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_sap_eess", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_sap_producto((String) detalleConsultaTransacciones[48]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_sap_producto", e.getMessage());
//				}
//				
//				try {
//					detalleConsultaTransaccionesDTO.setPtb_sap_cliente((String) detalleConsultaTransacciones[49]);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, "ERROR AL CASTEAR Ptb_sap_cliente", e.getMessage());
//				}
				
				consultaTransaccionesDTOs.add(detalleConsultaTransaccionesDTO);
				
			} catch (Exception e) {
				logger.log(Level.SEVERE, "ERROR AL CASTEAR LA QUERY A DTO");
			}
			
		});
		
		return consultaTransaccionesDTOs;
	}

}
