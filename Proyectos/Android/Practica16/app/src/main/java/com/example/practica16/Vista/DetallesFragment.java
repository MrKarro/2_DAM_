package com.example.practica16.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.R;


public class DetallesFragment extends Fragment {

    Vehiculo v;
    public DetallesFragment() {
        // Required empty public constructor
    }
    public DetallesFragment(Vehiculo v) {
        this.v = v;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_detalles, container, false);

        TextView numBast = vista.findViewById(R.id.numBastidor);
        TextView marca = vista.findViewById(R.id.marca);
        TextView modelo = vista.findViewById(R.id.modelo);
        TextView color = vista.findViewById(R.id.color);
        TextView combust = vista.findViewById(R.id.combustible);
        TextView kms = vista.findViewById(R.id.kms);

        if (v != null) {

            numBast.setText("Numero de bastidor: " + v.getNumBastidor());
            marca.setText("Marca: " + v.getMarca());
            modelo.setText("Modelo: " + v.getModelo());
            color.setText("Color: " + v.getColor());
            combust.setText("Tipo de combustible: " + v.getCombustible());
            kms.setText("Kilometraje: " + v.getKilometraje());
        }
        return vista;
    }
}