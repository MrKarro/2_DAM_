package com.example.examenfragments_davidcarrosalinas.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examenfragments_davidcarrosalinas.Modelo.Libro;
import com.example.examenfragments_davidcarrosalinas.R;


public class DetallesFragment extends Fragment {


    public DetallesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);

        TextView autor, titulo, paginas;
        autor = view.findViewById(R.id.autor);
        titulo = view.findViewById(R.id.titulo);
        paginas = view.findViewById(R.id.paginas);
        if (getArguments() != null){
            Libro lib = (Libro) getArguments().getSerializable("libro");
            autor.setText(lib.getAutor());
            titulo.setText(lib.getTitulo());
            paginas.setText(String.valueOf(lib.getNumPags()));


        }



        // Inflate the layout for this fragment
        return view;
    }
}