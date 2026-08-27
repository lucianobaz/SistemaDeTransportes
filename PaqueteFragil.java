public class PaqueteFragil extends Paquete {
    private String nivelCuidado;
    private double costoSeguro;

    public PaqueteFragil(String codigo, String descripcion, String destinatario, 
                         String direccion, Departamento departamento, 
                         String nivelCuidado, double costoSeguro) {
        super(codigo, descripcion, destinatario, direccion, departamento);
        this.nivelCuidado = nivelCuidado;
        this.costoSeguro = costoSeguro;
    }

    @Override
    public double calcularCostoEnvio() {
        double recargoCuidado = (nivelCuidado != null && nivelCuidado.equalsIgnoreCase("Alto")) ? 500.0 : 250.0;
        double subtotal = 300.0 + this.costoSeguro + recargoCuidado;
        return subtotal * 1.22;
    }

    @Override
    public String consultarEstado() {
        return "Paquete Frágil (" + nivelCuidado + " riesgo) en zona de empaque especial.";
    }

    @Override
    public String generarCodigoRastreo() {
        return "FRG-" + getCodigo();
    }

    public String getNivelCuidado() { return nivelCuidado; }
    public void setNivelCuidado(String nivelCuidado) { this.nivelCuidado = nivelCuidado; }

    public double getCostoSeguro() { return costoSeguro; }
    public void setCostoSeguro(double costoSeguro) { this.costoSeguro = costoSeguro; }
}