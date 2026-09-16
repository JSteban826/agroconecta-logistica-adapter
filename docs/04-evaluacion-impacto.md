| Indicador                                                 | Antes                                                         | Después                                   |
|-----------------------------------------------------------|---------------------------------------------------------------|------------------------------------------- -|
| Dependencias externas conocidas por el servicio principal | RapidExpressAPI y proveedor local                             | Solo ServicioEnvio                          |
| Condiciones para seleccionar proveedores                  | Una por cada proveedor                                        | Ninguna en LogisticaService                 |
| Complejidad ciclomática del método de cotización          | Aumenta con cada if                                           | Permanece constante                         |
| Clases existentes modificadas al agregar proveedor        | Al menos LogisticaService ajustado                            | Ninguna                                     |
| Clases nuevas por proveedor                               | Puede no crear clases, pero modifica lógica central           | Un adaptador por API incompatible           |
| Conversión de unidades                                    | Mezclada con el servicio                                      | Encapsulada en el adaptador                 |
| Testabilidad                                              | Requiere preparar varias dependencias en una clase            | Cada adaptador se prueba por separado       |
| Cumplimiento de OCP                                       | Bajo                                                          | Alto                                        |
| Acoplamiento                                              | Alto                                                          | Bajo                                        |
| Modularidad                                               | Baja o media                                                  | Alta                                        |

La refactorización introduce el costo de crear una clase adaptadora por cada API incompatible. Sin embargo, dicho costo es controlado y permite localizar los cambios.

Antes, la integración de un nuevo operador obligaba a modificar LogisticaServiceAjustado y aumentar sus condicionales. Después, un proveedor puede incorporarse creando una nueva implementación de ServicioEnvio, sin modificar la lógica principal.

La complejidad no desaparece, sino que se traslada desde una clase central hacia componentes especializados y probables de manera independiente.