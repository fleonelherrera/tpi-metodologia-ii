import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SolicitudRepositoryMemoria implements SolicitudRepository {
   private final List<Solicitud> solicitudes = new ArrayList<>();

   public String siguienteId() {
      return "SOL-" + (solicitudes.size() + 1);
   }

   public void guardar(Solicitud solicitud) {
      solicitudes.add(solicitud);
   }

   public Optional<Solicitud> buscarPorId(String id) {
      return solicitudes.stream().filter(solicitud -> solicitud.getId().equals(id)).findFirst();
   }

   public List<Solicitud> obtenerTodas() {
      return new ArrayList<>(solicitudes);
   }
}
