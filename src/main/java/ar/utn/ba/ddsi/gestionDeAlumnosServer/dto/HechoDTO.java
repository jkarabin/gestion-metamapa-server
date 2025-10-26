package ar.utn.ba.ddsi.gestionDeAlumnosServer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HechoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String lugar; // Mapeado desde 'provincia'
    private LocalDate fecha; // Mapeado desde 'fechaAcontecimiento'
}