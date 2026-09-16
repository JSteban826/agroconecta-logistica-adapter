package Integracion_con_proveedores;

import java.util.Objects;

public class RapidExpressAdapter implements ServicioEnvio {

    private final RapidExpressAPI rapidExpressAPI;

    public RapidExpressAdapter(
            RapidExpressAPI rapidExpressAPI) {

        this.rapidExpressAPI =
                Objects.requireNonNull(
                        rapidExpressAPI,
                        "La API de RapidExpress es obligatoria"
                );
    }

    @Override
    public double calcularCosto(
            String origen,
            String destino,
            double peso) {

        String ruta = origen + "-" + destino;
        int pesoEnGramos = (int) (peso * 1000);

        return rapidExpressAPI.getShippingPrice(
                ruta,
                pesoEnGramos
        );
    }

    private void validarDatos(
            String origen,
            String destino,
            double peso) {

        if (origen == null || origen.isBlank()) {
            throw new IllegalArgumentException(
                    "El origen es obligatorio"
            );
        }

        if (destino == null || destino.isBlank()) {
            throw new IllegalArgumentException(
                    "El destino es obligatorio"
            );
        }

        if (peso <= 0) {
            throw new IllegalArgumentException(
                    "El peso debe ser mayor que cero"
            );
        }
    }
}