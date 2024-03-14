package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.MaestroPaisComercioCadenaLocalRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioCadenaLocalDTO;

import java.util.List;

@Service
public class MaestroPaisComercioCadenaLocalService {

    private final MaestroPaisComercioCadenaLocalRepository repository;

    @Autowired
    public MaestroPaisComercioCadenaLocalService(MaestroPaisComercioCadenaLocalRepository repository) {
        this.repository = repository;
    }

    public List<MaestroPaisComercioCadenaLocalDTO> getAllCadenaLocal() {
        return repository.getAllCadenaLocal();
    }

    // Puedes agregar métodos adicionales según sea necesario

}
