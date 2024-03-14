package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service;

import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model.Pwlocal;
import com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    private final LocalRepository localRepository;

    @Autowired
    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public List<Pwlocal> getAllLocales() {
        return localRepository.findAll();
    }

    public Optional<Pwlocal> getLocalById(Long id) {
        return localRepository.findById(id);
    }

    public Pwlocal saveLocal(Pwlocal local) {
        return localRepository.save(local);
    }

    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    public Pwlocal updateLocal(Long id, Pwlocal updatedLocal) {
        Optional<Pwlocal> existingLocalOptional = localRepository.findById(id);

        if (existingLocalOptional.isPresent()) {
            Pwlocal existingLocal = existingLocalOptional.get();
            // Actualizar los campos necesarios con los valores de updatedLocal
            existingLocal.setLoc_nombre(updatedLocal.getLoc_nombre());
            existingLocal.setLoc_fcrea(updatedLocal.getLoc_fcrea());
            existingLocal.setLoc_fmod(updatedLocal.getLoc_fmod());
            existingLocal.setLoc_ucrea(updatedLocal.getLoc_ucrea());
            existingLocal.setLoc_umod(updatedLocal.getLoc_umod());
            existingLocal.setActivo(updatedLocal.getActivo());
            existingLocal.setLoc_codsap(updatedLocal.getLoc_codsap());
            existingLocal.setLoc_sociesap(updatedLocal.getLoc_sociesap());
            existingLocal.setIdCadena(updatedLocal.getIdCadena());
            existingLocal.setLoc_migrado(updatedLocal.getLoc_migrado());
            existingLocal.setLoc_fvigencia_lm(updatedLocal.getLoc_fvigencia_lm());
            existingLocal.setLoc_codigo_ctecom(updatedLocal.getLoc_codigo_ctecom());
            existingLocal.setCad_codigo_ctecom(updatedLocal.getCad_codigo_ctecom());

            // Guardar la entidad actualizada en la base de datos
            return localRepository.save(existingLocal);
        } else {
            // Manejar el caso en que la entidad no existe
            // Puedes lanzar una excepción o devolver un valor predeterminado, según tus necesidades
            return null;
        }
    }
}