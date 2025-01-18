package com.foro.Api.services.ServicesPerfil;

import com.foro.Api.DTO.dtoEntities.PerfilDTO;
import com.foro.Api.entities.Perfil;
import com.foro.Api.repository.PerfilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServicesImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilServicesImpl(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil save(PerfilDTO perfilDTO) {
        Perfil nuevoPerfil = new Perfil();
        nuevoPerfil.setPer_categoria(perfilDTO.categoria());
        return perfilRepository.save(nuevoPerfil);
    }

    @Override
    public void delete(Long idPerfil) {
        perfilRepository.deleteById(idPerfil);
    }

    @Override
    public Optional<Perfil> findById(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    public void update(PerfilDTO perfilDTO) {
        System.out.println(perfilDTO);
        // Buscar el perfil existente por ID
        Optional<Perfil> perfilOpt = perfilRepository.findById(perfilDTO.per_id());

        if (perfilOpt.isPresent()) {
            // Recuperar el perfil existente
            Perfil perfilExistente = perfilOpt.get();

            // Actualizar los valores del perfil con los valores del DTO
            perfilExistente.setPer_categoria(perfilDTO.categoria());

            // Guardar los cambios en la base de datos
            perfilRepository.save(perfilExistente);
        } else {
            // Si el perfil no existe, podrías lanzar una excepción o manejarlo como desees
            throw new EntityNotFoundException("Perfil con ID " + perfilDTO.per_id() + " no encontrado.");
        }
    }

}
