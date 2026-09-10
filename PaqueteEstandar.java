//===================================================================
//Subclase PaqueteEstandar (Hereda de Paquete)
//===================================================================
public class PaqueteEstandar extends Paquete {
    //Atributos específicos del paquete estándar
    private double peso;
    private double costoBase;

//El constructor básico nospermite crear el paquete sin camionero para asignarlo más adelante.
public PaqueteEstandar(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento, double peso, double costoBase) {
    super(codigo, descripcion, destinatario, direccion, departamento); //Reutiliza constructor del padre
    this.peso = peso;
    this.costoBase = costoBase;
}

//El constructor completo nos permite crear el paquete ya asignado a un camionero.
public PaqueteEstandar(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento, Camionero camionero, double peso, double costoBase) {
    super(codigo, descripcion, destinatario, direccion, departamento, camionero);
    this.peso = peso;
    this.costoBase = costoBase;
}

//Sobrescritura de calcularCostoEnvio (Polimorfismo):
//Subtotal = Costo Base + (Peso en Kg * $50)
//Costo Total = Subtotal * 1.22 (22% de IVA incluido)
@Override
public double calcularCostoEnvio() {
    double subtotal = this.costoBase + (this.peso * 50.0);
    return subtotal * 1.22;
}

//Implementación de la interfaz Rastreable para paquete estándar
@Override
public String consultarEstado() {
    return "Paquete Estándar listo para despacho.";
}

//Genera código único con prefijo "EST-"
@Override
public String generarCodigoRastreo() {
    return "EST-" + getCodigo();
}

//Getters y Setters
public double getPeso() { return peso; }
public void setPeso(double peso) { this.peso = peso; }

public double getCostoBase() { return costoBase; }
public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
}