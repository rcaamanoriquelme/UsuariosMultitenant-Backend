package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.MaestroPaisComercioCadenaLocalService;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioCadenaLocalDTO;

import java.util.List;

@RestController
@RequestMapping("/api/maestro")
public class MaestroPaisComercioCadenaLocalController {

    private final MaestroPaisComercioCadenaLocalService service;

    @Autowired
    public MaestroPaisComercioCadenaLocalController(MaestroPaisComercioCadenaLocalService service) {
        this.service = service;
    }

    @GetMapping("/getCadenaLocal")
    public List<MaestroPaisComercioCadenaLocalDTO> getAllCadenaLocal() {
        return service.getAllCadenaLocal();
    }

    // Puedes agregar más métodos de controlador según sea necesario

}
