package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.Pwlocal;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locales")
public class LocalController {

    private final LocalService localService;

    @Autowired
    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping
    public ResponseEntity<List<Pwlocal>> getAllLocales() {
        List<Pwlocal> locales = localService.getAllLocales();
        return new ResponseEntity<>(locales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pwlocal> getLocalById(@PathVariable Long id) {
        Optional<Pwlocal> local = localService.getLocalById(id);
        return local.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pwlocal> createLocal(@RequestBody Pwlocal local) {
        Pwlocal createdLocal = localService.saveLocal(local);
        return new ResponseEntity<>(createdLocal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pwlocal> updateLocal(@PathVariable Long id, @RequestBody Pwlocal updatedLocal) {
        Pwlocal updatedEntity = localService.updateLocal(id, updatedLocal);
        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
