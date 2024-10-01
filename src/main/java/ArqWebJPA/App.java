package ArqWebJPA;

import ArqWebJPA.DTO.CarreraDTO;
import ArqWebJPA.DTO.EstudianteDTO;
import ArqWebJPA.DTO.ReporteCarreraDTO;
import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;
import ArqWebJPA.Entity.EstudianteCarrera;
import ArqWebJPA.Repository.CarreraRepositoryImplementacion;
import ArqWebJPA.Repository.EstudianteCarreraRepositoryImplementacion;
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


        EstudianteRepositoryImplementacion estudianteRepository = new EstudianteRepositoryImplementacion(em);
        CarreraRepositoryImplementacion carreraRepository = new CarreraRepositoryImplementacion(em);
        EstudianteCarreraRepositoryImplementacion estudianteCarreraRepository = new EstudianteCarreraRepositoryImplementacion(em);

        //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        System.out.println("\n////////////////////// CONSIGNA 2-C) /////////////////////////////////\n");

        List<EstudianteDTO>estudiantesOrdenApellido = estudianteRepository.getEstudiantesOrdenApellido();
        estudiantesOrdenApellido.forEach(System.out::println);


        //d)recuperar un estudiante, en base a su número de libreta universitaria.
        System.out.println("\n////////////////////// CONSIGNA 2-D) ///////////////////////////////// \n");

        EstudianteDTO e = estudianteRepository.getEstudianteSegunNroLibreta(18);
        System.out.println(e.toString());


        //e) recuperar todos los estudiantes, en base a su género.
        System.out.println("\n////////////////////// CONSIGNA 2-E) ///////////////////////////////// \n");

        List<EstudianteDTO> estudiantesSegunGenero = estudianteRepository.getEstudiantesSegunGenero("Masculino");
        estudiantesSegunGenero.forEach(System.out::println);


        //f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        System.out.println("\n////////////////////// CONSIGNA 2-F) ///////////////////////////////// \n");
        List<CarreraDTO> carrerasCantInscriptos = carreraRepository.getCarrerasConInscriptosOrdenadas();
        carrerasCantInscriptos.forEach(System.out::println);


        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        System.out.println("\n////////////////////// CONSIGNA 2-G) ///////////////////////////////// \n");

        String nombreCarrera = "TUDAI";
        String nombreLocalidad = "Tandil";

        @SuppressWarnings("unchecked")
        List<EstudianteDTO> estudiantesByCarreraByLocalidad = estudianteCarreraRepository.getEstudiantesByCarreraByLocalidad(nombreCarrera, nombreLocalidad);
        estudiantesByCarreraByLocalidad.forEach(System.out::println);


        //EJERCICIO 3)Generar un reporte de las carreras, que para cada carrera incluya información de los
        //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        //los años de manera cronológica.
        System.out.println("\n////////////////////// CONSIGNA 3) ///////////////////////////////// \n");


        List<ReporteCarreraDTO> reporteCarreras = carreraRepository.getReporteCarreras();
        reporteCarreras.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
