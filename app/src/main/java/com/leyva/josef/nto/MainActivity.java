package com.leyva.josef.nto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Declarando los objetos UI
     */
    private EditText calficacion, reactivos;
    private TextView resultado;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    resultado.setText("");
                    double margen = 0.5;
                    int c = Integer.parseInt(calficacion.getText().toString()); //calificacion
                    int r = Integer.parseInt(reactivos.getText().toString()); //reactivos

                    for (int i = r * 2; i >= 0; i--) {
                        double rs = ((r - i * margen) * c) / r;
                        resultado.append(String.format("Reactivo: %.2f", r - i * margen) + " - " +
                                String.format("Resultado: %.2f", rs) + "\n");
                    }

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error - Sólo digitos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**
     * Inicializando parametros
     */
    private void init() {
        calficacion = (EditText) findViewById(R.id.calificacion);
        reactivos = (EditText) findViewById(R.id.reactivos);
        resultado = (TextView) findViewById(R.id.resultado);
        calcular = (Button) findViewById(R.id.calcular);
    }

}
