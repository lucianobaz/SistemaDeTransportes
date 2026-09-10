import java.util.ArrayList;
import java.util.List;

//===================================================================
//Clase Camionero
//Representa al encargado de transportar y distribuir los paquetes
//===================================================================
public class Camionero {
    //Atributos del camionero
    private String ci; //Cédula limpia (solo números)
    private String nombre;
    private String telefono;
    private String direccion;
    private double salario; //En pesos uruguayos ($U)
    private String ciudadResidencia;
    private List<String> paquetesAsignados; //Lista de códigos de paquetes transportados

    //Constructor: limpia automáticamente la cédula al crear el objeto
    public Camionero(String ci, String nombre, String telefono, String direccion, double salario, String ciudadResidencia) {
        setCi(ci); //Aplica limpiarCI
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.salario = salario;
        this.ciudadResidencia = ciudadResidencia;
        this.paquetesAsignados = new ArrayList<>();
    }

    //Método que elimina puntos y guiones usando expresión regular "[.-]"
    public String limpiarCI(String ciConFormato) {
        if (ciConFormato == null) return "";
        return ciConFormato.replaceAll("[.-]", "").trim();
    }

    //Getters y Setters
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = (ci != null) ? limpiarCI(ci) : "";
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
