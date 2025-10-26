package ar.utn.ba.ddsi.gestionDeAlumnosServer.controllers;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.dto.HechoDTO;
import ar.utn.ba.ddsi.gestionDeAlumnosServer.services.HechoService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HechoApiController {
    private static final Logger log = LoggerFactory.getLogger(HechoApiController.class);
    private final HechoService hechoService;

    @GetMapping("/hechos")
    public ResponseEntity<Map<String, Object>> obtenerHechos(
        @RequestParam(defaultValue = "irrestricto") String modo,
        @RequestParam(defaultValue = "6") int limit) {

        log.info("Obteniendo {} hechos, modo={}", limit, modo);
        List<HechoDTO> hechos = hechoService.obtenerHechos(modo, limit);

        Map<String, Object> response = Map.of("items", hechos);

        return ResponseEntity.ok(response);
    }
}