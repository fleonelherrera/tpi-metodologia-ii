public class PruebaSistemaInicial {
   public static void main(String[] args) {
      SistemaSolicitudesInicial sistema = new SistemaSolicitudesInicial();
      String id = sistema.registrarSolicitud(
            "Ana Perez", "ana@utn.edu.ar", "CERTIFICADO", "ALTA",
            "Necesito un certificado de alumno regular", "Bedelia");

      verificar("SOL-1".equals(id), "La solicitud debe registrarse con el identificador esperado");
      verificar("OK".equals(sistema.cambiarEstado(id, "EN_REVISION")), "El estado debe actualizarse");
      verificar("OK".equals(sistema.asignarResponsable(id, "Secretaria Academica")), "Debe asignarse responsable");
      verificar(sistema.buscarPorPrioridad("ALTA").size() == 1, "Debe encontrarse una solicitud alta");
      verificar(sistema.generarReporte().contains("En revision: 1"), "El reporte debe informar el estado");

      System.out.println("PRUEBAS INICIALES SUPERADAS");
   }

   private static void verificar(boolean condicion, String mensaje) {
      if (!condicion) {
         throw new IllegalStateException(mensaje);
      }
   }
}
