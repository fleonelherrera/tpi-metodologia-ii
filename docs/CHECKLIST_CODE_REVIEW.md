# Checklist de Code Review

## Diseño y mantenibilidad

- [x] Cada clase de la versión refactorizada tiene una responsabilidad clara.
- [x] La búsqueda por identificador no está duplicada en los casos de uso.
- [x] El servicio depende de la interfaz `SolicitudRepository`.
- [x] Tipo, prioridad y estado se modelan con enums.

## Clean Code

- [x] Los nombres describen la intención de cada clase y método.
- [x] Las validaciones se separaron en `SolicitudValidator`.
- [x] La regla de longitud mínima se expresa mediante `DETALLE_MINIMO`.
- [x] Los atributos de `Solicitud` son privados.

## Comportamiento y pruebas

- [x] El registro de una solicitud válida funciona.
- [x] El cambio de estado funciona.
- [x] La asignación de responsable funciona.
- [x] La consulta por prioridad y el reporte producen resultados correctos.
- [x] Las entradas inválidas son rechazadas.

## Observaciones y correcciones aplicadas

Se observó que `SistemaSolicitudesInicial` concentraba validaciones, casos de uso, reporte y salida por consola. La versión refactorizada distribuye esas responsabilidades entre `Solicitud`, `SolicitudValidator`, `SolicitudService`, `SolicitudRepository` y `ReporteSolicitudes`.

También se reemplazaron strings del dominio por enums, se agrupó el registro mediante `RegistrarSolicitudRequest` y se encapsularon los atributos de la entidad.

## Criterios de aceptación

- Se conservan las operaciones visibles del sistema.
- Las validaciones rechazan datos inválidos.
- Las pruebas de la versión refactorizada finalizan correctamente.
- El diagnóstico y las mejoras quedan documentados en el repositorio.
