package ArqWebJPA;

import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;

import javax.persistence.*;
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

        //d)recuperar un estudiante, en base a su número de libreta universitaria.
        String jpql = "SELECT e FROM Estudiante e WHERE e.nro_Libreta = :nroLibreta";
        Query q = em.createQuery(jpql, Estudiante.class);
        q.setParameter("nroLibreta", 30555450);
        Estudiante e = (Estudiante) q.getSingleResult();
        System.out.println(e.toString());

        //Estudiante estudiante = (Estudiante) em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_Libreta = :nroLibreta").setParameter("nroLibreta", 30555450);
        //System.out.println(estudiante.toString());

        //e) recuperar todos los estudiantes, en base a su género.
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class);
        query.setParameter("genero", "Femenino");
        List<Estudiante> estudiantesSegunGenero = query.getResultList();
        estudiantesSegunGenero.forEach(System.out::println);

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
