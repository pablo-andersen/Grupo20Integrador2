package ArqWebJPA.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
//CONSULTA: La anotacion @Table cuando se coloca? Es opcional?
public class Estudiante {
    @Id
    @Column(name = "nro_libreta")
    private int nro_Libreta;
    @Column(name = "nro_documento")
    private int nro_documento;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;
    @Column(name = "genero")
    private String genero;
    @Column(name = "localidad")
    private String localidad;

    //CONSULTA: Esto genera automáticamente la tabla intermedia? como le agregamos los datos de fecha de inscripcion y egreso?
    //Similar a FacturaProducto
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "inscriptos")
    private List<Carrera> carreras;

    public Estudiante() {

    }

    public Estudiante(int nro_Libreta, int nro_documento, String nombres, String apellido, LocalDate fecha_nacimiento, String genero, String localidad) {
        this.nro_Libreta = nro_Libreta;
        this.nro_documento = nro_documento;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.localidad = localidad;
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
                ", carreras=" + carreras +
                '}';
    }
}
