package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.RecyclerAdapterAlquiler;
import com.example.proyecto_final_dcs.Modelo.RecyclerAdapterPelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.VideoclubController;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;


public class AlquileresFragment extends Fragment implements View.OnClickListener {



    RecyclerView lista;
    EditText dni;
    Button filtrar;
    VideoclubController vc;
    ArrayList<Alquiler> alqs = new ArrayList<>();
    ArrayList<Usuario> users = new ArrayList<>();
    RecyclerAdapterAlquiler adapter;
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    Usuario user;

    public AlquileresFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            alqs = (ArrayList<Alquiler>) getArguments().getSerializable("alquileres");
            users = (ArrayList<Usuario>) getArguments().getSerializable("usuarios");
            peliculas = (ArrayList<Pelicula>) getArguments().getSerializable("peliculas");





        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alquileres, container, false);
        user =(Usuario) getArguments().getSerializable("user");
        lista = view.findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        lista.setLayoutManager(linearLayoutManager);
        vc = new VideoclubController();
        dni = view.findViewById(R.id.dni);
        filtrar = view.findViewById(R.id.botFiltrar);
        filtrar.setOnClickListener(this);

//        rellenaAlquileres(vc);
//        rellenaUsuarios(vc);
//        Toast.makeText(getContext(), "users: " + users.size(), Toast.LENGTH_SHORT).show();
//        rellenaPelis(vc);
//
//
//
//        Log.i("DNI", user.getDni());
//
//        filtraAlqs(user.getDni());



        CompletableFuture<Void> alquileresFuture = CompletableFuture.runAsync(() -> rellenaAlquileres(vc));
        CompletableFuture<Void> usuariosFuture = CompletableFuture.runAsync(() -> rellenaUsuarios(vc));
        CompletableFuture<Void> peliculasFuture = CompletableFuture.runAsync(() -> rellenaPelis(vc));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(alquileresFuture, usuariosFuture, peliculasFuture);
        allFutures.thenRun(() -> {
            // Una vez que todas las llamadas asíncronas se completen, ejecutamos el filtrado
            filtraAlqs(user.getDni());
        });






        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botFiltrar){

            String dniBuscado = dni.getText().toString();
            filtraAlqs(dniBuscado);
        }
    }

    public void filtraAlqs(String dni){
        int idBuscado = 0;
        for (Usuario u : users){
            if (u.getDni().equals(dni)){
                idBuscado = u.getIdentificador();
            }
        }
        ArrayList<Alquiler> alqFiltrado = new ArrayList<>();
        for (Alquiler a : alqs){
            if (a.getId_usuario() == idBuscado){
                alqFiltrado.add(a);
            }
        }
        if (alqFiltrado.size() == 0){
            Toast.makeText(getContext(), "No hay películas con esos parámetros", Toast.LENGTH_SHORT).show();
        } else {
            RecyclerAdapterAlquiler adapter = new RecyclerAdapterAlquiler(alqFiltrado);
            lista.setAdapter(adapter);
        }
    }

    public void rellenaAlquileres(VideoclubController vc) {
        vc.getAlquileres(new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        alqs = alquileres;

                        adapter = new RecyclerAdapterAlquiler(alqs);

                        lista.setAdapter(adapter);
                    }
                });
            }
            public void alquileresIdCallback(ArrayList<Alquiler> alqs){}

            @Override
            public void directoresCallback(ArrayList<Director> directores) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

        });
    }

    public void rellenaUsuarios(VideoclubController vc) {
        vc.getUsuarios(new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

            }
            public void alquileresIdCallback(ArrayList<Alquiler> alqs){}
            @Override
            public void directoresCallback(ArrayList<Director> directores) {

            }


            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        users = usuarios;
                    }
                });

            }

        });
    }
    public void rellenaPelis(VideoclubController vc) {
        vc.getPeliculas(new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        peliculas = pelis;
                    }
                });

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

            }
            public void alquileresIdCallback(ArrayList<Alquiler> alqs){}

            @Override
            public void directoresCallback(ArrayList<Director> directores) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

        });
    }
}