package ar.utn.ba.ddsi.gestionDeAlumnosServer.models.repositories;

import ar.utn.ba.ddsi.gestionDeAlumnosServer.models.entities.Coleccion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ColeccionRepository {
    private final List<Coleccion> colecciones = new ArrayList<>();
    private Long nextId = 1L;

    public ColeccionRepository() {
        inicializarDatos();
    }

    public List<Coleccion> findAll() {
        return this.colecciones;
    }

    // TODO: Métodos save, delete, etc.

    private void inicializarDatos() {
        Coleccion c1 = new Coleccion();
        c1.setId(nextId++);
        c1.setTitulo("Incendios forestales en Argentina 2025");
        c1.setDescripcion("Seguimiento de focos activos y prevención.");
        c1.setAdministradorId(1L); // ID de un admin de ejemplo
        colecciones.add(c1);

        Coleccion c2 = new Coleccion();
        c2.setId(nextId++);
        c2.setTitulo("Desapariciones vinculadas a crímenes de odio");
        c2.setDescripcion("Registro y visibilización para impulsar acciones.");
        c2.setAdministradorId(1L);
        colecciones.add(c2);

        Coleccion c3 = new Coleccion();
        c3.setId(nextId++);
        c3.setTitulo("Contaminación hídrica en la Patagonia");
        c3.setDescripcion("Reportes de efluentes y derrames en ríos y lagos.");
        c3.setAdministradorId(2L);
        colecciones.add(c3);

        Coleccion c4 = new Coleccion();
        c4.setId(nextId++);
        c4.setTitulo("Violencia institucional en comisarías");
        c4.setDescripcion("Hechos reportados por organizaciones de DDHH.");
        c4.setAdministradorId(1L);
        colecciones.add(c4);

        Coleccion c5 = new Coleccion();
        c5.setId(nextId++);
        c5.setTitulo("Probando desde aca");
        c5.setDescripcion("Descrip desde gestion-alumnos.server! .");
        c5.setAdministradorId(1L);
        colecciones.add(c5);
    }
}