package ar.utn.ba.ddsi.gestionDeAlumnosServer.services;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.dto.ColeccionDTO;
import ar.utn.ba.ddsi.gestionDeAlumnosServer.models.entities.Coleccion;
import ar.utn.ba.ddsi.gestionDeAlumnosServer.models.repositories.ColeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColeccionService {

    private final ColeccionRepository coleccionRepository;

    public List<ColeccionDTO> obtenerTodasLasColecciones() {
        return coleccionRepository.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    private ColeccionDTO convertirADTO(Coleccion coleccion) {
        return ColeccionDTO.builder()
            .id(coleccion.getId())
            .titulo(coleccion.getTitulo())
            .descripcion(coleccion.getDescripcion())
            .build();
    }
}