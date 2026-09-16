package Integracion_con_proveedores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogisticaServiceTest {

    @Test
    void debeDelegarLaCotizacionAlServicioDeEnvio() {
        ServicioEnvio proveedorLocal =
                (origen, destino, peso) -> peso * 3000;

        LogisticaService logisticaService =
                new LogisticaService(proveedorLocal);

        double resultado =
                logisticaService.cotizar(
                        "Fusagasuga",
                        "Bogota",
                        2.0
                );

        assertEquals(6000.0, resultado, 0.001);
    }

    @Test
    void debeCotizarConRapidExpressSinModificarLaLogicaPrincipal() {
        ServicioEnvio rapidExpress =
                new RapidExpressAdapter(
                        new RapidExpressAPI()
                );

        LogisticaService logisticaService =
                new LogisticaService(rapidExpress);

        double resultado =
                logisticaService.cotizar(
                        "Fusagasuga",
                        "Bogota",
                        2.0
                );

        assertEquals(5.0, resultado, 0.001);
    }
}