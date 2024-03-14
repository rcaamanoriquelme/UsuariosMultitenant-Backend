package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.MaestroPaisComercioService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioDTO;

import java.util.List;

@RestController
@RequestMapping("/api/mpaiscomercio")
public class MaestroPaisComercioController {

    private final MaestroPaisComercioService maestroPaisComercioService;

    @Autowired
    public MaestroPaisComercioController(MaestroPaisComercioService maestroPaisComercioService) {
        this.maestroPaisComercioService = maestroPaisComercioService;
    }

    @GetMapping("/paiscomercio")
    public List<MaestroPaisComercioDTO> obtenerMaestroPaisComercio(
            @RequestParam List<Integer> paCodigos, @RequestParam List<Integer> coCodigos) {
        return maestroPaisComercioService.obtenerMaestroPaisComercio(paCodigos, coCodigos);
    }
}