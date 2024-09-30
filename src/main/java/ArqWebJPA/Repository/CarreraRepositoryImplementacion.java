package ArqWebJPA.Repository;

import ArqWebJPA.DTO.CarreraDTO;
import ArqWebJPA.DTO.ReporteCarreraDTO;
import ArqWebJPA.Entity.Carrera;
import ArqWebJPA.Entity.Estudiante;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CarreraRepositoryImplementacion implements CarreraRepository{
    private EntityManager em;

    public CarreraRepositoryImplementacion(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CarreraDTO> getCarrerasConIncriptosOrdenadas() {
        List<CarreraDTO> carrerasCantInscriptos = em.createQuery("SELECT NEW ArqWebJPA.DTO.CarreraDTO(c.nombre)" +
                " FROM Carrera c WHERE SIZE(c.inscriptos) > 0 ORDER BY SIZE(c.inscriptos) ASC",CarreraDTO.class).getResultList();
//        TypedQuery<Carrera> query2 = em.createQuery(consulta, Carrera.class);
//        List<Carrera> carrerasCantInscriptos = query2.getResultList();
        return carrerasCantInscriptos;
    }

    @Override
    public void addCarrera() {

    }

    @Override
    public void getAllCarreras() {

    }

    @Override
    public boolean matricularEstudiante() {
        return false;
    }

    @Override
    public boolean deleteCarrera() {
        return false;
    }

    @Override
    public List<ReporteCarreraDTO> getReporteCarreras() {
        Query query = em.createNativeQuery("SELECT nombre AS nombre_carrera, EXTRACT(YEAR FROM anio) AS anio," +
                "SUM(estudiantes_inscriptos) AS estudiantes_inscriptos, " +
                "SUM(estudiantes_egresados) AS estudiantes_egresados " +
                "FROM ( " +
                         //Inscripciones
                        "SELECT ec.fecha_incscripcion AS anio, ca.nombre, " +
                        "COUNT(ec.estudiante_nro_Libreta) AS estudiantes_inscriptos, " +
                        "0 AS estudiantes_egresados FROM Carrera ca JOIN " +
                        "EstudianteCarrera ec ON ca.idCarrera = ec.carrera_idCarrera " +
                        "JOIN Estudiante e ON e.nro_Libreta = ec.estudiante_nro_Libreta " +
                        "GROUP BY ca.nombre, ec.fecha_incscripcion " +

                        "UNION ALL " +

                                // Egresos
                        "SELECT ec.fecha_egreso AS anio, ca.nombre, 0 AS estudiantes_inscriptos, " +
                        "COUNT(ec.estudiante_nro_Libreta) AS estudiantes_egresados " +
                        "FROM Carrera ca JOIN EstudianteCarrera ec ON ca.idCarrera = ec.carrera_idCarrera " +
                        "JOIN Estudiante e ON e.nro_Libreta = ec.estudiante_nro_Libreta WHERE " +
                        "ec.fecha_egreso IS NOT NULL " +
                        "GROUP BY ca.nombre, ec.fecha_egreso) AS inscripciones_egresos " +
                        "GROUP BY nombre_carrera, anio ORDER BY nombre_carrera,anio ");


        // Obtener los resultados y mapearlos al DTO
        List<Object[]> resultados = query.getResultList();
        List<ReporteCarreraDTO> reporteDTOs = new ArrayList<>();

        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            int anio = ((Number) fila[1]).intValue(); // Cast a Number y luego a int
            int estudiantesInscriptos = ((Number) fila[2]).intValue();
            int estudiantesEgresados = ((Number) fila[3]).intValue();

            // Crear y agregar el DTO a la lista
            ReporteCarreraDTO dto = new ReporteCarreraDTO(nombreCarrera, anio, estudiantesInscriptos, estudiantesEgresados);
            reporteDTOs.add(dto);
        }

        return reporteDTOs;


    }
}
