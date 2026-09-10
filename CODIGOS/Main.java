
import java.time.LocalDate;
import java.util.*;

public class Main {

    //función que muestra la información de los paquetes (con sus asignaciones)
    private static void mostrarInfoPaquete(Paquete p, double tipoCambio, Camionero c) {
        System.out.println("Codigo: " + p.getCodigo());
        System.out.println("Direccion: " + p.formatearDireccionEtiqueta());
        System.out.println("Costo en pesos: " + p.calcularCostoEnvio());
        System.out.println("Costo en dolares: " + p.calcularCostoEnDolares(tipoCambio));
        System.out.println("Estado: " + p.consultarEstado());
        System.out.println("Camionero: " + c.getNombre());
        System.out.println("------------------------");
    }

    //función que asigna cada paquete a su camionero correspondiente
    private static void asignarPaquete(Paquete p, Camionero c, List<Paquete> lista, List<Camionero> listaCamioneros) {
        lista.add(p);
        listaCamioneros.add(c);
        c.getPaquetesAsignados().add(p.getCodigo());
    }

    public static void main(String[] args) {

        //convierte costo de envío a dólares
        double tipoCambio = 40.0;

        //lista polimórfica de paquetes
        List<Paquete> paquetes = new ArrayList<>();

        //lista paralela: misma posición que "paquetes"
        List<Camionero> camionerosDePaquetes = new ArrayList<>();

        //precargados: departamento, camiones, camioneros y tipos de paquetes

        //_____________________________________________________
        Departamento montevideo = new Departamento("01", "Montevideo");

        Camionero camionero1 = new Camionero("1.234.567-8", "Juan Perez", "099123456", "18 de Julio 1234", 35000.0, "Montevideo");

        Camion camion1 = new Camion("SAB 1234", "Mercedes Benz", "Camión", 250.0);

        Conduccion conduccion1 = new Conduccion(camionero1, camion1, LocalDate.of(2026, 3, 15));

        PaqueteEstandar paq1 = new PaqueteEstandar("COD001", "Ropa", "Ana Gomez", "Calle Rivera 456", montevideo, 3.5, 200.0);
        asignarPaquete(paq1, camionero1, paquetes, camionerosDePaquetes);

        PaqueteFragil paq2 = new PaqueteFragil("COD002", "Vajilla", "Luis Diaz", "Avenida Italia 789", montevideo, "Alto", 150.0);
        asignarPaquete(paq2, camionero1, paquetes, camionerosDePaquetes);
        //____________________________________________________
        Departamento canelones = new Departamento("02", "Canelones");

        Camionero camionero2 = new Camionero("2.458.654-9", "Taylor Swift", "099436643", "Agraciada 356", 38000.0, "Canelones");

        Camion camion2 = new Camion("STP 5678", "Volvo", "Camión", 210.0);

        Conduccion conduccion2 = new Conduccion(camionero2, camion2, LocalDate.of(2026, 3, 16));

        PaqueteEstandar paq3 = new PaqueteEstandar("COD003", "Electronica", "Marcos Silva", "Calle Colon 789", canelones, 2.0, 300.0);
        asignarPaquete(paq3, camionero2, paquetes, camionerosDePaquetes);

        PaqueteFragil paq4 = new PaqueteFragil("COD004", "Cuadro de arte", "Lucia Fernandez", "Av. Giannattasio 2200", canelones, "Medio", 200.0);
        asignarPaquete(paq4, camionero2, paquetes, camionerosDePaquetes);
        //______________________________________________________________
        
        //recorrido polimórfico, busca el camionero de cada paquete para mostrarlo
        for (int i = 0; i < paquetes.size(); i++) {
            Paquete p = paquetes.get(i);
            Camionero camioneroDelPaquete = camionerosDePaquetes.get(i);
            
            mostrarInfoPaquete(p, tipoCambio, camioneroDelPaquete);
        }
    }
}