package Integracion_con_proveedores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RapidExpressAPITest {

    @Test
    void debeCalcularPrecioUtilizandoGramos() {
        RapidExpressAPI api = new RapidExpressAPI();

        double resultado =
                api.getShippingPrice(
                        "Fusagasuga-Bogota",
                        2000
                );

        assertEquals(5.0, resultado, 0.001);
    }
}