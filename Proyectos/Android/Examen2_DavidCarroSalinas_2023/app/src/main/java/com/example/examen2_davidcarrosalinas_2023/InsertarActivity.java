package com.example.examen2_davidcarrosalinas_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsertarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText codigo, nombre, peso;

    RadioButton gato, perro, pajaro;

    Button insertar;



    RadioGroup grupo;
    SQLHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        codigo = findViewById(R.id.codigo);
        nombre = findViewById(R.id.nombre);
        peso = findViewById(R.id.peso);

        gato = findViewById(R.id.gato);
        perro = findViewById(R.id.perro);
        pajaro = findViewById(R.id.pajaro);
        insertar = findViewById(R.id.insertar);
        grupo = findViewById(R.id.tipo);
        insertar.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.insertar){
            boolean correcto = comprobarCampos();

            if (correcto) {

                int cod = Integer.parseInt(codigo.getText().toString());
                String nom = nombre.getText().toString();
                double pes = Double.parseDouble( peso.getText().toString() );
                String tip = "";
                if (grupo.getCheckedRadioButtonId() == R.id.gato){
                    tip = "Gato";
                } else if (grupo.getCheckedRadioButtonId() == R.id.perro) {
                    tip = "Perro";
                } else if (grupo.getCheckedRadioButtonId() == R.id.pajaro) {
                    tip = "Pajaro";
                }

                Animal a = new Animal(cod, nom, pes, tip);
                helper = new SQLHelper(this);
                helper.insertaAnimal(a);

                Toast.makeText(this, R.string.animal_insertado_correctamente, Toast.LENGTH_SHORT).show();
                finish();

            } else {
                Toast.makeText(this, R.string.no_se_ha_podido_insertar, Toast.LENGTH_SHORT).show();
            }


        }
    }

    public boolean comprobarCampos(){
        boolean correcto = true;
        if (codigo.getText().toString().isEmpty()){
            correcto = false;
        } else if (nombre.getText().toString().isEmpty()){
            correcto = false;
        } else if (peso.getText().toString().isEmpty()){
            correcto = false;
        } else if (grupo.getCheckedRadioButtonId() == -1){
            correcto = false;
        }

        return correcto;

    }
}