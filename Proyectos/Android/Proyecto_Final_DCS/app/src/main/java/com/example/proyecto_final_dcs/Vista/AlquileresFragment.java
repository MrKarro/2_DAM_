package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.RecyclerAdapter;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;


public class AlquileresFragment extends Fragment {


    private TextView id_peli, id_user, fecha_alq, fecha_dev;
    private CheckBox extendido;
    ArrayList<Alquiler> alqs;
    ArrayList<Usuario> users;

    public AlquileresFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            alqs = (ArrayList<Alquiler>) getArguments().getSerializable("alquileres");
            users = (ArrayList<Usuario>) getArguments().getSerializable("usuarios");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alquileres, container, false);

        RecyclerAdapter adapter = new RecyclerAdapter(alqs);


        return view;
    }
}