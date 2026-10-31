public class MainRefactorizado {
   public static void main(String[] args) {
      SolicitudRepository repository = new SolicitudRepositoryMemoria();
      SolicitudService solicitudes = new SolicitudService(repository, new SolicitudValidator());
      ReporteSolicitudes reporte = new ReporteSolicitudes();

      RegistrarSolicitudRequest request = new RegistrarSolicitudRequest(
            "Ana Perez", "ana@utn.edu.ar", TipoSolicitud.CERTIFICADO,
            PrioridadSolicitud.ALTA, "Necesito un certificado de alumno regular", "Bedelia");

      String id = solicitudes.registrar(request);
      solicitudes.cambiarEstado(id, EstadoSolicitud.EN_REVISION);
      solicitudes.asignarResponsable(id, "Secretaria Academica");

      System.out.println(reporte.generar(solicitudes.obtenerTodas()));
   }
}
