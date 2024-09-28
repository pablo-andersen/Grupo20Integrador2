package ArqWebJPA.Repository;

import ArqWebJPA.DTO.CarreraDTO;

import java.util.List;

public class CarreraRepositoryMySQL implements CarreraRepository{


    @Override
    public List<CarreraDTO> getCarrerasConIncriptosOrdenadas() {
        List<CarreraDTO> carreraDTOS = null;
        return carreraDTOS;
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
