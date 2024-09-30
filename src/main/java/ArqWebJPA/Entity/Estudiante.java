package ArqWebJPA.Entity;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nro_Libreta;
    @Column
    private int nro_documento;
    @Column
    private String nombres;
    @Column
    private String apellido;
    @Column
    private LocalDate fecha_nacimiento;
    @Column
    private String genero;
    @Column
    private String localidad;

    @OneToMany(mappedBy = "estudiante")  //se refiere al atributo de estudianteCarrera
    private List<EstudianteCarrera> carrerasInscriptas;

    public Estudiante() {

    }

    public Estudiante(int nro_documento, String nombres, String apellido, LocalDate fecha_nacimiento, String genero, String localidad) {
        this.nro_documento = nro_documento;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.localidad = localidad;
        this.carrerasInscriptas = new ArrayList<EstudianteCarrera>();
    }


    public int getNro_Libreta() {
        return nro_Libreta;
    }

    public void setNro_Libreta(int nro_Libreta) {
        this.nro_Libreta = nro_Libreta;
    }

    public int getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(int nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEdad(){
        return Period.between(fecha_nacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nro_Libreta=" + nro_Libreta +
                ", nro_documento=" + nro_documento +
                ", nombres='" + nombres + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", genero='" + genero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", carreras=" + carrerasInscriptas +
                '}';
    }
}
