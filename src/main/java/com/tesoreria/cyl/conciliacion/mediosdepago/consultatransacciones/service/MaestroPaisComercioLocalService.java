package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.MaestroPaisComercioLocalRepository;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto.MaestroPaisComercioLocalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroPaisComercioLocalService {

    private final MaestroPaisComercioLocalRepository repository;

    @Autowired
    public MaestroPaisComercioLocalService(MaestroPaisComercioLocalRepository repository) {
        this.repository = repository;
    }

    public List<MaestroPaisComercioLocalDTO> getAllCadenaLocal(List<Integer> paCodigos, List<Integer> coCodigos) {
        return repository.getAllCadenaLocal(paCodigos, coCodigos);
    }
}