import java.time.LocalDate;

public class Conduccion {
    private Camionero camionero;
    private Camion camion;
    private LocalDate fecha;

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
