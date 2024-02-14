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
import android.widget.Toast;

import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.Vista.AddPeliDialog;
import com.example.proyecto_final_dcs.Vista.AlquileresFragment;
import com.example.proyecto_final_dcs.Vista.PeliculaFragment;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Usuario user;
    FrameLayout vista;
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    ArrayList<Alquiler> alqs = new ArrayList<>();
    ArrayList<Usuario> users = new ArrayList<>();
    ArrayList<Director> direcs = new ArrayList<>();

    VideoclubController vc = new VideoclubController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vista = findViewById(R.id.frag);
        if (getIntent().getExtras() != null){
            user = (Usuario) getIntent().getSerializableExtra("user");

        }



        if (user.isTrabajador()){
            cargarAlquileres(alqs);

        } else {
            cargarPeliculas(peliculas);

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
            cargarPeliculas(peliculas);

        } else if (item.getItemId() == R.id.insertarPeli){
            AddPeliDialog addPeli = new AddPeliDialog();




            addPeli.show(getSupportFragmentManager(), "Añadir");




        } else if (item.getItemId() == R.id.verAlquileres){

            cargarAlquileres(alqs);


        } else if (item.getItemId() == R.id.verDisp){
            ArrayList<Pelicula> pelisDisp = new ArrayList<>();

            for (Pelicula p : peliculas){
                if (p.isDisponible()){
                    pelisDisp.add(p);
                }
            }
            cargarPeliculas(pelisDisp);


        } else if (item.getItemId() == R.id.verMiAlqui){

            ArrayList<Alquiler> miAlqs = new ArrayList<>();

            cargarAlquileres(miAlqs);


        } else if (item.getItemId() == R.id.cambContra){

        }

        return super.onOptionsItemSelected(item);
    }

    public void cargarAlquileres(ArrayList<Alquiler> alqs ){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle args = new Bundle();
        args.putSerializable("alquileres", alqs);
        args.putSerializable("usuarios", users);
        args.putSerializable("peliculas", peliculas);
        args.putSerializable("user", user);

        AlquileresFragment frag = new AlquileresFragment();
        frag.setArguments(args);
        fragmentTransaction.replace(R.id.frag, frag);
        fragmentTransaction.commit();
    }

    public void cargarPeliculas(ArrayList<Pelicula> pelis ){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle args = new Bundle();
        PeliculaFragment frag = new PeliculaFragment();
        args.putSerializable("peliculas", pelis);
        args.putSerializable("directores", direcs);
        args.putSerializable("user", user);
        frag.setArguments(args);
        fragmentTransaction.replace(R.id.frag, frag);
        fragmentTransaction.commit();
    }



}