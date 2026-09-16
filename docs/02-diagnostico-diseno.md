# Diagnóstico del diseño

## 1. Conditional Complexity

### Ubicación
Método cotizar de LogisticaServiceAjustado.

### Evidencia
La selección del proveedor se realiza mediante comparaciones con los textos "LOCAL" y "RAPID".

### Consecuencia
Cada proveedor adicional requiere incorporar una nueva condición, aumentando la complejidad ciclomática y el riesgo de errores.

## 2. Tight Coupling

### Ubicación
Atributo RapidExpressAPI de LogisticaServiceAjustado.

### Evidencia
La clase principal conoce directamente la API externa y su método getShippingPrice.

### Consecuencia
Los cambios en la librería externa afectan la lógica principal de la aplicación.

## 3. Responsabilidades mezcladas

### Ubicación
Método cotizar de LogisticaServiceAjustado.

### Evidencia
El método selecciona el proveedor, construye la ruta, convierte kilogramos a gramos y realiza la cotización.

### Consecuencia
La clase tiene más de una razón para cambiar.

## 4. Primitive Obsession y selección mediante texto

### Ubicación
Parámetro proveedor del método cotizar.

### Evidencia
Los proveedores son identificados mediante cadenas como "LOCAL" y "RAPID".

### Consecuencia
Existe riesgo de errores tipográficos y falta de seguridad de tipos.

## 5. Violación de OCP

Para integrar un tercer proveedor es obligatorio modificar LogisticaServiceAjustado y agregar una nueva condición.

## 6. Riesgo de Shotgun Surgery

Si se integran varios proveedores, los detalles de selección, conversión y manejo de errores pueden extenderse por diferentes partes del servicio.

# Principios aplicables

## Responsabilidad única, SRP

LogisticaService debe coordinar la cotización, pero no debería transformar los formatos particulares de cada proveedor.

## Abierto/Cerrado, OCP

La incorporación de un proveedor debería realizarse agregando una nueva implementación, sin modificar LogisticaService.

## Inversión de dependencias, DIP

La lógica principal debe depender de ServicioEnvio, no directamente de RapidExpressAPI.

## Composición sobre herencia

La adaptación debe realizarse componiendo un adaptador con una instancia de RapidExpressAPI, debido a que la librería externa no se puede modificar.

## Dependencias no inicializadas

LogisticaServiceAjustado declara las dependencias proveedorLocal y rapidExpress, pero no proporciona constructor ni métodos de configuración. Por tanto, una instancia creada mediante new LogisticaServiceAjustado() contiene dependencias nulas y no puede realizar una cotización correctamente.