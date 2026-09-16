package Integracion_con_proveedores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LogisticaServiceAjustadoTest {

    @Test
    void evidenciaDependenciasNoInicializadas() {
        LogisticaServiceAjustado servicio =
                new LogisticaServiceAjustado();

        assertThrows(
                NullPointerException.class,
                () -> servicio.cotizar(
                        "RAPID",
                        "Fusagasuga",
                        "Bogota",
                        2.0
                )
        );
    }

    @Test
    void debeRechazarUnProveedorDesconocido() {
        LogisticaServiceAjustado servicio =
                new LogisticaServiceAjustado();

        assertThrows(
                IllegalArgumentException.class,
                () -> servicio.cotizar(
                        "DESCONOCIDO",
                        "Fusagasuga",
                        "Bogota",
                        2.0
                )
        );
    }
}