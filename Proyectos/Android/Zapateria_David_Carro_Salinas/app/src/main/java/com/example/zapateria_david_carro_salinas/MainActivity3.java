package com.example.zapateria_david_carro_salinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    TextView tipo, descripcion, numero, codigo;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tipo = findViewById(R.id.tipo);
        descripcion = findViewById(R.id.descripcion);
        numero = findViewById(R.id.numero);
        codigo = findViewById(R.id.codigo);

        volver = findViewById(R.id.volver);
        volver.setOnClickListener(this);


        if (getIntent().getExtras() != null){
            Calzado c = (Calzado) getIntent().getSerializableExtra("calzado");

            tipo.setText(c.getTipo());
            descripcion.setText(c.getDescripción());

            numero.setText(Integer.toString(c.getNumero()));
            codigo.setText(c.getCodigo());

        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.volver){
            finish();
        }
    }
}