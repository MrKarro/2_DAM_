package com.example.proyecto_final_dcs.Vista;

import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.RecyclerAdapter;
import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;


public class PeliculaFragment extends Fragment implements View.OnClickListener {

    Spinner filtro;
    EditText texto;
    Button filtrar;
    RecyclerView lista;

    ArrayList<Pelicula> pelis;
    ArrayList<Director> direcs;


    public PeliculaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pelis = (ArrayList<Pelicula>) getArguments().getSerializable("peliculas");
            direcs = (ArrayList<Director>) getArguments().getSerializable("directores");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pelicula, container, false);

        RecyclerAdapter adapter = new RecyclerAdapter(pelis, true);
        lista = view.findViewById(R.id.lista);
        lista.setAdapter(adapter);
        filtro  = view.findViewById(R.id.spin);
        texto = view.findViewById(R.id.texto);
        filtrar = view.findViewById(R.id.botFiltrar);
        filtrar.setOnClickListener(this);
        String[] tiposFiltro = {"titulo", "anho", "director"};

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
                    for (Pelicula p : pelis){
                        if (p.getTitulo().contains(text))
                            pelisFiltradas.add(p);

                    }
                    break;
                case "anho":
                    for (Pelicula p : pelis){
                        if (String.valueOf(p.getAnho()).contains(text))
                            pelisFiltradas.add(p);

                    }
                    break;
                case "director":
                    int idDirec = -1;
                    for (Director d : direcs){
                        if (d.getNombre().equals(text)){
                            idDirec = d.getIdentificador();
                        }
                    }

                    for (Pelicula p : pelis){
                        if (p.getIdDirector() == idDirec)
                            pelisFiltradas.add(p);

                    }
                    break;


            }
            if (pelisFiltradas.size() == 0){
                Toast.makeText(getContext(), "No hay películas con esos parámetros", Toast.LENGTH_SHORT).show();
            } else {
                RecyclerAdapter adapter = new RecyclerAdapter(pelisFiltradas, true);
                lista.setAdapter(adapter);
            }
        }

    }
}