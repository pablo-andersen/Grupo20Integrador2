package ArqWebJPA.Repository;

import ArqWebJPA.DTO.EstudianteDTO;
import ArqWebJPA.Entity.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraRepository {

    public abstract void addEstudianteCarrera(EstudianteCarrera estudianteCarrera);
    public List<EstudianteDTO> getEstudiantesByCarreraByLocalidad(String unaCarrera, String unaLocalidad);

}
