package ArqWebJPA.DTO;

public class CarreraDTO {

    private String nombreCarrera;
    private int inscriptos;
    private int graduados;

    public CarreraDTO(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.inscriptos = 0;
        this.graduados = 0;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(int inscriptos) {
        this.inscriptos = inscriptos;
    }

    public int getGraduados() {
        return graduados;
    }

    public void setGraduados(int graduados) {
        this.graduados = graduados;
    }
}
