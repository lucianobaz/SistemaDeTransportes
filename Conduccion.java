import java.time.LocalDate;

// ===================================================================
// [TIPO ASOCIATIVO / CLASE ASOCIATIVA] Conduccion
// Modela la relación N:M entre Camionero y Camión registrando la fecha.
// ===================================================================
public class Conduccion {
    private LocalDate fecha;
    private Camionero camionero;
    private Camion camion;

    public Conduccion(LocalDate fecha, Camionero camionero, Camion camion) {
        this.fecha = fecha;
        this.camionero = camionero;
        this.camion = camion;
    }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Camionero getCamionero() { return camionero; }
    public void setCamionero(Camionero camionero) { this.camionero = camionero; }

    public Camion getCamion() { return camion; }
    public void setCamion(Camion camion) { this.camion = camion; }
}