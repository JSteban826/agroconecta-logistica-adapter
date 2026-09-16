package Integracion_con_proveedores;

public class AndesCargoAdapter
        implements ServicioEnvio {

    private final AndesCargoAPI andesCargoAPI;

    public AndesCargoAdapter(
            AndesCargoAPI andesCargoAPI) {
        this.andesCargoAPI = andesCargoAPI;
    }

    @Override
    public double calcularCosto(
            String origen,
            String destino,
            double peso) {

        double pesoEnLibras = peso * 2.20462;

        return andesCargoAPI.consultarTarifa(
                origen,
                destino,
                pesoEnLibras
        );
    }
}