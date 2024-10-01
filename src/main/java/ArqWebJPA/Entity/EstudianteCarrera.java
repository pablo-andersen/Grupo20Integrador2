package ArqWebJPA.Entity;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
//CONSULTA: esta clase intermedia la tenemos que codear o la genera automáticamente JPA con la anotación @ManyToMany
@Entity
public class EstudianteCarrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private LocalDate fecha_inscripcion;
    @Column
    private LocalDate fecha_egreso;

    @ManyToOne
    private Estudiante estudiante;

    @ManyToOne
    private Carrera carrera;

    public EstudianteCarrera() {

    }

    public EstudianteCarrera(LocalDate fecha_inscripcion, LocalDate fecha_egreso, Estudiante estudiante, Carrera carrera) {
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_egreso = fecha_egreso;
        this.estudiante = estudiante;
        this.carrera = carrera;
    }
    public EstudianteCarrera(Estudiante estudiante, Carrera carrera) {
        this.fecha_inscripcion = LocalDate.now();
        this.fecha_egreso = null;
        this.estudiante = estudiante;
        this.carrera = carrera;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public LocalDate getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(LocalDate fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }
}
