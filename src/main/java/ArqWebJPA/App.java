package ArqWebJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        try {

            //CONSULTA: Donde especificamos sobre qué BDD trabajamos? (Docker??) No se importan los drivers, tenemos que
            //hacer algo con el EntityManager?
            //RTA: META-INF y ahí se especifica en el XML
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArqWebJPA");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            /*Hacer cosas
            *
            * 1) dar de alta carreras
            * 2) dar de alta estudiantes
            * 3) matricular estudiantes
            * 4) sacar reportes
            * Clase nombreClase = new Clase();
            * manager.persist(nombreClase);
            *
            * se puede repetir varias veces...
            *
            */

            manager.getTransaction().commit();
            manager.close();
            emf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
