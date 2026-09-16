| Criterio                        | Condicionales   | Herencia | Facade                                | Adapter                  |
|---------------------------------|-----------------|----------|---------------------------------------|--------------------------|
| Acoplamiento                    | Alto            | Medio    | Medio                                 | Bajo                     |
| Extensibilidad                  | Baja            | Media    | Media                                 | Alta                     |
| Mantenibilidad                  | Baja            | Media    | Media                                 | Alta                     |
| Testabilidad                    | Baja            | Media    | Media                                 | Alta                     |
| Complejidad inicial             | Baja            | Media    | Media                                 | Media                    |
| Compatibilidad de interfaces    | No la resuelve  | Parcial  | Oculta, pero no necesariamente adapta | La resuelve directamente |
| Esfuerzo inicial                | Bajo            | Medio    | Medio                                 | Medio                    |
| Cumplimiento de OCP             | Bajo            | Parcial  | Parcial                               | Alto                     |

## Decisión

Se selecciona el patrón Adapter porque el problema central no consiste únicamente en simplificar un subsistema, sino en hacer compatible la interfaz interna ServicioEnvio con la interfaz externa RapidExpressAPI.

Facade no es la opción principal porque su propósito sería proporcionar una entrada simplificada a un subsistema. En este caso se requiere convertir operaciones y parámetros entre dos contratos incompatibles.

La herencia tampoco es apropiada porque RapidExpressAPI pertenece a una librería externa que no debe modificarse. La composición permite envolver dicha instancia y aislar sus particularidades.