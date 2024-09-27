package ArqWebJPA;

import ArqWebJPA.DTO.CarreraDTO;
import ArqWebJPA.DTO.EstudianteDTO;
import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;
import ArqWebJPA.Entity.EstudianteCarrera;
import ArqWebJPA.Repository.CarreraRepositoryImplementacion;
import ArqWebJPA.Repository.EstudianteRepository;
import ArqWebJPA.Repository.EstudianteRepositoryImplementacion;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("\n//////////////////////CONSIGNA 2-C)/////////////////////////////////\n");

        EstudianteRepositoryImplementacion estudianteRepository = new EstudianteRepositoryImplementacion(em);
        CarreraRepositoryImplementacion carreraRepository = new CarreraRepositoryImplementacion(em);
        List<EstudianteDTO>estudiantesOrdenApellido = estudianteRepository.getEstudiantesOrdenApellido();
        estudiantesOrdenApellido.forEach(System.out::println);


        System.out.println("\n//////////////////////CONSIGNA 2-E)///////////////////////////////// \n");

        List<EstudianteDTO> estudiantesSegunGenero = estudianteRepository.getEstudiantesSegunGenero("Masculino");
        estudiantesSegunGenero.forEach(System.out::println);


        //d)recuperar un estudiante, en base a su número de libreta universitaria.
        EstudianteDTO e = estudianteRepository.getEstudianteSegunNroLibreta(18);
        System.out.println("-----EJERCICIO D-----");
        System.out.println(e.toString());



        System.out.println("\n/////////////////////////////////////////////////////////\n");


        //f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        System.out.println("-----EJERCICIO F-----");
        List<CarreraDTO> carrerasCantInscriptos = carreraRepository.getCarrerasConIncriptosOrdenadas();
        carrerasCantInscriptos.forEach(System.out::println);

        //el metodo createQuery devuelve un objeto de tipo TypedQuery
        //Por eso a query luego le hago el .getResultList()

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
