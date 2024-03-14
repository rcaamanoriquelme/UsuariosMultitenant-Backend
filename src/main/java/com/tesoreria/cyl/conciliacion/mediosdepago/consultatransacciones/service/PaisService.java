package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.CuaPais;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PaisRepository;

import java.util.List;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<CuaPais> obtenerTodosLosPaises() {
        return paisRepository.findAll();
    }
}
