package ArqWebJPA.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="ESTUDIANTE_CARRERA")
public class EstudianteCarrera {
    @Id
    @Column(name="nro_libreta")
    private int nro_Libreta;
    @Id
    @Column(name = "id_carrera")
    private int id_carrera;
    @Column(name = "fecha_inscripcion")
    private LocalDate fecha_incscripcion;
    @Column(name = "fecha_egreso")
    private LocalDate fecha_egreso;

    public EstudianteCarrera() {

    }

    public EstudianteCarrera(int nro_Libreta, int id_carrera, LocalDate fecha_incscripcion, LocalDate fecha_egreso) {
        this.nro_Libreta = nro_Libreta;
        this.id_carrera = id_carrera;
        this.fecha_incscripcion = fecha_incscripcion;
        this.fecha_egreso = fecha_egreso;
    }


    public int getNro_Libreta() {
        return nro_Libreta;
    }

    public void setNro_Libreta(int nro_Libreta) {
        this.nro_Libreta = nro_Libreta;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public LocalDate getFecha_incscripcion() {
        return fecha_incscripcion;
    }

    public void setFecha_incscripcion(LocalDate fecha_incscripcion) {
        this.fecha_incscripcion = fecha_incscripcion;
    }

    public LocalDate getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(LocalDate fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }
}
