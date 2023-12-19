package com.example.examenfragments_davidcarrosalinas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.examenfragments_davidcarrosalinas.Fragments.InsertarFragment;
import com.example.examenfragments_davidcarrosalinas.Fragments.ListaFragment;
import com.example.examenfragments_davidcarrosalinas.Modelo.Libro;
import com.example.examenfragments_davidcarrosalinas.Modelo.SQLHelper;
import com.example.examenfragments_davidcarrosalinas.Modelo.Usuario;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements OnDialogListener, OnFragmentListener{

    Usuario user;
    SQLHelper helper;
    ArrayList<Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        helper = new SQLHelper(this);
        libros = helper.getLibros();
        if (getIntent().getExtras() != null){
            user = (Usuario) getIntent().getSerializableExtra("usuario");
        }

        if (Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ListaFragment listFragment = new ListaFragment();
            Bundle args = new Bundle();
            args.putSerializable("lista", libros);
            listFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragVert, listFragment);
            fragmentTransaction.commit();



        } else if (Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ListaFragment listFragment = new ListaFragment();

            fragmentTransaction.replace(R.id.fragIzq, listFragment);

            if (user.getRol().equals("administrador")){
                InsertarFragment insert = new InsertarFragment();
                fragmentTransaction.replace(R.id.fragDere, insert);

            } else if (user.getRol().equals("cliente")){

            }

            fragmentTransaction.commit();
        }



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (user.getRol().equals("administrador") && Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_opciones, menu);

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.insertar){
            InsertarDialog insertar = new InsertarDialog();
            insertar.show(getSupportFragmentManager(), "Insertar");
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void insertaLibro(Libro lib) {
        helper.insertarLibro(lib);
    }
    public void actualizaLista(int orientacion){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ListaFragment listFragment = new ListaFragment();
        if (orientacion == Configuration.ORIENTATION_PORTRAIT)
            fragmentTransaction.replace(R.id.fragVert, listFragment);
        else
            fragmentTransaction.replace(R.id.fragIzq, listFragment);
        fragmentTransaction.commit();
    }
}