package com.example.ejemplofragments;

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

    private String nombre;
    private OnFragmentEventListener listener;

    public BlankFragment() {
        // Required empty public constructor
    }
    //Comunicación por constructor
    public BlankFragment(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        TextView saludo = v.findViewById(R.id.saludo);
        saludo.setText(this.nombre);
        Button enviar = v.findViewById(R.id.botFragm);
        enviar.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botFragm){
            listener.saludar();
        }
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
}