package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.MaestroPaisComercioRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioDTO;

import java.util.List;

@Service
public class MaestroPaisComercioService {

    private final MaestroPaisComercioRepository maestroPaisComercioRepository;

    @Autowired
    public MaestroPaisComercioService(MaestroPaisComercioRepository maestroPaisComercioRepository) {
        this.maestroPaisComercioRepository = maestroPaisComercioRepository;
    }

    public List<MaestroPaisComercioDTO> obtenerMaestroPaisComercio(List<Integer> paCodigos, List<Integer> coCodigos) {
        return maestroPaisComercioRepository.obtenerMaestroPaisComercio(paCodigos, coCodigos);
    }
}