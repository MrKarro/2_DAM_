package com.example.proyecto_final_dcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.proyecto_final_dcs.Interfaces.ComponentListener;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.Vista.FragmentVista;

public class MainActivity2 extends AppCompatActivity implements ComponentListener {

    private Usuario user;
    FrameLayout vista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vista = findViewById(R.id.frag);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentVista frag = new FragmentVista();
        Bundle args = new Bundle();
        args.putBoolean("trabajador", user.isTrabajador());
        frag.setArguments(args);
        fragmentTransaction.replace(R.id.frag, frag);
    }

    @Override
    public void actualizaLista(int orientacion) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        if (user.isTrabajador()){
            inflater.inflate(R.menu.menu_opciones_trab, menu);
        } else {
            inflater.inflate(R.menu.menu_opciones_cli, menu);
        }

        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == R.id.verCat){

        } else if (item.getItemId() == R.id.insertarPeli){

        } else if (item.getItemId() == R.id.verAlquileres){

        } else if (item.getItemId() == R.id.verDisp){

        } else if (item.getItemId() == R.id.verMiAlqui){

        } else if (item.getItemId() == R.id.cambContra){

        }


        return super.onOptionsItemSelected(item);
    }


}