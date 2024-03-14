package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.controller;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwUsuario;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.RegistroUsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/conciliacion/usuarios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RegistroUsuariosController {
	
    private final RegistroUsuariosService registroUsuariosService;

    @Autowired
    public RegistroUsuariosController(RegistroUsuariosService registroUsuariosService) {
        this.registroUsuariosService = registroUsuariosService;
    }

    @GetMapping
    public List<PwUsuario> getAllUsuarios() {
        return registroUsuariosService.getAllUsuarios();
    }
    
    @GetMapping("/activo")
    public List<PwUsuario> getUsuariosByActivo() {
        return registroUsuariosService.getUsuariosByActivo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PwUsuario> getUsuarioById(@PathVariable Long id) {
        Optional<PwUsuario> usuario = registroUsuariosService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<PwUsuario> saveUsuario(@RequestBody PwUsuario usuario) {
//        PwUsuario savedUsuario = registroUsuariosService.saveUsuario(usuario);
//        return ResponseEntity.ok(savedUsuario);
//    }
    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody PwUsuario usuario) {
        try {
            PwUsuario savedUsuario = registroUsuariosService.saveUsuario(usuario);
            return ResponseEntity.ok(savedUsuario);
        } catch (Exception e) {
            // Manejo de la excepción
            String mensajeError = "Error al guardar el usuario: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable Long id, @RequestBody PwUsuario usuario) {
        try {
            PwUsuario updatedUsuario = registroUsuariosService.updateUsuario(id, usuario);
            return ResponseEntity.ok(updatedUsuario);
        } catch (Exception e) {
            // Manejo de la excepción
            String mensajeError = "Error al actualizar el usuario: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        registroUsuariosService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
