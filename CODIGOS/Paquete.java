//===================================================================
//Clase Abstracta Paquete - Implementa la interfaz Rastreable
//===================================================================
public abstract class Paquete implements Rastreable {
    
    
    private String codigo;
    private String descripcion;
    private String destinatario;
    private String direccion;
    private Departamento departamento;
    private Camionero camionero;

//El constructor básico permite crear el paquete sin camionero para asignarlo más adelante.
public Paquete(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento) {
    this(codigo, descripcion, destinatario, direccion, departamento, null);
}


//EL constructor completo permite crear el paquete ya asignado a un camionero.
public Paquete(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento, Camionero camionero) {
    setCodigo(codigo); //Usamos setCodigo para que aplique la limpieza de espacios y mayúsculas
    this.descripcion = descripcion;
    this.destinatario = destinatario;
    this.direccion = direccion;
    this.departamento = departamento;
    this.camionero = camionero;
}


//Método abstracto: cada tipo de paquete tiene su propia fórmula de costo
public abstract double calcularCostoEnvio();



//Convierte el costo en pesos a dólares dividiendo por el tipo de cambio
public double calcularCostoEnDolares(double tipoCambio) {
    if (tipoCambio <= 0) {
        return 0.0; //Validación simple para evitar que se divida por cero
    }
        return this.calcularCostoEnvio() / tipoCambio;
}

//Método para abreviar la dirección en la etiqueta de envío
//Reemplaza "Avenida " y "Av. " por "Avda. ", y "Calle " por "C/ "
public String formatearDireccionEtiqueta() {
    if (this.direccion == null) return "";
    return this.direccion
            .replace("Avenida ", "Avda. ")
            .replace("Av. ", "Avda. ")
            .replace("Calle ", "C/ ");
}

//Getters y Setters
public String getCodigo() {
    return codigo;
}
    
//trim() elimina espacios al inicio y al final; toUpperCase() convierte a mayúsculas
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