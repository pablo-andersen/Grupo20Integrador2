package ArqWebJPA;

import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;
import ArqWebJPA.Entity.EstudianteCarrera;
import ArqWebJPA.Repository.CarreraRepositoryImplementacion;
import ArqWebJPA.Repository.EstudianteCarreraRepositoryImplementacion;
import ArqWebJPA.Repository.EstudianteRepositoryImplementacion;

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

            /**
             * GRUPO 20:
             * INTEGRANTES:
             *             Gianluca Ceschinelli
             *             Paulo Alvarez
             *             Josefina Belaunzaran
             *             Manuel Cerdeira
             *             Pablo Andersen
             *
             *         Se entrega una sola copia por ZIP
             *
             *
             *  Las consignas 2a) y 2b), al igual que la lógica de creación de tablas y registros, se separa en la clase Insert.java.
             *
             *  El resto de las consignas se encuentran en la clase App.java
             */



            //CONSULTA: Donde especificamos sobre qué BDD trabajamos? (Docker??) No se importan los drivers, tenemos que
            //hacer algo con el EntityManager?
            //RTA: META-INF y ahí se especifica en el XML
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            //a) Dar de alta un estudiante
            System.out.println("\n//////////////////////CONSIGNA 2-A)/////////////////////////////////\n");


            Estudiante e1 = new Estudiante(30555444, "Pablo", "Lopez", LocalDate.of(1985, 12, 20), "masculino", "Tandil");
            Estudiante e2 = new Estudiante(30555445, "Lucia", "Garcia", LocalDate.of(1998, 1, 15), "femenino", "Mar del Plata");
            Estudiante e3 = new Estudiante(30555446, "Juan", "Martinez", LocalDate.of(1996, 3, 22), "masculino", "Buenos Aires");
            Estudiante e4 = new Estudiante(30555447, "Ana", "Perez", LocalDate.of(1994, 7, 9), "femenino", "Tandil");
            Estudiante e5 = new Estudiante(30555448, "Carlos", "Diaz", LocalDate.of(1997, 8, 13), "masculino", "Tandil");
            Estudiante e6 = new Estudiante(30555449, "Maria", "Sanchez", LocalDate.of(1993, 11, 3), "femenino", "Tandil");
            Estudiante e7 = new Estudiante(30555450, "Sergio", "Romero", LocalDate.of(1999, 5, 29), "masculino", "Tandil");
            Estudiante e8 = new Estudiante(30555451, "Laura", "Torres", LocalDate.of(1992, 9, 19), "femenino", "Santa Fe");
            Estudiante e9 = new Estudiante(30555452, "Martin", "Gomez", LocalDate.of(1995, 4, 10), "masculino", "Tandil");
            Estudiante e10 = new Estudiante(30555453, "Paula", "Ruiz", LocalDate.of(1996, 2, 25), "femenino", "Tucuman");
            Estudiante e11 = new Estudiante(30555454, "Jorge", "Alvarez", LocalDate.of(1994, 12, 14), "masculino", "Salta");
            Estudiante e12 = new Estudiante(30555455, "Sofia", "Ramirez", LocalDate.of(1997, 6, 20), "femenino", "Entre Rios");
            Estudiante e13 = new Estudiante(30555456, "Diego", "Fernandez", LocalDate.of(1999, 11, 5), "masculino", "Tandil");
            Estudiante e14 = new Estudiante(30555457, "Carolina", "Acosta", LocalDate.of(1993, 10, 31), "femenino", "Neuquen");
            Estudiante e15 = new Estudiante(30555458, "Miguel", "Benitez", LocalDate.of(1996, 9, 12), "masculino", "Jujuy");
            Estudiante e16 = new Estudiante(30555459, "Gabriela", "Molina", LocalDate.of(1992, 1, 28), "femenino", "Tandil");
            Estudiante e17 = new Estudiante(30555460, "Hector", "Morales", LocalDate.of(1998, 5, 7), "masculino", "Misiones");
            Estudiante e18 = new Estudiante(30555461, "Natalia", "Cabrera", LocalDate.of(1993, 8, 18), "femenino", "Tandil");
            Estudiante e19 = new Estudiante(30555462, "Fernando", "Herrera", LocalDate.of(1995, 2, 16), "masculino", "Formosa");
            Estudiante e20 = new Estudiante(30555463, "Victoria", "Castro", LocalDate.of(1994, 4, 24), "femenino", "San Luis");

            EstudianteRepositoryImplementacion estudiante = new EstudianteRepositoryImplementacion(manager);

            estudiante.addEstudiante(e1);
            estudiante.addEstudiante(e2);
            estudiante.addEstudiante(e3);
            estudiante.addEstudiante(e4);
            estudiante.addEstudiante(e5);
            estudiante.addEstudiante(e6);
            estudiante.addEstudiante(e7);
            estudiante.addEstudiante(e8);
            estudiante.addEstudiante(e9);
            estudiante.addEstudiante(e10);
            estudiante.addEstudiante(e11);
            estudiante.addEstudiante(e12);
            estudiante.addEstudiante(e13);
            estudiante.addEstudiante(e14);
            estudiante.addEstudiante(e15);
            estudiante.addEstudiante(e16);
            estudiante.addEstudiante(e17);
            estudiante.addEstudiante(e18);
            estudiante.addEstudiante(e19);
            estudiante.addEstudiante(e20);


            Carrera c1 = new Carrera("TUDAI", "Exactas");
            Carrera c2 = new Carrera("Ingenieria", "Exactas");
            Carrera c3 = new Carrera("TUPAR", "Exactas");
            Carrera c4 = new Carrera("Matematica", "Exactas");
            Carrera c5 = new Carrera("Fisica", "Exactas");
            Carrera c6 = new Carrera("TUARI", "Exactas");


            //b) matricular un estudiante en una carrera
            System.out.println("\n//////////////////////CONSIGNA 2-B)/////////////////////////////////\n");
            CarreraRepositoryImplementacion carrera = new CarreraRepositoryImplementacion(manager);

            carrera.addCarrera(c1);
            carrera.addCarrera(c2);
            carrera.addCarrera(c3);
            carrera.addCarrera(c4);
            carrera.addCarrera(c5);
            carrera.addCarrera(c6);

            carrera.matricularEstudianteByNombre("Victoria", "Castro", "Ingenieria");
            carrera.matricularEstudianteById(11,22);



            //PARA PROBAR EJERCICIO G
            EstudianteCarrera estudianteCarrera1 = new EstudianteCarrera(LocalDate.of(2021,3,1),null,e1,c1);
            EstudianteCarrera estudianteCarrera2 = new EstudianteCarrera(LocalDate.of(2020,3,1),LocalDate.of(2023,12,20),e4,c1);
            EstudianteCarrera estudianteCarrera3 = new EstudianteCarrera(LocalDate.of(2022,3,1), null, e3, c1); // Juan Martinez en TUDAI
            EstudianteCarrera estudianteCarrera4 = new EstudianteCarrera(LocalDate.of(2021,3,1), LocalDate.of(2024,12,20), e4, c2); // Ana Perez en Ingenieria (egresada)
            EstudianteCarrera estudianteCarrera5 = new EstudianteCarrera(LocalDate.of(2020,3,1), null, e5, c3); // Carlos Diaz en TUPAR
            EstudianteCarrera estudianteCarrera6 = new EstudianteCarrera(LocalDate.of(2020,3,1), LocalDate.of(2023,12,15), e6, c4); // Maria Sanchez en Matematica (egresada)
            EstudianteCarrera estudianteCarrera7 = new EstudianteCarrera(LocalDate.of(2022,3,1), null, e7, c5); // Sergio Romero en Fisica
            EstudianteCarrera estudianteCarrera8 = new EstudianteCarrera(LocalDate.of(2021,3,1), null, e8, c6); // Laura Torres en TUARI
            EstudianteCarrera estudianteCarrera9 = new EstudianteCarrera(LocalDate.of(2020,3,1), LocalDate.of(2023,11,30), e5, c1); // Carlos Diaz en TUDAI (egresado)
            EstudianteCarrera estudianteCarrera10 = new EstudianteCarrera(LocalDate.of(2021,3,1), null, e10, c2); // Paula Ruiz en Ingenieria
            EstudianteCarrera estudianteCarrera11 = new EstudianteCarrera(LocalDate.of(2022,3,1), LocalDate.of(2024,6,10), e11, c3); // Jorge Alvarez en TUPAR (egresado)
            EstudianteCarrera estudianteCarrera12 = new EstudianteCarrera(LocalDate.of(2023,3,1), null, e12, c4); // Sofia Ramirez en Matematica
            EstudianteCarrera estudianteCarrera13 = new EstudianteCarrera(LocalDate.of(2020,3,1), null, e13, c5); // Diego Fernandez en Fisica
            EstudianteCarrera estudianteCarrera14 = new EstudianteCarrera(LocalDate.of(2021,3,1), LocalDate.of(2023,12,1), e7, c1); // Carolina Acosta en TUARI (egresada)
            EstudianteCarrera estudianteCarrera15 = new EstudianteCarrera(LocalDate.of(2022,3,1), null, e15, c1); // Miguel Benitez en TUDAI
            EstudianteCarrera estudianteCarrera16 = new EstudianteCarrera(LocalDate.of(2023,3,1), null, e16, c2); // Gabriela Molina en Ingenieria
            EstudianteCarrera estudianteCarrera17 = new EstudianteCarrera(LocalDate.of(2021,3,1), LocalDate.of(2024,5,30), e17, c3); // Hector Morales en TUPAR (egresado)
            EstudianteCarrera estudianteCarrera18 = new EstudianteCarrera(LocalDate.of(2022,3,1), null, e18, c4); // Natalia Cabrera en Matematica
            EstudianteCarrera estudianteCarrera19 = new EstudianteCarrera(LocalDate.of(2023,3,1), null, e19, c5); // Fernando Herrera en Fisica
            EstudianteCarrera estudianteCarrera20 = new EstudianteCarrera(LocalDate.of(2020,3,1), LocalDate.of(2024,12,10), e20, c6); // Victoria Castro en TUARI (egresada)



            EstudianteCarreraRepositoryImplementacion estudianteCarrera = new EstudianteCarreraRepositoryImplementacion(manager);


            estudianteCarrera.addEstudianteCarrera(estudianteCarrera1);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera2);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera3);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera4);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera5);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera6);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera7);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera8);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera9);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera10);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera11);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera12);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera13);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera14);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera15);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera16);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera17);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera18);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera19);
            estudianteCarrera.addEstudianteCarrera(estudianteCarrera20);



            manager.getTransaction().commit();
            manager.close();
            emf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
