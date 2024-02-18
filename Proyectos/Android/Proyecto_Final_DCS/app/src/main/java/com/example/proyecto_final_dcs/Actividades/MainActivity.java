package com.example.proyecto_final_dcs.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto_final_dcs.Modelo.VideoclubController;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.Vista.LoginDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    VideoclubController vc = new VideoclubController();


    Button ingresar, registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ingresar = findViewById(R.id.ingresar);
        registrar = findViewById(R.id.registrar);
        ingresar.setOnClickListener(this);
        registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ingresar){

            LoginDialog dialog = new LoginDialog();
            dialog.setAdd(false);
            dialog.setVc(vc);
            dialog.show(getSupportFragmentManager(), "Ingresar");




        } else if (view.getId() == R.id.registrar){
            LoginDialog dialog = new LoginDialog();
            dialog.setAdd(true);
            dialog.setVc(vc);
            dialog.show(getSupportFragmentManager(), "Registrar");
        }
    }



}