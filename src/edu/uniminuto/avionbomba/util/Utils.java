/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniminuto.avionbomba.util;

/**
 *
 * @author Yoiner Montoya
 */
public class Utils {

    /**
     * Calcula la distancia horizontal recorrida por un objeto con la siguente
     * formula d=Vt
     *
     * @param velocidadX Velocidad por segundo
     * @param tiempo Tiempo en segundos
     * @return Distancia horizontal recorrida dada a la velocidad en N segundos
     */
    public static double getDistanciaX(double velocidadX, double tiempo) {
        return velocidadX * tiempo;
    }

    /**
     * Calcula la distancia vertical recorrida por un objeto con la siguente
     * formula Yf=Yi+(Vyi*t)+((1/2)*g*t^2)
     *
     * @param posicionY Pocision incial en metros
     * @param velocidadY Velocidad por segundo
     * @param tiempo Tiempo en segundos
     * @return Distancia vertical recorrida dada la velocidad en N segundos
     */
    public static double getDistanciaY(double posicionY, double velocidadY, double tiempo) {
        return posicionY + (velocidadY * tiempo) + ((1.0 / 2.0) * Constantes.Gravedad.GRAVEDAD_TIERRA * Math.pow(tiempo, 2));
    }

    /**
     * Convierte los kilómetros a metros.
     *
     * @param km Kilómetros
     * @return Cantidad de metros
     */
    public static double convertKmToM(double km) {
        return km * 1000.0;
    }

    /**
     * Convierte los kilómetros por hora a kilómetros por segundo.
     *
     * @param kmph Kilómetros por hora
     * @return Kilómetros por segundo
     */
    public static double convertKmphToKmps(double kmph) {
        return kmph / 3600.0;
    }

    /**
     * Convierte los kilómetros por segundo a kilómetros por hora.
     *
     * @param kmps Kilómetros por segundo
     * @return Kilómetros por hora
     */
    public static double convertKmpsToKmph(double kmps) {
        return kmps * 3600.0;
    }

    /**
     * Calcula la siguiente posición de un tiro parabolico
     *
     * @param posicionX Posicion inical en X (horizontal)
     * @param velocidadX Velocidad en X (horizontal) en kilómetros por hora
     * @param posicionY Posicion inical en Y (vertical)
     * @param velocidadY Velocidad en Y (vertical) en kilómetros por hora
     * @param tiempo Tiempo en segundos
     * @return Arreglo con dos posiciones indicando las nuevas posicione en X y
     * Y respectivamente
     */
    public static double[] nextPosition(double posicionX, double velocidadX, double posicionY, double velocidadY, double tiempo) {
        double[] result = new double[2];

        double vxs = convertKmphToKmps(velocidadX);
        double dxs = getDistanciaX(vxs, tiempo);
        result[0] = posicionX + dxs;

        double pym = convertKmToM(posicionY);
        result[1] = getDistanciaY(pym, velocidadY, tiempo) / 1000.0;

        return result;
    }

    /**
     * Convierte una cantidad N de píxeles a kilómetros según el tamaño del
     * contenedor y la división de kilómetros
     *
     * @param px Píxel actual
     * @param width Tamaño en píxeles del contenedor
     * @param kms Cantidad de kilómetros que contiene el contendor
     * @return El kilómetro correspondiente al píxel
     */
    public static double convertPxToKm(int px, int width, double kms) {
        return px / (width / kms);
    }

    /**
     * Convierte una cantidad N kilómetros a píxeles según el tamaño del
     * contenedor y la división de kilómetros
     *
     * @param km Kilómetro actual
     * @param width Tamaño en píxeles del contenedor
     * @param kms Cantidad de kilómetros que contiene el contendor
     * @return El kilómetro correspondiente al píxel
     */
    public static int convertKmToPx(double km, int width, double kms) {
        return new Double(km * (width / kms)).intValue();
    }
}
