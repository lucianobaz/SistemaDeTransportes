public class PaqueteEstandar extends Paquete {
    private double peso;
    private double costoBase;

    public PaqueteEstandar(String codigo, String descripcion, String destinatario, 
                           String direccion, Departamento departamento, 
                           double peso, double costoBase) {
        super(codigo, descripcion, destinatario, direccion, departamento);
        this.peso = peso;
        this.costoBase = costoBase;
    }

    @Override
    public double calcularCostoEnvio() {
        double subtotal = this.costoBase + (this.peso * 50.0);
        return subtotal * 1.22;
    }

    @Override
    public String consultarEstado() {
        return "Paquete Estándar listo para despacho.";
    }

    @Override
    public String generarCodigoRastreo() {
        return "EST-" + getCodigo();
    }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
}