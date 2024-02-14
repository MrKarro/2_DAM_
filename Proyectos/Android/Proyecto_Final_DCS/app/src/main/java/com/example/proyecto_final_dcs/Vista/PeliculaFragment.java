package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.RecyclerAdapterPelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.VideoclubController;

import java.util.ArrayList;


public class PeliculaFragment extends Fragment implements View.OnClickListener {

    Spinner filtro;
    EditText texto;
    Button filtrar;
    RecyclerView lista;
    VideoclubController vc;

    ArrayList<Pelicula> peliculas;
    ArrayList<Director> direcs;
    RecyclerAdapterPelicula adapter;
    Usuario user;


    public PeliculaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            peliculas = (ArrayList<Pelicula>) getArguments().getSerializable("peliculas");
            direcs = (ArrayList<Director>) getArguments().getSerializable("directores");
            user =(Usuario) getArguments().getSerializable("user");

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pelicula, container, false);


        lista = view.findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        lista.setLayoutManager(linearLayoutManager);
        vc = new VideoclubController();
        rellenaPelis(vc);
        rellenaDirecs(vc);
        filtro  = view.findViewById(R.id.spin);
        texto = view.findViewById(R.id.texto);
        filtrar = view.findViewById(R.id.botFiltrar);
        filtrar.setOnClickListener(this);
        String[] tiposFiltro = {"titulo", "anho", "director"};
        if (user != null){

        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, tiposFiltro);
        filtro.setAdapter(adaptador);
        return view;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botFiltrar){
            String filt =(String) filtro.getSelectedItem();
            String text = texto.getText().toString();
            ArrayList<Pelicula> pelisFiltradas = new ArrayList<>();
            switch (filt) {
                case "titulo":
                    for (Pelicula p : peliculas){
                        if (p.getTitulo().contains(text))
                            pelisFiltradas.add(p);

                    }
                    break;
                case "anho":
                    for (Pelicula p : peliculas){
                        if (String.valueOf(p.getAnho()).contains(text))
                            pelisFiltradas.add(p);

                    }
                    break;
                case "director":
                    int idDirec = -1;
                    for (Director d : direcs){
                        if (d.getNombre().contains(text)){
                            idDirec = d.getIdentificador();
                        }
                    }

                    for (Pelicula p : peliculas){
                        if (p.getIdDirector() == idDirec)
                            pelisFiltradas.add(p);

                    }
                    break;


            }
            if (pelisFiltradas.size() == 0){
                Toast.makeText(getContext(), "No hay películas con esos parámetros", Toast.LENGTH_SHORT).show();
            } else {
                RecyclerAdapterPelicula adapter = new RecyclerAdapterPelicula(pelisFiltradas);
                lista.setAdapter(adapter);
            }
        }

    }
    public void rellenaPelis(VideoclubController vc) {
        vc.getPeliculas(new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {
                peliculas = pelis;

                adapter = new RecyclerAdapterPelicula(peliculas);

                lista.setAdapter(adapter);
            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

            }

            @Override
            public void directoresCallback(ArrayList<Director> directores) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

        });
    }

    public void rellenaDirecs(VideoclubController vc) {
        vc.getDirectores(new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

            }

            @Override
            public void directoresCallback(ArrayList<Director> directores) {
               direcs = directores;
            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

        });
    }
}