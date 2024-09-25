package ArqWebJPA;

import ArqWebJPA.Entity.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //c) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
        //Ordenamiento de estudiantes por apellidos (de menor a mayor alfabeticamente).

        List<Estudiante>estudiantes = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido ASC", Estudiante.class).getResultList();
        estudiantes.forEach(System.out::println);
        //Estudiante.class indica de que tipo es el resultado

        System.out.println("/////////////////////////////////////////////////////////");

        //e) recuperar todos los estudiantes, en base a su género.
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class);
        query.setParameter("genero", "Masculino");
        List<Estudiante> estudiantesSegunGenero = query.getResultList();
        estudiantesSegunGenero.forEach(System.out::println);

        //el metodo createQuery devuelve un objeto de tipo TypedQuery
        //Por eso a query luego le hago el .getResultList()

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
