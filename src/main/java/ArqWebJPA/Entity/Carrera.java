package ArqWebJPA.Entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
 public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCarrera;
    @Column
    private String nombre;
    @Column
    private String facultad;

    @OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> inscriptos;

    public Carrera() {

    }

    public Carrera( String nombre, String facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
        this.inscriptos = new ArrayList<EstudianteCarrera>();
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

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
                ", facultad='" + facultad + '\'' +
                ", inscriptos=" + inscriptos +
                '}';
    }
}
