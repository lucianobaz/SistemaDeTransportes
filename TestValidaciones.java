public class TestValidaciones {

    public static void main(String[] args) {
        System.out.println("=== EJECUTANDO PRUEBAS DE VALIDACIÓN Y FORMATEO (QA) ===\n");
        probarLimpiarCI();
        probarMatriculaValida();
        probarFormateoDireccion();
        System.out.println("\n¡Todas las pruebas finalizaron correctamente!");
    }

    private static void probarLimpiarCI() {
        System.out.println("--- Pruebas de Limpieza de Cédula (Camionero) ---");
        Camionero c = new Camionero("1.234.567-8", "Juan", "099111222", "Calle 1", 30000, "MVD");
        verificarIgualdad("limpiarCI('1.234.567-8')", c.getCi(), "12345678");

        c.setCi(" 1.234.567-8 ");
        verificarIgualdad("limpiarCI con espacios", c.getCi(), "12345678");

        c.setCi("12345678");
        verificarIgualdad("limpiarCI ya limpia", c.getCi(), "12345678");
    }

    private static void probarMatriculaValida() {
        System.out.println("\n--- Pruebas de Matrícula Válida (Camion) ---");
        Camion c1 = new Camion("SAB 1234", "Mercedes", "Pesado", 250);
        verificarCondicion("esMatriculaValida('SAB 1234')", c1.esMatriculaValida(), true);

        Camion c2 = new Camion("SAB1234", "Mercedes", "Pesado", 250);
        verificarCondicion("esMatriculaValida('SAB1234') sin espacio", c2.esMatriculaValida(), false);

        Camion c3 = new Camion("AB 12", "Mercedes", "Pesado", 250);
        verificarCondicion("esMatriculaValida('AB 12') menor a 7 caracteres", c3.esMatriculaValida(), false);
    }

    private static void probarFormateoDireccion() {
        System.out.println("\n--- Pruebas de Formateo de Dirección (Paquete) ---");
        Departamento depto = new Departamento("01", "Montevideo");
        Camionero chofer = new Camionero("12345678", "Chofer", "099", "Dir", 1000, "MVD");
        
        Paquete p1 = new PaqueteEstandar("P01", "Desc", "Dest", "Calle Rivera 1234", depto, chofer, 1.0, 100);
        verificarIgualdad("formatearDireccion con Calle", p1.formatearDireccionEtiqueta(), "C/ Rivera 1234");

        Paquete p2 = new PaqueteFragil("P02", "Desc", "Dest", "Avenida Italia 5678", depto, chofer, "Alto", 100);
        verificarIgualdad("formatearDireccion con Avenida", p2.formatearDireccionEtiqueta(), "Avda. Italia 5678");

        Paquete p3 = new PaqueteFragil("P03", "Desc", "Dest", "Av. Brasil 999", depto, chofer, "Bajo", 100);
        verificarIgualdad("formatearDireccion con Av.", p3.formatearDireccionEtiqueta(), "Avda. Brasil 999");
    }

    private static void verificarIgualdad(String nombrePrueba, String actual, String esperado) {
        if (actual != null && actual.equals(esperado)) {
            System.out.println("[OK] " + nombrePrueba + " -> '" + actual + "'");
        } else {
            System.out.println("[FALLO] " + nombrePrueba + ". Esperado: '" + esperado + "' | Actual: '" + actual + "'");
        }
    }

    private static void verificarCondicion(String nombrePrueba, boolean actual, boolean esperado) {
        if (actual == esperado) {
            System.out.println("[OK] " + nombrePrueba + " -> " + actual);
        } else {
            System.out.println("[FALLO] " + nombrePrueba + ". Esperado: " + esperado + " | Actual: " + actual);
        }
    }
}
