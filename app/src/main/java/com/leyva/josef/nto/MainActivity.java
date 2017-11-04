package com.leyva.josef.nto;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.leyva.josef.nto.util.Calculate.ruleTre;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAction();
        actionEditTextHideKeyboard();
    }

    private void buttonAction() {
        findViewById(R.id.calcular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);
                calculate();
            }
        });
    }

    private void calculate() {
        final TextView resultado = findViewById(R.id.resultado);
        resultado.setText("");
        resultado.append(textDisplay());
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

    private void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void actionEditTextHideKeyboard() {
        ((EditText) findViewById(R.id.reactivos)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    hideKeyboard(textView);
                    calculate();
                    return true;
                }
                return false;
            }
        });
    }
}
