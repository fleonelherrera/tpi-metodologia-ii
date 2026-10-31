# Pruebas y verificación del comportamiento

## Objetivo

Comprobar que el refactoring no alteró negativamente las operaciones visibles del sistema de solicitudes académicas.

## Casos verificados en la versión inicial

1. Registrar una solicitud válida.
2. Cambiar el estado de una solicitud a `EN_REVISION`.
3. Asignar un responsable.
4. Buscar una solicitud por prioridad `ALTA`.
5. Generar un reporte que informe una solicitud en revisión.

Resultado esperado: `PRUEBAS INICIALES SUPERADAS`.

## Casos verificados en la versión refactorizada

1. Registrar una solicitud válida con `RegistrarSolicitudRequest`.
2. Cambiar el estado usando `EstadoSolicitud`.
3. Asignar un responsable mediante `SolicitudService`.
4. Buscar una solicitud por `PrioridadSolicitud.ALTA`.
5. Generar un reporte que informe una solicitud en revisión.
6. Rechazar una solicitud inválida mediante las validaciones del sistema.

Resultado esperado: `PRUEBAS REFACTORIZADAS SUPERADAS`.

## Conclusión

Las pruebas conservan el mismo flujo funcional principal antes y después: registro, cambio de estado, asignación, consulta y reporte. La versión refactorizada agrega una validación explícita de datos inválidos sin cambiar el comportamiento esperado para una solicitud válida.
