package ar.utn.ba.ddsi.gestionDeAlumnosServer.models.repositories;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.models.entities.Hecho;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HechoRepository {
    private final List<Hecho> hechos = new ArrayList<>();
    private Long nextId = 1L;

    public HechoRepository() {
        inicializarDatos();
    }

    public List<Hecho> findAll() {
        return this.hechos;
    }

    private void inicializarDatos() {
        // 1. Foco activo (Irrestricto)
        Hecho h1 = new Hecho();
        h1.setId(nextId++);
        h1.setTitulo("Foco activo en cordón serrano!");
        h1.setCategoria("Incendio forestal");
        h1.setProvincia("Córdoba");
        h1.setFechaAcontecimiento(LocalDate.of(2025, 8, 1));
        h1.setHoraAcontecimiento(LocalTime.of(14, 30));
        h1.setDescripcion("Columna de humo visible desde ruta provincial.");
        h1.setEstadoConsenso("IRRESTRICTO");
        h1.setFechaCarga(LocalDate.now());
        hechos.add(h1);

        // 2. Derrame (Irrestricto)
        Hecho h2 = new Hecho();
        h2.setId(nextId++);
        h2.setTitulo("Derrame en arroyo local...");
        h2.setCategoria("Contaminación");
        h2.setProvincia("Neuquén");
        h2.setFechaAcontecimiento(LocalDate.of(2025, 7, 18));
        h2.setHoraAcontecimiento(LocalTime.of(9, 0));
        h2.setDescripcion("Vecinos reportan manchas y olor fuerte.");
        h2.setEstadoConsenso("IRRESTRICTO");
        h2.setFechaCarga(LocalDate.now());
        hechos.add(h2);

        // 3. Quema (Irrestricto)
        Hecho h3 = new Hecho();
        h3.setId(nextId++);
        h3.setTitulo("Avistaje de quema de pastizales");
        h3.setCategoria("Quema");
        h3.setProvincia("Corrientes");
        h3.setFechaAcontecimiento(LocalDate.of(2025, 6, 30));
        h3.setHoraAcontecimiento(LocalTime.of(18, 15));
        h3.setDescripcion("Imágenes aportadas por voluntariado.");
        h3.setEstadoConsenso("IRRESTRICTO");
        h3.setFechaCarga(LocalDate.now());
        hechos.add(h3);

        // 4. Hecho Curado (para probar el tab)
        Hecho h4 = new Hecho();
        h4.setId(nextId++);
        h4.setTitulo("Dato verificado: Especie avistada");
        h4.setCategoria("Biodiversidad");
        h4.setProvincia("Misiones");
        h4.setFechaAcontecimiento(LocalDate.of(2025, 5, 10));
        h4.setHoraAcontecimiento(LocalTime.of(11, 0));
        h4.setDescripcion("Confirmado por guardaparques, fuera de peligro.");
        h4.setEstadoConsenso("CURADO");
        h4.setConsensuado(true);
        h4.setFechaCarga(LocalDate.now());
        hechos.add(h4);
    }
}