// ===================================================================
// [CLASE ABSTRACTA QUE IMPLEMENTA LA INTERFAZ]
// ===================================================================
public abstract class Paquete implements Rastreable {
    private String codigo;
    private String descripcion;
    private String destinatario;
    private String direccion;
    private Departamento departamento;

    public Paquete(String codigo, String descripcion, String destinatario, String direccion, Departamento departamento) {
        setCodigo(codigo);
        this.descripcion = descripcion;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.departamento = departamento;
    }

    public abstract double calcularCostoEnvio();

    public double calcularCostoEnDolares(double tipoCambio) {
        if (tipoCambio <= 0) {
            throw new IllegalArgumentException("El tipo de cambio debe ser mayor a 0");
        }
        return this.calcularCostoEnvio() / tipoCambio;
    }

    public String formatearDireccionEtiqueta() {
        if (this.direccion == null) return "";
        return this.direccion
                .replace("Avenida ", "Avda. ")
                .replace("Av. ", "Avda. ")
                .replace("Calle ", "C/");
    }

    public String getCodigo() { return codigo; }
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
}