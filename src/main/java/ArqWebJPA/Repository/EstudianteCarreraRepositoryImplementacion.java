package ArqWebJPA.Repository;

import ArqWebJPA.DTO.EstudianteDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteCarreraRepositoryImplementacion implements EstudianteCarreraRepository{
    private EntityManager em;

    public EstudianteCarreraRepositoryImplementacion(EntityManager em) {
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ArqWebJPA.DTO.EstudianteDTO> getEstudiantesByCarreraByLocalidad(String nombreCarrera, String nombreLocalidad) {

        List<EstudianteDTO> estudiantes;
        //De la entidad EstudianteCarrera se queda con aquellos estudiantes que todavía no egresaron, para no recuperar
        //el histórico de estudiantes de esa localidad que alguna vez estuvieron inscriptos en esa carrera pero ya egresaron.

        estudiantes = em.createQuery("SELECT NEW ArqWebJPA.DTO.EstudianteDTO(ec.estudiante.nombres, ec.estudiante.apellido, ec.estudiante.genero, ec.estudiante.localidad)" +
                       "FROM EstudianteCarrera ec JOIN ec.carrera c JOIN ec.estudiante e " +
                       "WHERE c.nombre =:nombreCarrera " +
                       "AND e.localidad = :nombreLocalidad " +
                       "AND ec.fecha_egreso = null")
               .setParameter("nombreCarrera",nombreCarrera)
               .setParameter("nombreLocalidad",nombreLocalidad)
               .getResultList();

        return estudiantes;
    }
}
