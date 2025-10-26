package ar.utn.ba.ddsi.gestionDeAlumnosServer.services;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.dto.HechoDTO;
import ar.utn.ba.ddsi.gestionDeAlumnosServer.models.entities.Hecho;
import ar.utn.ba.ddsi.gestionDeAlumnosServer.models.repositories.HechoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HechoService {

    private final HechoRepository hechoRepository;

    public List<HechoDTO> obtenerHechos(String modo, int limit) {
        String estado = "CURADO".equalsIgnoreCase(modo) ? "CURADO" : "IRRESTRICTO";

        return hechoRepository.findAll().stream()
            .filter(hecho -> estado.equals(hecho.getEstadoConsenso()))
            .limit(limit)
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    private HechoDTO convertirADTO(Hecho hecho) {
        return HechoDTO.builder()
            .id(hecho.getId())
            .titulo(hecho.getTitulo())
            .descripcion(hecho.getDescripcion())
            .categoria(hecho.getCategoria())
            .lugar(hecho.getProvincia()) // Mapeo de provincia a lugar
            .fecha(hecho.getFechaAcontecimiento()) // Mapeo de fecha
            .build();
    }
}