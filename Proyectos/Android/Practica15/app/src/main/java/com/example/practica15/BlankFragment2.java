package com.example.practica15;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class BlankFragment2 extends Fragment {


    private Alumno alumno;
    public BlankFragment2() {
        // Required empty public constructor
    }
    public BlankFragment2(Alumno alumno) {
        this.alumno = alumno;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank2, container, false);
        ImageView imagen = v.findViewById(R.id.foto);
        imagen.setImageResource(alumno.getFoto());
        return v;
    }
}