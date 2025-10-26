package ar.utn.ba.ddsi.gestionDeAlumnosServer.models.entities;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Hecho {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String provincia; // Usaremos esto para el "lugar"
    private LocalDate fechaAcontecimiento;
    private LocalTime horaAcontecimiento;
    private LocalDate fechaCarga;
    private String estadoConsenso; // "IRRESTRICTO" o "CURADO"
    private boolean consensuado;
    private boolean eliminado;
    // Omitimos lat/lon, colecciones, etiquetas, etc. por simplicidad
}