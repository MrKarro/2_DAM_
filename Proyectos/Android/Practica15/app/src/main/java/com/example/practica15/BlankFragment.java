package com.example.practica15;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BlankFragment extends Fragment implements View.OnClickListener {

    private Alumno alumno;
    private OnFragmentEventListener listener;
    public BlankFragment() {
        // Required empty public constructor
    }
    public BlankFragment(Alumno alumno) {
        this.alumno = alumno;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView nombre = v.findViewById(R.id.nombre);
        TextView apellido = v.findViewById(R.id.apellido);
        TextView dni = v.findViewById(R.id.dni);
        Button delegado = v.findViewById(R.id.botonDelegado);
        delegado.setOnClickListener(this);

        nombre.setText(alumno.getNombre());
        apellido.setText(alumno.getApellidos());
        dni.setText(alumno.getDni());


        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentEventListener){
            listener = (OnFragmentEventListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botonDelegado){
            listener.setDelegado(alumno);
        }
    }
}