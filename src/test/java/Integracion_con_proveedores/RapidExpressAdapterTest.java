package Integracion_con_proveedores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertThrows;

class RapidExpressAdapterTest {

    @Test
    void debeAdaptarKilogramosAGramos() {
        RapidExpressAdapter adapter =
                new RapidExpressAdapter(
                        new RapidExpressAPI()
                );

        double resultado =
                adapter.calcularCosto(
                        "Fusagasuga",
                        "Bogota",
                        2.0
                );

        assertEquals(5.0, resultado, 0.001);
    }

    @Test
    void debeFuncionarMedianteLaInterfazComun() {
        ServicioEnvio servicioEnvio =
                new RapidExpressAdapter(
                        new RapidExpressAPI()
                );

        double resultado =
                servicioEnvio.calcularCosto(
                        "Fusagasuga",
                        "Bogota",
                        1.5
                );

        assertEquals(3.75, resultado, 0.001);
    }

    @Test
    void debeRechazarPesoNegativo() {
        ServicioEnvio adapter =
                new RapidExpressAdapter(
                        new RapidExpressAPI()
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> adapter.calcularCosto(
                        "Fusagasuga",
                        "Bogota",
                        -2.0
                )
        );
    }

    @Test
    void debeRechazarOrigenVacio() {
        ServicioEnvio adapter =
                new RapidExpressAdapter(
                        new RapidExpressAPI()
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> adapter.calcularCosto(
                        "",
                        "Bogota",
                        2.0
                )
        );
    }
}
