public class MainInicial {
   public static void main(String[] args) {
      SistemaSolicitudesInicial sistema = new SistemaSolicitudesInicial();

      String id = sistema.registrarSolicitud(
            "Ana Perez", "ana@utn.edu.ar", "CERTIFICADO", "ALTA",
            "Necesito un certificado de alumno regular", "Bedelia");

      sistema.cambiarEstado(id, "EN_REVISION");
      sistema.asignarResponsable(id, "Secretaria Academica");
      sistema.generarReporte();
   }
}
