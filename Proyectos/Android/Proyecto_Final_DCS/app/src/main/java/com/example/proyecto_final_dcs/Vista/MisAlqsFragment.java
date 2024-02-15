package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.RecyclerAdapterAlquiler;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.VideoclubController;

import java.util.ArrayList;

public class MisAlqsFragment extends Fragment {

    ArrayList<Alquiler> alqs = new ArrayList<>();
    RecyclerView lista;
    Usuario user;
    VideoclubController vc = new VideoclubController();
    RecyclerAdapterAlquiler adapter;

    public MisAlqsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {

            user =(Usuario) getArguments().getSerializable("user");
        }

        View view = inflater.inflate(R.layout.fragment_mis_alqs, container, false);
        lista = view.findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        lista.setLayoutManager(linearLayoutManager);
        rellenaAlqs(vc, user);
        vc.getAlquilerId(user.getIdentificador(), lista);




        return view;
    }
    private void rellenaAlqs(VideoclubController vc, Usuario user){
        vc.getAlquilerId(user.getIdentificador(), new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {


            }
            public void alquileresIdCallback(ArrayList<Alquiler> alquis){
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        alqs = alquis;

                        adapter = new RecyclerAdapterAlquiler(alqs);

                        lista.setAdapter(adapter);
                    }
                });


            }

            @Override
            public void directoresCallback(ArrayList<Director> directores) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

        });

    }
}