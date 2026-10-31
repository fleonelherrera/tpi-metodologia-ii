# Diagnóstico técnico de la versión inicial

## Calidad externa

El sistema permite registrar una solicitud, cambiar su estado, asignar un responsable, buscar por prioridad y generar un reporte básico. Desde la mirada del usuario, las operaciones principales funcionan.

## Calidad interna

La estructura inicial presenta problemas de mantenibilidad. La clase `SistemaSolicitudesInicial` concentra validación, operaciones de negocio, búsqueda, reporte y salida por consola. Esto aumenta el costo y el riesgo de hacer cambios futuros.

## Code smells detectados

1. **God Class** en `SistemaSolicitudesInicial`: concentra demasiadas responsabilidades.
2. **Long Method** en `registrarSolicitud`: valida, crea, guarda e imprime en un mismo método.
3. **Long Method** en `generarReporte`: recorre solicitudes, cuenta datos, arma el reporte e imprime.
4. **Duplicated Code**: la búsqueda por identificador se repite en `cambiarEstado` y `asignarResponsable`.
5. **Primitive Obsession**: tipo, prioridad y estado se representan mediante `String`.
6. **Long Parameter List**: `registrarSolicitud` recibe seis parámetros relacionados.
7. **Magic Number**: la longitud mínima del detalle usa el valor `10` directamente.
8. **Falta de encapsulamiento**: los atributos de `SolicitudInicial` son públicos.
9. **Mezcla de lógica y presentación**: se utiliza `System.out.println` dentro de los métodos de negocio.

## Prioridades de mejora

Primero se separarán las responsabilidades de validación, servicio, reporte y almacenamiento. Luego se reemplazarán los strings de dominio por enums, se agruparán los parámetros del registro y se encapsulará la entidad Solicitud.
