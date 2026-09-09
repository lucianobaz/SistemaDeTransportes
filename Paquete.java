// ===================================================================
// Clase Abstracta Paquete (Implementa la interfaz Rastreable)
// Sirve como molde base para PaqueteEstandar y PaqueteFragil
// ===================================================================
public abstract class Paquete implements Rastreable {
    
    // Atributos comunes a todos los paquetes (encapsulamiento privado)
    private String codigo;
    private String descripcion;
    private String destinatario;
    private String direccion;
    private Departamento departamento;
    private Camionero camionero;

    // Constructor básico sin camionero asignado inicialmente
    public Paquete(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento) {
        this(codigo, descripcion, destinatario, direccion, departamento, null);
    }

    // Constructor completo con asignación de camionero
    public Paquete(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento, Camionero camionero) {
        setCodigo(codigo); // Usamos setCodigo para que aplique la limpieza de espacios y mayúsculas
        this.descripcion = descripcion;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.departamento = departamento;
        this.camionero = camionero;
    }

    // Método abstracto: cada tipo de paquete tiene su propia fórmula de costo
    public abstract double calcularCostoEnvio();

    // Método concreto: convierte el costo en pesos ($U) a dólares ($USD) dividiendo por el tipo de cambio
    public double calcularCostoEnDolares(double tipoCambio) {
        if (tipoCambio <= 0) {
            return 0.0; // Validación simple para evitar división por cero
        }
        return this.calcularCostoEnvio() / tipoCambio;
    }

    // Método para abreviar la dirección en la etiqueta de envío
    // Reemplaza "Avenida " y "Av. " por "Avda. ", y "Calle " por "C/ "
    public String formatearDireccionEtiqueta() {
        if (this.direccion == null) return "";
        return this.direccion
                .replace("Avenida ", "Avda. ")
                .replace("Av. ", "Avda. ")
                .replace("Calle ", "C/ ");
    }

    // Getters y Setters
    public String getCodigo() { 
        return codigo; 
    }
    
    // trim() elimina espacios al inicio y al final; toUpperCase() convierte a mayúsculas
    public void setCodigo(String codigo) {
        this.codigo = (codigo != null) ? codigo.trim().toUpperCase() : "";
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

    public Camionero getCamionero() { return camionero; }
    public void setCamionero(Camionero camionero) { this.camionero = camionero; }
}