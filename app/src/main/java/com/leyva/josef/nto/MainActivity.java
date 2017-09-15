package com.leyva.josef.nto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.leyva.josef.nto.util.Calculate;

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
                resultado.setText("");

                try {
                    resultado.setText(
                            Calculate.calculate(calficacion.getText().toString(), reactivos.getText().toString())
                    );

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, R.string.message_error, Toast.LENGTH_SHORT).show();
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
