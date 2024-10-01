package ArqWebJPA.Repository;

import ArqWebJPA.DTO.EstudianteDTO;
import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    public abstract void addEstudiante(Estudiante estudiante);
    public abstract List<EstudianteDTO> getEstudiantesOrdenApellido();
    public abstract List<EstudianteDTO> getEstudiantesSegunGenero(String genero);
    public abstract EstudianteDTO getEstudianteSegunNroLibreta(int nroLibreta);
}
