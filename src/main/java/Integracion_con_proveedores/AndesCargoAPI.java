package Integracion_con_proveedores;

public class AndesCargoAPI {

    public double consultarTarifa(
            String ciudadSalida,
            String ciudadLlegada,
            double pesoEnLibras) {

        return pesoEnLibras * 1.8;
    }
}