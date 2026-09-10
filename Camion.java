//===================================================================
// Clase Camion
//===================================================================
public class Camion {
    //Atributos del camión
    private String matricula; //Se almacena en mayúsculas
    private String modelo;
    private String tipo;
    private double potencia;

    //Constructor: asegura que la matrícula se guarde en mayúsculas con toUpperCase()
    public Camion(String matricula, String modelo, String tipo, double potencia) {
        this.matricula = matricula != null ? matricula.toUpperCase() : null;
        this.modelo = modelo;
        this.tipo = tipo;
        this.potencia = potencia;
    }

    //Valida que la matrícula tenga al menos 7 caracteres y contenga un espacio (ej: "SAB 1234")
    public boolean esMatriculaValida() {
        return matricula != null && matricula.length() >= 7 && matricula.contains(" ");
    }

    //Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula != null ? matricula.toUpperCase() : null;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }
}
