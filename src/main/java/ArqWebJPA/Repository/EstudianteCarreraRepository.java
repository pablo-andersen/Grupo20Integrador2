package ArqWebJPA.Repository;

import ArqWebJPA.DTO.EstudianteDTO;
import java.util.List;

public interface EstudianteCarreraRepository {

    public List<EstudianteDTO> getEstudiantesByCarreraByLocalidad(String unaCarrera, String unaLocalidad);

}
