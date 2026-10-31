import java.util.List;

public class ReporteSolicitudes {
   public String generar(List<Solicitud> solicitudes) {
      long nuevas = contarPorEstado(solicitudes, EstadoSolicitud.NUEVA);
      long enRevision = contarPorEstado(solicitudes, EstadoSolicitud.EN_REVISION);
      long resueltas = contarPorEstado(solicitudes, EstadoSolicitud.RESUELTA);
      long altas = solicitudes.stream()
            .filter(solicitud -> solicitud.getPrioridad() == PrioridadSolicitud.ALTA)
            .count();

      StringBuilder reporte = new StringBuilder("REPORTE DE SOLICITUDES\n");
      for (Solicitud solicitud : solicitudes) {
         reporte.append(solicitud.describir()).append("\n");
      }
      reporte.append("Nuevas: ").append(nuevas).append("\n");
      reporte.append("En revision: ").append(enRevision).append("\n");
      reporte.append("Resueltas: ").append(resueltas).append("\n");
      reporte.append("Prioridad alta: ").append(altas).append("\n");
      return reporte.toString();
   }

   private long contarPorEstado(List<Solicitud> solicitudes, EstadoSolicitud estado) {
      return solicitudes.stream().filter(solicitud -> solicitud.getEstado() == estado).count();
   }
}
