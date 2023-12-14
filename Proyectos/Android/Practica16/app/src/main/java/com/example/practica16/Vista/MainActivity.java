package com.example.practica16.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.practica16.Interfaces.OnFragmentEventListener;
import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.Interfaces.OnDialogEvent;
import com.example.practica16.R;
import com.example.practica16.Modelo.SQLHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnDialogEvent, View.OnClickListener, OnFragmentEventListener {

    ArrayList<Vehiculo> lista;

    FrameLayout frag;
    FloatingActionButton boton;
    SQLHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag = findViewById(R.id.fragVertical);
        helper = new SQLHelper(this);
        lista = helper.consultaVehiculos();

        if(Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation){ //es vertical o portrait.
            boton = findViewById(R.id.flButton1);
            actualizaFragment(lista);

        } else { // es horizontal o landscape.
            boton = findViewById(R.id.flButton2);
            actualizaFragment(lista);
        }

        boton.setOnClickListener(this);



    }

    @Override
    protected void onResume() {
        actualizaFragment(lista);
        super.onResume();
    }

    public void actualizaFragment(ArrayList<Vehiculo> lista){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putSerializable("lista", lista);

        if (Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation){


            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragVertical, fragment);
        } else { // es horizontal o landscape.
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragIzq, fragment);
        }

        fragmentTransaction.commit();

    }

    @Override
    public void addVehiculo(Vehiculo v, boolean modif) {
        if (modif){
            helper.modificarCoche(v);
        } else {
            helper.insertarCoche(v);
            lista.add(v);
        }
        actualizaFragment(helper.consultaVehiculos());



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.flButton1){
            DialogAdd dialog = new DialogAdd();
            dialog.show(getSupportFragmentManager(), "Dialogo");
        } else if (view.getId() == R.id.flButton2){
            DialogAdd dialog = new DialogAdd();
            dialog.show(getSupportFragmentManager(), "Dialogo");
        }
    }


    @Override
    public void mandaVehiculo(Vehiculo v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetallesFragment fragment = new DetallesFragment(v);

        fragmentTransaction.replace(R.id.fragDere, fragment);
        fragmentTransaction.commit();

    }



}