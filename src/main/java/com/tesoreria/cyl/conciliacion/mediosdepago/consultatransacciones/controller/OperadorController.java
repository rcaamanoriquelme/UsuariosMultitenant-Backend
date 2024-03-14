package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwOperador;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.OperadorService;

@RestController
@RequestMapping("/api/operadores")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    // **Operaciones de lectura**

    // Obtener todos los operadores
    @GetMapping
    public List<PwOperador> obtenerTodosOperadores() {
        return operadorService.obtenerTodosOperadores();
    }

    // Obtener un operador por ID
    @GetMapping("/{id}")
    public Optional<PwOperador> obtenerOperadorPorId(@PathVariable Long id) {
        return operadorService.obtenerOperadorPorId(id);
    }

    // **Operaciones de creación y edición**

    // Crear un nuevo operador
    @PostMapping
    public PwOperador crearOperador(@RequestBody PwOperador operador) {
        return operadorService.crearOperador(operador);
    }

    // Editar un operador existente
    @PutMapping("/{id}")
    public PwOperador editarOperador(@PathVariable Long id, @RequestBody PwOperador nuevoOperador) {
        return operadorService.editarOperador(id, nuevoOperador);
    }

    // **Operación de eliminación**

    // Eliminar un operador por ID
    @DeleteMapping("/{id}")
    public void eliminarOperador(@PathVariable Long id) {
        operadorService.eliminarOperador(id);
    }
}