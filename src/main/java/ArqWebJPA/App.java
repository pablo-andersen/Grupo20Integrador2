package ArqWebJPA;

import ArqWebJPA.DTO.EstudianteDTO;
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
        estudiantesSegunGenero.forEach(System.out::println);

        System.out.println("\n/////////////////////////////////////////////////////////\n");



        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
