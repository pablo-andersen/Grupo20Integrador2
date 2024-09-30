package ArqWebJPA.Repository;
//CONSULTA: esto reemplaza a los DAO's?? El metodo concreto dónde va?

import ArqWebJPA.DTO.CarreraDTO;
import ArqWebJPA.DTO.ReporteCarreraDTO;

import java.util.List;

public interface CarreraRepository {
    public abstract List<CarreraDTO> getCarrerasConIncriptosOrdenadas();

    public abstract void addCarrera();

    public abstract void getAllCarreras();

    public abstract boolean matricularEstudiante();

    public abstract boolean deleteCarrera();

    public abstract List<ReporteCarreraDTO> getReporteCarreras();

}
