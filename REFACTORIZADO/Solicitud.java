public class Solicitud {
   private final String id;
   private final String estudiante;
   private final String email;
   private final TipoSolicitud tipo;
   private final PrioridadSolicitud prioridad;
   private final String detalle;
   private EstadoSolicitud estado;
   private String responsable;

   public Solicitud(String id, RegistrarSolicitudRequest request) {
      this.id = id;
      this.estudiante = request.getEstudiante();
      this.email = request.getEmail();
      this.tipo = request.getTipo();
      this.prioridad = request.getPrioridad();
      this.detalle = request.getDetalle();
      this.responsable = request.getResponsable();
      this.estado = EstadoSolicitud.NUEVA;
   }

   public void cambiarEstado(EstadoSolicitud nuevoEstado) {
      this.estado = nuevoEstado;
   }

   public void asignarResponsable(String nuevoResponsable) {
      this.responsable = nuevoResponsable;
   }

   public String getId() { return id; }
   public String getEstudiante() { return estudiante; }
   public TipoSolicitud getTipo() { return tipo; }
   public PrioridadSolicitud getPrioridad() { return prioridad; }
   public EstadoSolicitud getEstado() { return estado; }
   public String getResponsable() { return responsable; }

   public String describir() {
      return id + " | " + estudiante + " | " + tipo + " | " + prioridad + " | " + estado + " | " + responsable;
   }
}
