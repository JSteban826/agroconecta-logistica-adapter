# AgroConecta - Integración de proveedores logísticos

## Descripción

Proyecto académico para analizar y refactorizar la integración de proveedores logísticos con interfaces incompatibles.

## Requisitos

- JDK 17 o superior
- Maven 3.9 o superior
- IntelliJ IDEA, Eclipse o VS Code
- JUnit 5

## Problema identificado

La versión ajustada de LogisticaService conoce directamente las API externas, selecciona proveedores mediante condicionales y realiza conversiones de datos.

## Solución

Se aplicó el patrón estructural Adapter. Cada API incompatible es envuelta por una clase que implementa la interfaz ServicioEnvio.

## Participantes

- Target: ServicioEnvio
- Client: LogisticaService
- Adapter: RapidExpressAdapter
- Adaptee: RapidExpressAPI

## Ejecutar pruebas

```bash
mvn test