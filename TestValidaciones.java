public class TestValidaciones {


    private static void probarLimpiarCI() {
        verificarIgualdad("limpiarCI('1.234.567-8')", limpiarCI("1.234.567-8"),  "12345678");
        verificarIgualdad("limpiarCI('12345678')", limpiarCI("12345678"), "12345678");
        verificarIgualdad("limpiarCI(' 1.234.567-8 ')", limpiarCI(" 1.234.567-8 "), "12345678");
        verificarIgualdad("limpiarCI(null)", limpiarCI(null), "");
        verificarIgualdad("limpiarCI('')", limpiarCI(""), "");
    }

    private static void probarMatriculaValida() {
        verificarCondicion("esMatriculaValida('SAB 1234')", esMatriculaValida("SAB 1234"),true);
        verificarCondicion("esMatriculaValida('SAB1234')", esMatriculaValida("SAB1234"), false);
        verificarCondicion("esMatriculaValida('AB 12')", esMatriculaValida("AB 12"), false);
        verificarCondicion("esMatriculaValida('ABC 12345')", esMatriculaValida("ABC 12345"), false);
        verificarCondicion("esMatriculaValida('AB 1234')", esMatriculaValida("AB 1234"), false);
        verificarCondicion("esMatriculaValida('   ')", esMatriculaValida("   "), false);
        verificarCondicion("esMatriculaValida(null)", esMatriculaValida(null), false);
    }

    private static void verificarIgualdad(String nombre, String actual, String esperado) {
    if (actual == null ? esperado == null : actual.equals(esperado)) {
        System.out.println("OK: " + nombre + " -> " + actual);
    } else {
        throw new AssertionError("FALLO: " + nombre + ". Esperado: '" + esperado + "' | Actual: '" + actual + "'");
    }
}

    private static void verificarCondicion(String nombre, boolean actual, boolean esperado) {
        if (actual == esperado) {
            System.out.println("OK: " + nombre + " -> " + actual);
        } else {
            System.out.println("FALLO: " + nombre + ". Esperado: " + esperado + " | Actual: " + actual);
        }
    }

    public static String limpiarCI(String ci) {
        if (ci == null) {
            return "";
        }

        String limpia = ci.trim();
        return limpia.replaceAll("[.\\-\\s]", "");
    }

    public static boolean esMatriculaValida(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            return false;
        }
        return matricula.matches("^[A-Z]{3}\\s\\d{4}$");
    }
}