package com.example.proyecto_final_dcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.proyecto_final_dcs.Modelo.Usuario;

public class MainActivity2 extends AppCompatActivity implements OnDialogListener {

    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void actualizaLista(int orientacion) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (user.isTrabajador()){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_opciones_trab, menu);
        } else {
            MenuInflater inflater = getMenuInflater();
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