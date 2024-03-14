package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.CuaPais;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.PaisService;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public List<CuaPais> obtenerTodosLosPaises() {
        return paisService.obtenerTodosLosPaises();
    }
}
