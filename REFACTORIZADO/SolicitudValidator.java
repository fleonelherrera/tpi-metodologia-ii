public class SolicitudValidator {
   private static final int DETALLE_MINIMO = 10;

   public void validarRegistro(RegistrarSolicitudRequest request) {
      validarTextoObligatorio(request.getEstudiante(), "El estudiante es obligatorio");
      validarEmail(request.getEmail());
      validarNoNulo(request.getTipo(), "El tipo es obligatorio");
      validarNoNulo(request.getPrioridad(), "La prioridad es obligatoria");
      validarDetalle(request.getDetalle());
      validarTextoObligatorio(request.getResponsable(), "El responsable es obligatorio");
   }

   public void validarResponsable(String responsable) {
      validarTextoObligatorio(responsable, "El responsable es obligatorio");
   }

   private void validarTextoObligatorio(String texto, String mensaje) {
      if (texto == null || texto.trim().isEmpty()) {
         throw new IllegalArgumentException(mensaje);
      }
   }

   private void validarEmail(String email) {
      if (email == null || !email.contains("@")) {
         throw new IllegalArgumentException("El email no es valido");
      }
   }

   private void validarDetalle(String detalle) {
      if (detalle == null || detalle.trim().length() < DETALLE_MINIMO) {
         throw new IllegalArgumentException("El detalle debe tener al menos " + DETALLE_MINIMO + " caracteres");
      }
   }

   private void validarNoNulo(Object valor, String mensaje) {
      if (valor == null) {
         throw new IllegalArgumentException(mensaje);
      }
   }
}
