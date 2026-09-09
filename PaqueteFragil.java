// ===================================================================
// Subclase PaqueteFragil (Hereda de Paquete)
// ===================================================================
public class PaqueteFragil extends Paquete {
    // Atributos específicos del paquete frágil
    private String nivelCuidado; // "Bajo", "Medio" o "Alto"
    private double costoSeguro;  // Costo extra de seguro por manipulación

    // Constructor básico
    public PaqueteFragil(String codigo, String descripcion, String destinatario, 
                         String direccion, Departamento departamento, 
                         String nivelCuidado, double costoSeguro) {
        super(codigo, descripcion, destinatario, direccion, departamento); // Reutiliza constructor del padre
        this.nivelCuidado = nivelCuidado;
        this.costoSeguro = costoSeguro;
    }

    // Constructor completo con camionero
    public PaqueteFragil(String codigo, String descripcion, String destinatario, 
                         String direccion, Departamento departamento, Camionero camionero,
                         String nivelCuidado, double costoSeguro) {
        super(codigo, descripcion, destinatario, direccion, departamento, camionero);
        this.nivelCuidado = nivelCuidado;
        this.costoSeguro = costoSeguro;
    }

    // Sobrescritura de calcularCostoEnvio (Polimorfismo):
    // Recargo Cuidado = si nivel es "Alto" -> $500, de lo contrario -> $250
    // Subtotal = $300 (base frágil) + Costo Seguro + Recargo Cuidado
    // Costo Total = Subtotal * 1.22 (22% de IVA incluido)
    @Override
    public double calcularCostoEnvio() {
        double recargoCuidado = (nivelCuidado != null && nivelCuidado.equalsIgnoreCase("Alto")) ? 500.0 : 250.0;
        double subtotal = 300.0 + this.costoSeguro + recargoCuidado;
        return subtotal * 1.22;
    }

    // Implementación de la interfaz Rastreable para paquete frágil
    @Override
    public String consultarEstado() {
        return "Paquete Frágil (" + nivelCuidado + " riesgo) en zona de empaque especial.";
    }

    // Genera código único con prefijo "FRG-"
    @Override
    public String generarCodigoRastreo() {
        return "FRG-" + getCodigo();
    }

    // Getters y Setters
    public String getNivelCuidado() { return nivelCuidado; }
    public void setNivelCuidado(String nivelCuidado) { this.nivelCuidado = nivelCuidado; }

    public double getCostoSeguro() { return costoSeguro; }
    public void setCostoSeguro(double costoSeguro) { this.costoSeguro = costoSeguro; }
}