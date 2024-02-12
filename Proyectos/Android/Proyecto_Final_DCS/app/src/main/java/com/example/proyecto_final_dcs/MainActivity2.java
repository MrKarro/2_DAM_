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
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.Vista.AlquileresFragment;
import com.example.proyecto_final_dcs.Vista.FragmentVista;
import com.example.proyecto_final_dcs.Vista.PeliculaFragment;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity  {

    private Usuario user;
    FrameLayout vista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vista = findViewById(R.id.frag);
        if (getIntent().getExtras() != null){
            user = (Usuario) getIntent().getSerializableExtra("user");

        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle args = new Bundle();

        if (user.isTrabajador()){
            AlquileresFragment frag = new AlquileresFragment();
            //recuperar aqui un arraylist con los alquileres y pasarlo
            ArrayList<Alquiler> alqs = new ArrayList<Alquiler>();
            args.putSerializable("alquileres", alqs);
            frag.setArguments(args);
            fragmentTransaction.replace(R.id.frag, frag);

        } else {
            PeliculaFragment frag = new PeliculaFragment();
            //recuperar aqui un arraylist con los peliculas y pasarlo
            ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
            args.putSerializable("peliculas", pelis);
            frag.setArguments(args);
            fragmentTransaction.replace(R.id.frag, frag);

        }
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

            //recuperar aqui un arraylist con todas las peliculas y pasarlo
            ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
            cargarPeliculas(pelis);



        } else if (item.getItemId() == R.id.insertarPeli){


        } else if (item.getItemId() == R.id.verAlquileres){
            //recuperar aqui un arraylist con todas las alquileres y pasarlo
            ArrayList<Alquiler> alqs = new ArrayList<Alquiler>();
            cargarAlquileres(alqs);


        } else if (item.getItemId() == R.id.verDisp){
            //recuperar aqui un arraylist con las peliculas disponibles

            ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
            ArrayList<Pelicula> pelisDisp = new ArrayList<Pelicula>();

            for (Pelicula p : pelis){
                pelisDisp.add(p);
            }
            cargarPeliculas(pelisDisp);


        } else if (item.getItemId() == R.id.verMiAlqui){
            ArrayList<Alquiler> alqs = new ArrayList<Alquiler>();
            ArrayList<Alquiler> miAlqs = new ArrayList<Alquiler>();

            for (Alquiler a : alqs){
                if (user.getIdentificador() == a.getId_usuario()){
                    miAlqs.add(a);
                }
            }
            cargarAlquileres(miAlqs);


        } else if (item.getItemId() == R.id.cambContra){

        }


        return super.onOptionsItemSelected(item);
    }

    public void cargarAlquileres(ArrayList<Alquiler> alqs ){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle args = new Bundle();
        AlquileresFragment frag = new AlquileresFragment();
        args.putSerializable("alquileres", alqs);
        frag.setArguments(args);
        fragmentTransaction.replace(R.id.frag, frag);
    }
    public void cargarPeliculas(ArrayList<Pelicula> pelis ){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle args = new Bundle();
        PeliculaFragment frag = new PeliculaFragment();
        args.putSerializable("peliculas", pelis);
        frag.setArguments(args);
        fragmentTransaction.replace(R.id.frag, frag);
    }


}