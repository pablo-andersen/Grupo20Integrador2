package ArqWebJPA.Repository;
//CONSULTA: esto reemplaza a los DAO's?? El metodo concreto dónde va?

public interface CarreraRepository {

    public abstract void addCarrera();

    public abstract void getAllCarreras();

    public abstract boolean matricularEstudiante();

    public abstract boolean deleteCarrera();

}
