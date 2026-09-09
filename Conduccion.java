import java.time.LocalDate;

// ===================================================================
// Clase Asociativa Conduccion
// Representa la relación muchos a muchos (N:M) entre Camionero y Camión,
// registrando la fecha en la que se realizó la conducción.
// ===================================================================
public class Conduccion {
    private Camionero camionero;
    private Camion camion;
    private LocalDate fecha; // Fecha del evento de conducción

    public Conduccion(Camionero camionero, Camion camion, LocalDate fecha) {
        this.camionero = camionero;
        this.camion = camion;
        this.fecha = fecha;
    }

    public Camionero getCamionero() {
        return camionero;
    }

    public Camion getCamion() {
        return camion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
