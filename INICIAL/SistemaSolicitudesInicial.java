import java.util.ArrayList;
import java.util.List;

public class SistemaSolicitudesInicial {
   private final List<SolicitudInicial> solicitudes = new ArrayList<>();

   public String registrarSolicitud(String estudiante, String email, String tipo,
                                    String prioridad, String detalle, String responsable) {
      if (estudiante == null || estudiante.trim().isEmpty()) {
         return "ERROR: el estudiante es obligatorio";
      }
      if (email == null || !email.contains("@")) {
         return "ERROR: el email no es valido";
      }
      if (!tipo.equals("CERTIFICADO") && !tipo.equals("EQUIVALENCIA") && !tipo.equals("RECLAMO")) {
         return "ERROR: tipo invalido";
      }
      if (!prioridad.equals("BAJA") && !prioridad.equals("MEDIA") && !prioridad.equals("ALTA")) {
         return "ERROR: prioridad invalida";
      }
      if (detalle == null || detalle.trim().length() < 10) {
         return "ERROR: el detalle debe tener al menos 10 caracteres";
      }
      if (responsable == null || responsable.trim().isEmpty()) {
         return "ERROR: el responsable es obligatorio";
      }

      String id = "SOL-" + (solicitudes.size() + 1);
      SolicitudInicial solicitud = new SolicitudInicial(
            id, estudiante, email, tipo, prioridad, detalle, responsable);
      solicitudes.add(solicitud);
      System.out.println("Solicitud registrada: " + id);
      return id;
   }

   public String cambiarEstado(String id, String nuevoEstado) {
      for (SolicitudInicial solicitud : solicitudes) {
         if (solicitud.id.equals(id)) {
            if (!nuevoEstado.equals("NUEVA") && !nuevoEstado.equals("EN_REVISION")
                  && !nuevoEstado.equals("RESUELTA")) {
               return "ERROR: estado invalido";
            }
            solicitud.estado = nuevoEstado;
            return "OK";
         }
      }
      return "ERROR: solicitud no encontrada";
   }

   public String asignarResponsable(String id, String responsable) {
      for (SolicitudInicial solicitud : solicitudes) {
         if (solicitud.id.equals(id)) {
            if (responsable == null || responsable.trim().isEmpty()) {
               return "ERROR: responsable invalido";
            }
            solicitud.responsable = responsable;
            return "OK";
         }
      }
      return "ERROR: solicitud no encontrada";
   }

   public List<SolicitudInicial> buscarPorPrioridad(String prioridad) {
      List<SolicitudInicial> resultado = new ArrayList<>();
      for (SolicitudInicial solicitud : solicitudes) {
         if (solicitud.prioridad.equals(prioridad)) {
            resultado.add(solicitud);
         }
      }
      return resultado;
   }

   public String generarReporte() {
      int nuevas = 0;
      int enRevision = 0;
      int resueltas = 0;
      int altas = 0;
      String reporte = "REPORTE DE SOLICITUDES\n";

      for (SolicitudInicial solicitud : solicitudes) {
         reporte = reporte + solicitud.id + " | " + solicitud.estudiante + " | " + solicitud.tipo
               + " | " + solicitud.prioridad + " | " + solicitud.estado + " | "
               + solicitud.responsable + "\n";
         if (solicitud.estado.equals("NUEVA")) nuevas++;
         if (solicitud.estado.equals("EN_REVISION")) enRevision++;
         if (solicitud.estado.equals("RESUELTA")) resueltas++;
         if (solicitud.prioridad.equals("ALTA")) altas++;
      }

      reporte = reporte + "Nuevas: " + nuevas + "\n";
      reporte = reporte + "En revision: " + enRevision + "\n";
      reporte = reporte + "Resueltas: " + resueltas + "\n";
      reporte = reporte + "Prioridad alta: " + altas + "\n";
      System.out.println(reporte);
      return reporte;
   }
}
