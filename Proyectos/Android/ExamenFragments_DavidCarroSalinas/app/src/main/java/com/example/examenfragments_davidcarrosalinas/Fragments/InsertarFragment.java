package com.example.examenfragments_davidcarrosalinas.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenfragments_davidcarrosalinas.Modelo.Libro;
import com.example.examenfragments_davidcarrosalinas.OnFragmentListener;
import com.example.examenfragments_davidcarrosalinas.R;


public class InsertarFragment extends Fragment implements View.OnClickListener {


    EditText titulo, autor, paginas;
    Button add;
    OnFragmentListener listener;
    public InsertarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentListener){
            listener = (OnFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insertar, container, false);
        titulo = view.findViewById(R.id.titulo);
        autor = view.findViewById(R.id.autor);
        paginas = view.findViewById(R.id.paginas);
        add = view.findViewById(R.id.add);
        add.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add){
            Libro lib = new Libro (titulo.getText().toString(), autor.getText().toString(), Integer.parseInt(paginas.getText().toString()));
            listener.insertaLibro(lib);
            listener.actualizaLista(getResources().getConfiguration().orientation);

        }
    }
}