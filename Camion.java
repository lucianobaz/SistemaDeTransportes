public class Camion {
    private String matricula;
    private String modelo;
    private String tipo;
    private double potencia;

    public Camion(String matricula, String modelo, String tipo, double potencia) {
        this.matricula = matricula != null ? matricula.toUpperCase() : null;
        this.modelo = modelo;
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public boolean esMatriculaValida() {
        return matricula != null && matricula.length() >= 7 && matricula.contains(" ");
    }

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
