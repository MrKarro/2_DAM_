package com.example.proyecto_final_dcs.Vista;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.proyecto_final_dcs.Interfaces.ComponentListener;
import com.example.proyecto_final_dcs.R;


public class FragmentVista extends Fragment {

    Spinner filtro;
    RecyclerView lista;

    boolean trabajador;

    ComponentListener listener;

    public FragmentVista() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            trabajador = getArguments().getBoolean("trabajador");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vista, container, false);
        if (trabajador){

        }

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ComponentListener){
            listener = (ComponentListener) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}