package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwCadena;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEmisor;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEstadoCon;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEstadoLiq;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTipotrxEmi;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.Pwlocal;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwCadenaRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwEmisorRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwEstadoConRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwEstadoLiqRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwLocalRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwTipotrxEmiRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwOperador;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwTarjeta;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwOperadorRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwTarjetaRepository;

@Service
public class FiltrosService {
	
	@Autowired
	private PwCadenaRepository pwCadenaRepository;
	
	@Autowired
	private PwLocalRepository pwLocalRepository;
	
	@Autowired
	private PwEmisorRepository pwEmisorRepository;
	
	@Autowired
	private PwOperadorRepository pwOperadorRepository;
	
	@Autowired
	private PwTarjetaRepository pwTarjetaRepository;
	
	@Autowired
	private PwTipotrxEmiRepository pwTipotrxEmiRepository;
	
	@Autowired
	private PwEstadoConRepository pwEstadoConRepository;
	
	@Autowired
	private PwEstadoLiqRepository pwEstadoLiqRepository;
	
	public List<PwCadena> getListadoCadenas() {
		return (List<PwCadena>) pwCadenaRepository.findAll();
	}
	
	public List<Pwlocal> getListadoLocales() {
		
		return (List<Pwlocal>) pwLocalRepository.findAll();
	}
	
	public List<PwEmisor> getListadoEmisores() {
		return (List<PwEmisor>) pwEmisorRepository.findAll();
	}
	
	public List<Pwlocal> getListadoLocalesByCadena(Integer cadena) {
		return pwLocalRepository.findByIdCadena(cadena);
	}
	
	public List<PwOperador> getListadoOperadoresByEmisor(Integer emisor) {
		return pwOperadorRepository.findByIdEmisor(emisor);
	}
	
	public List<PwTarjeta> getListadoTarjetasByEmisor(Integer emisor) {
		return pwTarjetaRepository.findByIdEmisorAndActivo(emisor, "1");
	}
	
	public List<PwTipotrxEmi> getListadoTipotrxByEmisor(Integer emisor) {
		return pwTipotrxEmiRepository.findByIdEmisorAndActivo(emisor, "1");
	}
	
	public List<PwEstadoCon> getListadoEstadoCon() {
		return pwEstadoConRepository.findByActivo("1");
	}
	
	public List<PwEstadoLiq> getListadoEstadoLiq() {
		return pwEstadoLiqRepository.findByActivo("1");
	}

}
