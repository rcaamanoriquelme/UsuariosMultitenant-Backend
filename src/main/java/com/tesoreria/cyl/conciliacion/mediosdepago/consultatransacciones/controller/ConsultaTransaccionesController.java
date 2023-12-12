package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.ConsultaTransaccionesAvanzadasService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.ConsultaTransaccionesService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.FiltrosService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.RegistroAnotacionesService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.ActualizaTrxDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.AnotacionesTrxDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.CambioDeEstadosDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.DetalleConsultaTransaccionesDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.FiltroAvanzadoDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.FiltroDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.LogAnotacionesDTO;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEstadoCon;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEstadoLiq;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwLogAnotaciones;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTipotrxEmi;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwOperador;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTRX;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTarjeta;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEmisor;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.Pwlocal;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.projection.EstadoConDisponibleProjection;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwCadena;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("api/conciliacion/medios-de-pago/consulta-transacciones")
public class ConsultaTransaccionesController {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
	}
	
	@Autowired
	private FiltrosService filtrosService;
	
	@Autowired
	private ConsultaTransaccionesService consultaTransaccionesService;
	
	@Autowired
	private RegistroAnotacionesService registroAnotacionesService;
	
	@Autowired
	private ConsultaTransaccionesAvanzadasService consultaTransaccionesAvanzadasService;
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE CADENAS {pw_cadena}
	 */
	@GetMapping("/filtros/cadenas")
	public ResponseEntity<List<PwCadena>> getCadenas() {
		try {
			return new ResponseEntity<>(filtrosService.getListadoCadenas(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE LOCALES {pw_local}
	 */
	@GetMapping("/filtros/locales")
	public ResponseEntity<List<Pwlocal>> getLocales() {
		try {
			return new ResponseEntity<>(filtrosService.getListadoLocales(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE LOCALES POR CADENA
	 */
	@GetMapping("/filtros/localesbycadena/{cadena}")
	public ResponseEntity<List<Pwlocal>> getLocalesByCadena(@PathVariable Integer cadena) {
		try {
			return new ResponseEntity<>(filtrosService.getListadoLocalesByCadena(cadena), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE EMISORES {pw_emisor}
	 */
	@GetMapping("/filtros/emisores")
	public ResponseEntity<List<PwEmisor>> getEmisores() {
		try {
			return new ResponseEntity<>(filtrosService.getListadoEmisores(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE OPERADORES POR EMISOR
	 */
	@GetMapping("/filtros/operadoresbyemisor/{emisor}")
	public ResponseEntity<List<PwOperador>> getOperadoresByEmisor(@PathVariable Integer emisor) {
		try {
			return new ResponseEntity<>(filtrosService.getListadoOperadoresByEmisor(emisor), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE TARJETAS POR EMISOR
	 */
	@GetMapping("/filtros/tarjetasbyemisor/{emisor}")
	public ResponseEntity<List<PwTarjeta>> getListadoTarjetasByEmisor(@PathVariable Integer emisor) {
		try {
			return new ResponseEntity<>(filtrosService.getListadoTarjetasByEmisor(emisor), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER TIPO TRX POR EMISOR
	 */
	@GetMapping("/filtros/tipotrxbyemisor/{emisor}")
	public ResponseEntity<List<PwTipotrxEmi>> getListadoTipotrxByEmisor(@PathVariable Integer emisor) {
		try {
			return new ResponseEntity<>(filtrosService.getListadoTipotrxByEmisor(emisor), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE CONCILIACIÓN
	 */
	@GetMapping("/filtros/estado-conciliacion")
	public ResponseEntity<List<PwEstadoCon>> getEstadoConciliacion() {
		try {
			return new ResponseEntity<>(filtrosService.getListadoEstadoCon(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO DE LIQUIDACIÓN
	 */
	@GetMapping("/filtros/estado-liquidacion")
	public ResponseEntity<List<PwEstadoLiq>> getEstadoLiquidacion() {
		try {
			return new ResponseEntity<>(filtrosService.getListadoEstadoLiq(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO CONSULTA TRANSACCIONES POR FILTRO
	 */
	@PostMapping("/resumenbyfiltro")
	public ResponseEntity<List<DetalleConsultaTransaccionesDTO>> getDetallePedidoNoConciliadoByFiltro(@RequestBody FiltroDTO filtro) {
		try {
			return new ResponseEntity<>(consultaTransaccionesService.getDetalleConsultaTransaccionesByFiltro(filtro), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER LISTADO CONSULTA TRANSACCIONES POR FILTROS AVANZADOS
	 */
	@PostMapping("/resumenbyfiltroavanzado")
	public ResponseEntity<List<DetalleConsultaTransaccionesDTO>> getDetallePedidoNoConciliadoByFiltroAvanzado(@RequestBody FiltroAvanzadoDTO filtroAvanzado) {
		try {
			return new ResponseEntity<>(consultaTransaccionesAvanzadasService.getDetalleConsultaTransaccionesByFiltroAvanzado(filtroAvanzado), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER ANOTACIONES POR ID TRX
	 */
	@GetMapping("/resumenbyfiltro/anotacionesbyidtrx/{idtrx}")
	public ResponseEntity<List<AnotacionesTrxDTO>> getListadoAnotacionesByTrx(@PathVariable Long idtrx) {
		try {
			return new ResponseEntity<>(consultaTransaccionesService.getListaAnotacionesTrxByIdTrx(idtrx), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER CAMBIOS DE ESTADO DE TRX POR ID TRX
	 */
	@GetMapping("/resumenbyfiltro/cambioestadotrxbyidtrx/{idtrx}")
	public ResponseEntity<List<CambioDeEstadosDTO>> getListaCambioDeEstadoTrxByIdTrx(@PathVariable Long idtrx) {
		try {
			return new ResponseEntity<>(consultaTransaccionesService.getListaCambioDeEstadoTrxByIdTrx(idtrx), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA TRAER ESTADOS DE CONCILIACION POR ESTADO Y EMISOR
	 */
	@GetMapping("/registroanotaciones/estadoconciliaciondisponibles/{estado}/{emisor}")
	public ResponseEntity<List<EstadoConDisponibleProjection>> getListaEstadoConciliaciondisponibles(
			@PathVariable String estado, 
			@PathVariable Integer emisor) {
		try {
			return new ResponseEntity<>(registroAnotacionesService.getListaEstadoConciliacionDisponible(estado, emisor), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA ACTUALIZAR ESTADO CONCILIACION DE TRX POR ID TRX
	 */
	@PutMapping("/registroanotaciones/estadoconciliaciontrx/update")
	public ResponseEntity<List<PwTRX>> actualizaEstadoConciliacionTrx(@RequestBody List<ActualizaTrxDTO> listaActualizaTrxDTO) {
		try {
			return new ResponseEntity<>(registroAnotacionesService.actualizaEstadoConciliacionTrx(listaActualizaTrxDTO), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * ENDPOINT PARA INSERTAR ANOTACIONES DE TRX POR ID TRX
	 */
	@PostMapping("/registroanotaciones/anotacionestrx/save")
	public ResponseEntity<List<PwLogAnotaciones>> insertaAnotacionesTrx(@RequestBody List<LogAnotacionesDTO> listaPwLogAnotaciones) {
		try {
			return new ResponseEntity<>(registroAnotacionesService.insertaAnotacionesTRX(listaPwLogAnotaciones), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
