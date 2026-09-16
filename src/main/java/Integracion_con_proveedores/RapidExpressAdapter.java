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
}