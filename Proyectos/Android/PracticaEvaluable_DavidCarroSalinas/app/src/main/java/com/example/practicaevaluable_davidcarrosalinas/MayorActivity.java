package com.example.practicaevaluable_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MayorActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, View.OnClickListener {

    RatingBar barra;
    Button enviar;
    float valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayor);
        barra = findViewById(R.id.ratingBar);
        enviar = findViewById(R.id.buttonOk);

        enviar.setOnClickListener(this);
        barra.setOnRatingBarChangeListener(this);



    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        valor = v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonOk){
            String mostrar = "Usted ha valorado con " + valor + " estrellas";
            Toast.makeText(this, mostrar, Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}