package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.MaestroPaisComercioLocalService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioLocalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/maestro")
public class MaestroPaisComercioLocalController {

    private final MaestroPaisComercioLocalService service;

    @Autowired
    public MaestroPaisComercioLocalController(MaestroPaisComercioLocalService service) {
        this.service = service;
    }

    @GetMapping("/getComercioLocal")
    public List<MaestroPaisComercioLocalDTO> getAllCadenaLocal(
            @RequestParam(name = "paCodigos") List<Integer> paCodigos,
            @RequestParam(name = "coCodigos") List<Integer> coCodigos) {
        return service.getAllCadenaLocal(paCodigos, coCodigos);
    }
}
