package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEmisor;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.EmisorRepository;

@Service
public class EmisorService {

    private final EmisorRepository emisorRepository;

    @Autowired
    public EmisorService(EmisorRepository emisorRepository) {
        this.emisorRepository = emisorRepository;
    }

    // Método para crear un emisor
    public PwEmisor crearEmisor(PwEmisor emisor) {
        return emisorRepository.save(emisor);
    }

    // Método para obtener todos los emisores
    public List<PwEmisor> obtenerTodosEmisores() {
        return emisorRepository.findAll();
    }

    // Método para obtener un emisor por su ID
    public Optional<PwEmisor> obtenerEmisorPorId(Long id) {
        return emisorRepository.findById(id);
    }

    // Método para editar un emisor
    public PwEmisor editarEmisor(PwEmisor emisor) {
        return emisorRepository.save(emisor);
    }

    // Método para eliminar un emisor por su ID
    public void eliminarEmisor(Long id) {
        emisorRepository.deleteById(id);
    }
}
