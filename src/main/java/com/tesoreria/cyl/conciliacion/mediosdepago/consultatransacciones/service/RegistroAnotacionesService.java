package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwCambioEstado;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwLogAnotaciones;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTRX;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.projection.EstadoConDisponibleProjection;
//import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwCambioEstadoRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwEstadoConRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwLogAnotacionesRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwTRXRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.ActualizaTrxDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.LogAnotacionesDTO;

@Service
public class RegistroAnotacionesService {
	
	private final Logger logger = Logger.getLogger(ConsultaTransaccionesService.class.getName());
	
	@Autowired
	private PwEstadoConRepository pwEstadoConRepository;
	
	@Autowired 
	private PwTRXRepository pwTRXRepository;
	
	@Autowired
	private PwLogAnotacionesRepository pwLogAnotacionesRepository;
	
//	@Autowired
//	private PwCambioEstadoRepository pwCambioEstadoRepository;
	
	
	public List<EstadoConDisponibleProjection> getListaEstadoConciliacionDisponible(String estado, Integer emisor) {
		return pwEstadoConRepository.getListaEstadoConciliacionDisponible(estado, emisor);
	}
	
	@Transactional
	public List<PwTRX> actualizaEstadoConciliacionTrx(List<ActualizaTrxDTO> listaActualizaTrxDTO) {
		
		List<PwTRX> listaTrx = new ArrayList<>();
		
		try {
			listaActualizaTrxDTO.forEach((actualizaTrxDto) -> {
				
				PwTRX trx = getTrxById(actualizaTrxDto.getId_trx());
				
				if (actualizaTrxDto.getEstado_con() != null) {
					trx.setEcnEstadoCon(actualizaTrxDto.getEstado_con());
				}
				
				if (actualizaTrxDto.getTrx_if_apr() != null) {
					trx.setTrxIfApr(actualizaTrxDto.getTrx_if_apr());
				}
				
				try {
					pwTRXRepository.save(trx);
				} catch (Exception e) {
					logger.log(Level.SEVERE, e.getMessage());
					logger.log(Level.SEVERE, "ERROR AL ACTUALIZAR OBJ TRX", e.getMessage());
				}
				
//				PwCambioEstado pwCambioEstado = new PwCambioEstado();
//				pwCambioEstado.setIdTrx(actualizaTrxDto.getId_trx());
//				pwCambioEstado.setCesFecha(new Date());
//				pwCambioEstado.setEcnEstadoCon(actualizaTrxDto.getEstado_con());
//				pwCambioEstado.setEliEstadoLiq(actualizaTrxDto.getEstado_liq());
//				
//				try {
//					pwCambioEstadoRepository.save(pwCambioEstado);
//				} catch (Exception e) {
//					logger.log(Level.SEVERE, e.getMessage());
//					logger.log(Level.SEVERE, "ERROR AL ACTUALIZAR OBJ TRX", e.getMessage());
//				}
				
				
				listaTrx.add(trx);
				
			});
		} catch (Exception e) {
			logger.log(Level.SEVERE, "ERROR AL ACTUALIZAR LAS TRX", e.getMessage());
		}
		
		return listaTrx;
		
	}
	
	public PwTRX getTrxById(Long idtrx) {
		return pwTRXRepository.findById(idtrx).orElse(null);
	}
	
	@Transactional
	public List<PwLogAnotaciones> insertaAnotacionesTRX(List<LogAnotacionesDTO> listaAnotacionesTrx) {
		
		List<PwLogAnotaciones> ListaAnotaciones = new ArrayList<>();
		
		try {
			listaAnotacionesTrx.forEach((anotacionesTrxDto) -> {
				
				PwLogAnotaciones anotacion = new PwLogAnotaciones();
				
				anotacion.setLanFecha(new Date());
				anotacion.setLanAnotacion(anotacionesTrxDto.getAnotacion());
				anotacion.setIdTrx(anotacionesTrxDto.getIdtrx());
				anotacion.setIdUsuario(anotacionesTrxDto.getIdusuario());
				
				try {
					pwLogAnotacionesRepository.save(anotacion);
				} catch (Exception e) {
					logger.log(Level.SEVERE, e.getMessage());
					logger.log(Level.SEVERE, "ERROR AL INSERTAR OBJ ANOTACION", e.getMessage());
				}
				
				ListaAnotaciones.add(anotacion);
				
			});
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "ERROR AL INSERTAR LAS ANOTACIONES", e.getMessage());
		}
		
		return ListaAnotaciones;
		
	}
	
}
