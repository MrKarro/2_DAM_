package com.example.ex1_e1_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, TextWatcher {

    EditText campo;
    RadioGroup grupo;
    RadioButton rb5, rb10, rb20;
    Button limpiar;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo = findViewById(R.id.campo);
        grupo = findViewById(R.id.grupo);
        rb5 = findViewById(R.id.rb5);
        rb10 = findViewById(R.id.rb10);
        rb20 = findViewById(R.id.rb20);
        limpiar = findViewById(R.id.boton);
        resultado = findViewById(R.id.footer);
        limpiar.setOnClickListener(this);
        grupo.setOnCheckedChangeListener(this);
        campo.setEnabled(false);
        campo.addTextChangedListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.boton){
            grupo.clearCheck();
            campo.setHint(R.string.seleccione_el_descuento);
            resultado.setText("");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (grupo.getCheckedRadioButtonId() != -1){
            campo.setEnabled(true);
            campo.setHint(R.string.introduzca_un_precio);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        float numero = Float.parseFloat(campo.getText().toString());
        if (grupo.getCheckedRadioButtonId() == R.id.rb5){
            resultado.setText(Double.toString(numero -(numero*0.05)));
        } else if (grupo.getCheckedRadioButtonId() == R.id.rb10){
            resultado.setText(Double.toString(numero -(numero*0.1)));
        } else if (grupo.getCheckedRadioButtonId() == R.id.rb20){
            resultado.setText(Double.toString(numero -(numero*0.2)));
        }
    }
}