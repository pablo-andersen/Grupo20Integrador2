package ArqWebJPA.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
 public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_carrera")
    private int idCarrera;
    @Column (name = "nombre")
    private String nombre;
    @Column(name = "facultad")
    private String facultad;

    //CONSULTA: Esto genera automáticamente la tabla intermedia? como le agregamos los datos de fecha de inscripcion y egreso?
    //Similar a FacturaProducto
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Estudiante> inscriptos;

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
