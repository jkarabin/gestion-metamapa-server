package ar.utn.ba.ddsi.gestionDeAlumnosServer.models.entities;

import lombok.Data;
import java.util.Objects;

@Data
public class Coleccion {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long administradorId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion coleccion = (Coleccion) o;
        return Objects.equals(id, coleccion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}