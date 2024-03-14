package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwEmisor;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.EmisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emisores")
public class EmisorController {

    private final EmisorService emisorService;

    @Autowired
    public EmisorController(EmisorService emisorService) {
        this.emisorService = emisorService;
    }

    @PostMapping
    public ResponseEntity<PwEmisor> crearEmisor(@RequestBody PwEmisor emisor) {
        PwEmisor nuevoEmisor = emisorService.crearEmisor(emisor);
        return new ResponseEntity<>(nuevoEmisor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PwEmisor>> obtenerTodosEmisores() {
        List<PwEmisor> emisores = emisorService.obtenerTodosEmisores();
        return new ResponseEntity<>(emisores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PwEmisor> obtenerEmisorPorId(@PathVariable Long id) {
        Optional<PwEmisor> emisor = emisorService.obtenerEmisorPorId(id);
        return emisor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PwEmisor> editarEmisor(@PathVariable Long id, @RequestBody PwEmisor emisor) {
        Optional<PwEmisor> emisorExistente = emisorService.obtenerEmisorPorId(id);
        if (emisorExistente.isPresent()) {
            emisor.setIdEmisor(id);
            PwEmisor emisorActualizado = emisorService.editarEmisor(emisor);
            return new ResponseEntity<>(emisorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmisor(@PathVariable Long id) {
        Optional<PwEmisor> emisor = emisorService.obtenerEmisorPorId(id);
        if (emisor.isPresent()) {
            emisorService.eliminarEmisor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
