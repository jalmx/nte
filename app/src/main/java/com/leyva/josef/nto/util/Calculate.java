package com.leyva.josef.nto.util;

/**
 * Created by josef on 9/15/17.
 */

public class Calculate {

    private Calculate() {
    }

    public static double ruleTre(double calificacion, double reactivos, double margen, int posicion) {
        return ((reactivos - posicion * margen) * calificacion) / reactivos;
    }
}
