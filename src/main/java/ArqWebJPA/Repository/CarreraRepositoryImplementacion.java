package ArqWebJPA.Repository;

import ArqWebJPA.DTO.CarreraDTO;
import ArqWebJPA.Entity.Carrera;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
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
}
