// ===================================================================
// [INTERFAZ] Rastreable
// Define el contrato obligatorio para todos los paquetes del sistema.
// Obliga a implementar la consulta de estado y la generación del código único de rastreo.
// ===================================================================
public interface Rastreable {
    String consultarEstado();
    String generarCodigoRastreo();
}