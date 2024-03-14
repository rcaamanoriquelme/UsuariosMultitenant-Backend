package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.IrsPerfiles;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilesController {

    private final PerfilesService perfilesService;

    @Autowired
    public PerfilesController(PerfilesService perfilesService) {
        this.perfilesService = perfilesService;
    }

    @GetMapping("/sistema/{perSistema}")
    public List<IrsPerfiles> obtenerPorSistema(@PathVariable String perSistema) {
        return perfilesService.obtenerPorSistema(perSistema);
    }

    // Puedes agregar otros métodos de controlador según tus necesidades

}
