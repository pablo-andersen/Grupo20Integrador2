package ArqWebJPA.Repository;

import ArqWebJPA.DTO.EstudianteDTO;
import ArqWebJPA.Entity.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteRepositoryImplementacion implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImplementacion(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addEstudiante(Estudiante estudiante) {
        if(!em.contains(estudiante)) {
            em.persist(estudiante);
        }
        else{
            em.merge(estudiante);
        }
    }


    //c) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    //Ordenamiento de estudiantes por apellidos (de menor a mayor alfabeticamente).
    @Override
    public List<EstudianteDTO> getEstudiantesOrdenApellido() {
        List<EstudianteDTO>estudiantes =
                em.createQuery("SELECT new ArqWebJPA.DTO.EstudianteDTO(e.nombres,e.apellido, e.genero,e.localidad)" +
                                       " FROM Estudiante e ORDER BY e.apellido ASC", EstudianteDTO.class).getResultList();
        //Estudiante.class indica de que tipo es el resultado
        return estudiantes;
    }

    //e) Recuperar todos los estudiantes, en base a su género.
    @Override
    public List<EstudianteDTO> getEstudiantesSegunGenero(String genero) {
        TypedQuery<EstudianteDTO> query =
                em.createQuery("SELECT new ArqWebJPA.DTO.EstudianteDTO(e.nombres,e.apellido, e.genero,e.localidad)" +
                                       " FROM Estudiante e WHERE e.genero = :genero", EstudianteDTO.class);
        query.setParameter("genero", genero);
        List<EstudianteDTO> estudiantesSegunGenero = query.getResultList();
        return estudiantesSegunGenero;
    }
    //el metodo createQuery devuelve un objeto de tipo TypedQuery
    //Por eso a query luego le hago el .getResultList()

    @Override
    public EstudianteDTO getEstudianteSegunNroLibreta(int nroLibreta){
        String jpql = "SELECT  new ArqWebJPA.DTO.EstudianteDTO(e.nombres,e.apellido, e.genero,e.localidad)" +
                " FROM Estudiante e WHERE e.nro_Libreta = :nroLibreta";
        TypedQuery<EstudianteDTO> q = em.createQuery(jpql, EstudianteDTO.class);
        q.setParameter("nroLibreta", nroLibreta);
        EstudianteDTO e = q.getSingleResult();
        return e;
    }

}
