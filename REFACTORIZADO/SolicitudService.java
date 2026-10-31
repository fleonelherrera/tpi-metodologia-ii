import java.util.List;
import java.util.stream.Collectors;

public class SolicitudService {
   private final SolicitudRepository repository;
   private final SolicitudValidator validator;

   public SolicitudService(SolicitudRepository repository, SolicitudValidator validator) {
      this.repository = repository;
      this.validator = validator;
   }

   public String registrar(RegistrarSolicitudRequest request) {
      validator.validarRegistro(request);
      Solicitud solicitud = new Solicitud(repository.siguienteId(), request);
      repository.guardar(solicitud);
      return solicitud.getId();
   }

   public void cambiarEstado(String id, EstadoSolicitud nuevoEstado) {
      buscarObligatoria(id).cambiarEstado(nuevoEstado);
   }

   public void asignarResponsable(String id, String responsable) {
      validator.validarResponsable(responsable);
      buscarObligatoria(id).asignarResponsable(responsable);
   }

   public List<Solicitud> buscarPorPrioridad(PrioridadSolicitud prioridad) {
      return repository.obtenerTodas().stream()
            .filter(solicitud -> solicitud.getPrioridad() == prioridad)
            .collect(Collectors.toList());
   }

   public List<Solicitud> obtenerTodas() {
      return repository.obtenerTodas();
   }

   private Solicitud buscarObligatoria(String id) {
      return repository.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada: " + id));
   }
}
