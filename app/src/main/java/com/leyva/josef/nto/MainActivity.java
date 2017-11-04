package com.leyva.josef.nto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.leyva.josef.nto.util.Calculate.ruleTre;

public class MainActivity extends AppCompatActivity {

    // TODO: 11/3/17 ARREGLAR LO DE LA INTERFAZ
    // TODO: 11/3/17 strings de idiomas
    // TODO: 11/3/17 al dar click ocultar el teclado
    // TODO: 11/3/17 crear ramas
    // TODO: 11/3/17 refactoring 
    // TODO: 11/3/17 agregar ads
    // TODO: 11/3/17 crear la activity para los datos

    // TODO: 11/3/17 a futuro, agregar opciones de 1/4, 1/2 incremento

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAction();
    }

    private void buttonAction() {
        Button calcular = findViewById(R.id.calcular);
        final TextView resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultado.setText("");
                resultado.append(textDisplay());
            }
        });
    }

    private ArrayList<Double> params() {
        ArrayList<Double> values = new ArrayList<>();
        EditText calficacion = findViewById(R.id.calificacion);
        EditText reactivos = findViewById(R.id.reactivos);

        try {
            double c = Double.parseDouble(calficacion.getText().toString()); //calificacion
            double r = Double.parseDouble(reactivos.getText().toString()); //reactivos
            values.add(c);
            values.add(r);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, R.string.message_error, Toast.LENGTH_SHORT).show();
        }

        return values;
    }

    private StringBuilder textDisplay() {
        StringBuilder resultado = new StringBuilder();
        float margen = 0.5f;
        ArrayList<Double> values = params();

        for (int i = (int) (values.get(1) * 2); i >= 0; i--) {

            double v = ruleTre(values.get(0), values.get(1), margen, i);

            resultado.append(
                    String.format("%s: %.2f", getText(R.string.reactive), values.get(1) - i * margen) + " - " +
                            String.format("%s: %.2f", getText(R.string.result), v) + "%\n"
            );
        }

        return resultado;
    }
}
