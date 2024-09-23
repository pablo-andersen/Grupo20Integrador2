package ArqWebJPA;

import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class Insert
{
    public static void main( String[] args ){
        try {

            //CONSULTA: Donde especificamos sobre qué BDD trabajamos? (Docker??) No se importan los drivers, tenemos que
            //hacer algo con el EntityManager?
            //RTA: META-INF y ahí se especifica en el XML
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            Estudiante e1 = new Estudiante(30555444,"Pablo", "Lopez", LocalDate.of(1985, 12, 20),"masculino", "Tandil");
            manager.persist(e1);



                    Estudiante e2 = new Estudiante(30555445, "Lucia", "Garcia", LocalDate.of(1998, 1, 15), "femenino", "Mar del Plata");
                    Estudiante e3 = new Estudiante(30555446, "Juan", "Martinez", LocalDate.of(1996, 3, 22), "masculino", "Buenos Aires");
                    Estudiante e4 = new Estudiante(30555447, "Ana", "Perez", LocalDate.of(1994, 7, 9), "femenino", "La Plata");
                    Estudiante e5 = new Estudiante(30555448, "Carlos", "Diaz", LocalDate.of(1997, 8, 13), "masculino", "Rosario");
                    Estudiante e6 = new Estudiante(30555449, "Maria", "Sanchez", LocalDate.of(1993, 11, 3), "femenino", "Cordoba");
                    Estudiante e7 = new Estudiante(30555450, "Sergio", "Romero", LocalDate.of(1999, 5, 29), "masculino", "Mendoza");
                    Estudiante e8 = new Estudiante(30555451, "Laura", "Torres", LocalDate.of(1992, 9, 19), "femenino", "Santa Fe");
                    Estudiante e9 = new Estudiante(30555452, "Martin", "Gomez", LocalDate.of(1995, 4, 10), "masculino", "San Juan");
                    Estudiante e10 = new Estudiante(30555453, "Paula", "Ruiz", LocalDate.of(1996, 2, 25), "femenino", "Tucuman");
                    Estudiante e11 = new Estudiante(30555454, "Jorge", "Alvarez", LocalDate.of(1994, 12, 14), "masculino", "Salta");
                    Estudiante e12 = new Estudiante(30555455, "Sofia", "Ramirez", LocalDate.of(1997, 6, 20), "femenino", "Entre Rios");
                    Estudiante e13 = new Estudiante(30555456, "Diego", "Fernandez", LocalDate.of(1999, 11, 5), "masculino", "Catamarca");
                    Estudiante e14 = new Estudiante(30555457, "Carolina", "Acosta", LocalDate.of(1993, 10, 31), "femenino", "Neuquen");
                    Estudiante e15 = new Estudiante(30555458, "Miguel", "Benitez", LocalDate.of(1996, 9, 12), "masculino", "Jujuy");
                    Estudiante e16 = new Estudiante(30555459, "Gabriela", "Molina", LocalDate.of(1992, 1, 28), "femenino", "Corrientes");
                    Estudiante e17 = new Estudiante(30555460, "Hector", "Morales", LocalDate.of(1998, 5, 7), "masculino", "Misiones");
                    Estudiante e18 = new Estudiante(30555461, "Natalia", "Cabrera", LocalDate.of(1993, 8, 18), "femenino", "Chaco");
                    Estudiante e19 = new Estudiante(30555462, "Fernando", "Herrera", LocalDate.of(1995, 2, 16), "masculino", "Formosa");
                    Estudiante e20 = new Estudiante(30555463, "Victoria", "Castro", LocalDate.of(1994, 4, 24), "femenino", "San Luis");

                    manager.persist(e1);
                    manager.persist(e2);
                    manager.persist(e3);
                    manager.persist(e4);
                    manager.persist(e5);
                    manager.persist(e6);
                    manager.persist(e7);
                    manager.persist(e8);
                    manager.persist(e9);
                    manager.persist(e10);
                    manager.persist(e11);
                    manager.persist(e12);
                    manager.persist(e13);
                    manager.persist(e14);
                    manager.persist(e15);
                    manager.persist(e16);
                    manager.persist(e17);
                    manager.persist(e18);
                    manager.persist(e19);
                    manager.persist(e20);

            Carrera c1 = new Carrera("TUDAI", "Exactas");
            Carrera c2 = new Carrera("Ingenieria", "Exactas");
            Carrera c3 = new Carrera("TUPAR", "Exactas");
            manager.persist(c1);
            manager.persist(c2);
            manager.persist(c3);


            manager.getTransaction().commit();
            manager.close();
            emf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
