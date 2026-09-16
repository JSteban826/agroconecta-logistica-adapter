# Análisis inicial del sistema logístico de AgroConecta

## 1. Funcionamiento actual

El sistema permite calcular el costo de un envío según el proveedor logístico seleccionado. El diseño original utiliza la interfaz ServicioEnvio y la clase LogisticaService delega el cálculo en una implementación de dicha interfaz.

Después de integrar RapidExpress, se creó LogisticaServiceAjustado. Esta clase selecciona el proveedor mediante condicionales y transforma los datos requeridos por la API externa.

## 2. Clases involucradas

### ServicioEnvio
Define el contrato interno para calcular costos de envío utilizando origen, destino y peso.

### LogisticaService
Recibe una implementación de ServicioEnvio y delega la cotización sin conocer los detalles del proveedor.

### RapidExpressAPI
Representa una librería externa que recibe una ruta y el peso expresado en gramos.

### LogisticaServiceAjustado
Selecciona el proveedor, convierte los parámetros e invoca directamente la API correspondiente.

## 3. Dependencias principales

- LogisticaService depende de ServicioEnvio.
- LogisticaServiceAjustado depende de ServicioEnvio.
- LogisticaServiceAjustado depende directamente de RapidExpressAPI.
- RapidExpressAPI no implementa ServicioEnvio.

## 4. Problema principal

La versión ajustada mezcla la lógica de cotización con la selección de proveedores y la adaptación de formatos. Por esta razón, integrar nuevos operadores obliga a modificar la clase principal.