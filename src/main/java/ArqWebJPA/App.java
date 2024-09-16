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
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArqWebJPA");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            /*Hacer cosas
            *
            * Clase nombreClase = new Clase();
            * manager.persist(nombreClase);
            *
            * se puede repetir varias veces....
            */

            manager.getTransaction().commit();
            manager.close();
            emf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
