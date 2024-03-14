package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwOperador;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwOperadorRepository;

@Service
public class OperadorService {

    @Autowired
    private PwOperadorRepository operadorRepository;

    // Operación de lectura (obtener todos los operadores)
    public List<PwOperador> obtenerTodosOperadores() {
        return operadorRepository.findAll();
    }

    // Operación de lectura (
    // Operación de lectura (obtener un operador por ID)
    public Optional<PwOperador> obtenerOperadorPorId(Long id) {
        return operadorRepository.findById(id);
    }

    // Operación de creación
    public PwOperador crearOperador(PwOperador operador) {
        return operadorRepository.save(operador);
    }

    // Operación de edición
    public PwOperador editarOperador(Long id, PwOperador nuevoOperador) {
        Optional<PwOperador> operadorExistente = operadorRepository.findById(id);

        if (operadorExistente.isPresent()) {
            PwOperador operador = operadorExistente.get();
            operador.setIdEmisor(nuevoOperador.getIdEmisor());
            operador.setOpeCodigo(nuevoOperador.getOpeCodigo());
            operador.setOpeNombre(nuevoOperador.getOpeNombre());
            operador.setOpeFcrea(nuevoOperador.getOpeFcrea());
            operador.setOpeFmod(nuevoOperador.getOpeFmod());
            operador.setOpeUcrea(nuevoOperador.getOpeUcrea());
            operador.setOpeUmod(nuevoOperador.getOpeUmod());
            operador.setActivo(nuevoOperador.getActivo());

            return operadorRepository.save(operador);
        } else {
            // Manejar la situación donde el operador no existe
            return null;
        }
    }

    // Operación de eliminación
    public void eliminarOperador(Long id) {
        operadorRepository.deleteById(id);
    }
}
