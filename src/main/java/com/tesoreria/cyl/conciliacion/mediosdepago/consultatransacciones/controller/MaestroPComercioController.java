package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.MaestroPComercioService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioCadenaLocalDTO;

import java.util.List;

@RestController
@RequestMapping("/api/maestro")
public class MaestroPComercioController {

    private final MaestroPComercioService maestroPComercioService;

    @Autowired
    public MaestroPComercioController(MaestroPComercioService maestroPComercioService) {
        this.maestroPComercioService = maestroPComercioService;
    }

    @GetMapping("/paiscomercio")
    public List<MaestroPaisComercioCadenaLocalDTO> getAllCadenaLocal() {
        return maestroPComercioService.getAllCadenaLocal();
    }
}
