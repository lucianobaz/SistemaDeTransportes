import java.util.ArrayList;
import java.util.List;

public class Camionero {
    private String ci;
    private String nombre;
    private String telefono;
    private String direccion;
    private double salario;
    private String ciudadResidencia;
    private List<String> paquetesAsignados;

    public Camionero(String ci, String nombre, String telefono, String direccion, double salario, String ciudadResidencia) {
        this.ci = ci;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.salario = salario;
        this.ciudadResidencia = ciudadResidencia;
        this.paquetesAsignados = new ArrayList<>();
    }

    public String limpiarCI(String ciConFormato) {
        return ciConFormato.replaceAll("[.-]", "");
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public List<String> getPaquetesAsignados() {
        return paquetesAsignados;
    }

    public void setPaquetesAsignados(List<String> paquetesAsignados) {
        this.paquetesAsignados = paquetesAsignados;
    }
}
