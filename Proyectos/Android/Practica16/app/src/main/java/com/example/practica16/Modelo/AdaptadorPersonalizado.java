package com.example.practica16.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.R;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends ArrayAdapter {
    ArrayList<Vehiculo> coches;
    Context context;

    public AdaptadorPersonalizado(@NonNull Context context, ArrayList<Vehiculo> coches) {
        super(context, R.layout.item, coches);
        this.coches = coches;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.item, null );

        TextView numBast = vista.findViewById(R.id.numBasti);
        TextView marca = vista.findViewById(R.id.marca);
        TextView modelo = vista.findViewById(R.id.modelo);

        numBast.setText(String.valueOf(this.coches.get(position).getNumBastidor()));
        marca.setText(this.coches.get(position).getMarca());
        modelo.setText(this.coches.get(position).getModelo());



        return vista;
    }
}
