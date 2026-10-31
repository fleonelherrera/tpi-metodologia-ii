public class RegistrarSolicitudRequest {
   private final String estudiante;
   private final String email;
   private final TipoSolicitud tipo;
   private final PrioridadSolicitud prioridad;
   private final String detalle;
   private final String responsable;

   public RegistrarSolicitudRequest(String estudiante, String email, TipoSolicitud tipo,
                                    PrioridadSolicitud prioridad, String detalle, String responsable) {
      this.estudiante = estudiante;
      this.email = email;
      this.tipo = tipo;
      this.prioridad = prioridad;
      this.detalle = detalle;
      this.responsable = responsable;
   }

   public String getEstudiante() { return estudiante; }
   public String getEmail() { return email; }
   public TipoSolicitud getTipo() { return tipo; }
   public PrioridadSolicitud getPrioridad() { return prioridad; }
   public String getDetalle() { return detalle; }
   public String getResponsable() { return responsable; }
}
