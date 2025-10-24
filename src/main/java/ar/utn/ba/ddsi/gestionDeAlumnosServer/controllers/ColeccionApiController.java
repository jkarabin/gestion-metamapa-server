package ar.utn.ba.ddsi.gestionDeAlumnosServer.controllers;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.dto.ColeccionDTO;
import ar.utn.ba.ddsi.gestionDeAlumnosServer.services.ColeccionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ColeccionApiController {
    private static final Logger log = LoggerFactory.getLogger(ColeccionApiController.class);
    private final ColeccionService coleccionService;

    @GetMapping("/colecciones")
    public ResponseEntity<List<ColeccionDTO>> obtenerTodasLasColecciones() {
        log.info("Obteniendo todas las colecciones");
        List<ColeccionDTO> colecciones = coleccionService.obtenerTodasLasColecciones();
        return ResponseEntity.ok(colecciones);
    }
}