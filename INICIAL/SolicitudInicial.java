public class SolicitudInicial {
   public String id;
   public String estudiante;
   public String email;
   public String tipo;
   public String prioridad;
   public String detalle;
   public String estado;
   public String responsable;

   public SolicitudInicial(String id, String estudiante, String email, String tipo,
                           String prioridad, String detalle, String responsable) {
      this.id = id;
      this.estudiante = estudiante;
      this.email = email;
      this.tipo = tipo;
      this.prioridad = prioridad;
      this.detalle = detalle;
      this.responsable = responsable;
      this.estado = "NUEVA";
   }
}
