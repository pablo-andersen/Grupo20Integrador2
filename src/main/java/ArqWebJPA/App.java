package ArqWebJPA;

import ArqWebJPA.DTO.EstudianteDTO;
import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;
import ArqWebJPA.Entity.EstudianteCarrera;
import ArqWebJPA.Repository.EstudianteRepository;
import ArqWebJPA.Repository.EstudianteRepositoryImplementacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("\n//////////////////////CONSIGNA 2-C)/////////////////////////////////\n");

        EstudianteRepositoryImplementacion estudianteRepository = new EstudianteRepositoryImplementacion(em);
        List<EstudianteDTO>estudiantesOrdenApellido = estudianteRepository.getEstudiantesOrdenApellido();
        estudiantesOrdenApellido.forEach(System.out::println);


        System.out.println("\n//////////////////////CONSIGNA 2-E)///////////////////////////////// \n");

        List<EstudianteDTO> estudiantesSegunGenero = estudianteRepository.getEstudiantesSegunGenero("Masculino");
        //d)recuperar un estudiante, en base a su número de libreta universitaria.
        String jpql = "SELECT e FROM Estudiante e WHERE e.nro_Libreta = :nroLibreta";
        Query q = em.createQuery(jpql, Estudiante.class);
        q.setParameter("nroLibreta", 30555450);
        Estudiante e = (Estudiante) q.getSingleResult();
        System.out.println(e.toString());

        //Estudiante estudiante = (Estudiante) em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_Libreta = :nroLibreta").setParameter("nroLibreta", 30555450);
        //System.out.println(estudiante.toString());



        System.out.println("\n/////////////////////////////////////////////////////////\n");


        //f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        String consulta = "SELECT c FROM Carrera c WHERE SIZE(c.inscriptos) > 0 ORDER BY SIZE(c.inscriptos) ASC";
        TypedQuery<Carrera> query2 = em.createQuery(consulta, Carrera.class);
        List<Carrera> carrerasCantInscriptos = query2.getResultList();
        carrerasCantInscriptos.forEach(System.out::println);

        //el metodo createQuery devuelve un objeto de tipo TypedQuery
        //Por eso a query luego le hago el .getResultList()

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
