package com.leyva.josef.nto.util;

/**
 * Created by josef on 9/15/17.
 */

public class Calculate {

    private Calculate() {
    }

    public static StringBuilder calculate(String calificacion, String reactivos) {
        StringBuilder resultado = new StringBuilder();

        double margen = 0.5;
        int c = Integer.parseInt(calificacion); //calificacion
        int r = Integer.parseInt(reactivos); //reactivos

        for (int i = r * 2; i >= 0; i--) {
            double rs = ((r - i * margen) * c) / r;
            resultado.append(String.format("Reactivo: %.2f", r - i * margen) + " - " +
                    String.format("Resultado: %.2f", rs) + "\n");
        }

        return resultado;

    }
}
