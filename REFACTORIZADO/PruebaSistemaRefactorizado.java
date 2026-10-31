public class PruebaSistemaRefactorizado {
   public static void main(String[] args) {
      SolicitudService solicitudes = new SolicitudService(
            new SolicitudRepositoryMemoria(), new SolicitudValidator());
      ReporteSolicitudes reporte = new ReporteSolicitudes();

      RegistrarSolicitudRequest request = new RegistrarSolicitudRequest(
            "Ana Perez", "ana@utn.edu.ar", TipoSolicitud.CERTIFICADO,
            PrioridadSolicitud.ALTA, "Necesito un certificado de alumno regular", "Bedelia");

      String id = solicitudes.registrar(request);
      solicitudes.cambiarEstado(id, EstadoSolicitud.EN_REVISION);
      solicitudes.asignarResponsable(id, "Secretaria Academica");

      verificar("SOL-1".equals(id), "La solicitud debe registrarse con el identificador esperado");
      verificar(solicitudes.buscarPorPrioridad(PrioridadSolicitud.ALTA).size() == 1,
            "Debe encontrarse una solicitud alta");
      verificar(reporte.generar(solicitudes.obtenerTodas()).contains("En revision: 1"),
            "El reporte debe informar el estado");
      verificarFalloDeValidacion(solicitudes);

      System.out.println("PRUEBAS REFACTORIZADAS SUPERADAS");
   }

   private static void verificarFalloDeValidacion(SolicitudService solicitudes) {
      try {
         solicitudes.registrar(new RegistrarSolicitudRequest(
               "", "sin-arroba", TipoSolicitud.RECLAMO, PrioridadSolicitud.BAJA,
               "Corto", ""));
         throw new IllegalStateException("La validacion debio rechazar la solicitud invalida");
      } catch (IllegalArgumentException errorEsperado) {
         verificar(errorEsperado.getMessage().equals("El estudiante es obligatorio"),
               "Debe informar el primer error de validacion");
      }
   }

   private static void verificar(boolean condicion, String mensaje) {
      if (!condicion) {
         throw new IllegalStateException(mensaje);
      }
   }
}
