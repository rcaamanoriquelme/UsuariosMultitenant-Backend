package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.PwUsuario;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.PwUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroUsuariosService {

    private final PwUsuarioRepository pwUsuarioRepository;

    @Autowired
    public RegistroUsuariosService(PwUsuarioRepository pwUsuarioRepository) {
        this.pwUsuarioRepository = pwUsuarioRepository;
    }

    public List<PwUsuario> getAllUsuarios() {
        return pwUsuarioRepository.findAll();
    }
    
    public List<PwUsuario> getUsuariosByActivo() {
        return pwUsuarioRepository.findUsuariosByActivo("1");
    }

    public Optional<PwUsuario> getUsuarioById(Long id) {
        return pwUsuarioRepository.findById(id);
    }

    public PwUsuario saveUsuario(PwUsuario usuario) {
        return pwUsuarioRepository.save(usuario);
    }
    
    public PwUsuario updateUsuario(Long id, PwUsuario usuario) {
        // Verifica si el usuario existe en la base de datos
        Optional<PwUsuario> existingUsuario = pwUsuarioRepository.findById(id);

        if (existingUsuario.isPresent()) {
            // Actualiza las propiedades que deseas modificar
            PwUsuario updatedUsuario = existingUsuario.get();
            updatedUsuario.setUsuNombre(usuario.getUsuNombre());
            updatedUsuario.setUsuApellido(usuario.getUsuApellido());
            updatedUsuario.setUsuEmail(usuario.getUsuEmail());
            updatedUsuario.setUsuLogin(usuario.getUsuLogin());
            updatedUsuario.setUsuPasswd(usuario.getUsuPasswd());
            updatedUsuario.setActivo(usuario.getActivo());
            updatedUsuario.setUsuFmod(usuario.getUsuFmod());
            updatedUsuario.setUsuFmod(usuario.getUsuFmod());
            // Actualiza más propiedades según sea necesario

            // Guarda el usuario actualizado en la base de datos
            return pwUsuarioRepository.save(updatedUsuario);
        } else {
            // Manejo de error: El usuario no existe
            throw new RuntimeException("No se encontró el usuario con ID: " + id);
        }
    }


    public void deleteUsuario(Long id) {
        pwUsuarioRepository.deleteById(id);
    }
}
