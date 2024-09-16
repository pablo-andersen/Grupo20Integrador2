package ArqWebJPA.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARRERA")
 public class Carrera {
    @Id
    @Column(name="id_carrera")
    private int idCarrera;
    @Column (name = "nombre")
    private String nombre;
    @Column(name = "facultad")
    private String facultad;

    public Carrera() {

    }

    public Carrera(int idCarrera, String nombre, String facultad) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
}
