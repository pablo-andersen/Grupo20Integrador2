package ArqWebJPA.Repository;
//CONSULTA: esto reemplaza a los DAO's?? El metodo concreto dónde va?

import ArqWebJPA.DTO.CarreraDTO;
import ArqWebJPA.DTO.ReporteCarreraDTO;
import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;

import java.util.List;

public interface CarreraRepository {
    public abstract List<CarreraDTO> getCarrerasConInscriptosOrdenadas();

    public abstract void addCarrera(Carrera carrera);

    public abstract void getAllCarreras();

    public abstract void matricularEstudianteById(int nroLibreta, int id_carrera);

    public abstract void matricularEstudianteByNombre(String nombreAlumno, String apellidoAlumno, String nombreCarrera);

    public abstract boolean deleteCarrera();

    public abstract List<ReporteCarreraDTO> getReporteCarreras();

}
