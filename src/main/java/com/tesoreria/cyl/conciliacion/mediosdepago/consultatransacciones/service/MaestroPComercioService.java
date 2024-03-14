package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.MaestroPComercioRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioCadenaLocalDTO;

import java.util.List;

@Service
public class MaestroPComercioService {

    private final MaestroPComercioRepository maestroPComercioRepository;

    @Autowired
    public MaestroPComercioService(MaestroPComercioRepository maestroPComercioRepository) {
        this.maestroPComercioRepository = maestroPComercioRepository;
    }

    public List<MaestroPaisComercioCadenaLocalDTO> getAllCadenaLocal() {
        return maestroPComercioRepository.getAllCadenaLocal();
    }
}
