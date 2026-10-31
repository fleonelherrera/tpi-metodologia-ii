import java.util.List;
import java.util.Optional;

public interface SolicitudRepository {
   String siguienteId();
   void guardar(Solicitud solicitud);
   Optional<Solicitud> buscarPorId(String id);
   List<Solicitud> obtenerTodas();
}
