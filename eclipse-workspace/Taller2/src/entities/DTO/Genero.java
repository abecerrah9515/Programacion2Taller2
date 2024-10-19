package entities.DTO;

public class Genero {

    private Long idGenero;

    private String descripcion;

    private String abreviatura;

    // Constructor vacío
    public Genero() {}
    

    // Getters y Setters
    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    // Método toString para imprimir el objeto fácilmente
    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", descripcion='" + descripcion + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
