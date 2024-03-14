package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.IrsPerfiles;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilesService {

    private final PerfilesRepository perfilesRepository;

    @Autowired
    public PerfilesService(PerfilesRepository perfilesRepository) {
        this.perfilesRepository = perfilesRepository;
    }

    public List<IrsPerfiles> obtenerPorSistema(String perSistema) {
        return perfilesRepository.findByPerSistema(perSistema);
    }

    // Puedes agregar otros métodos de servicio según tus necesidades

}
