package com.example.practica10_a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends ArrayAdapter {
    ArrayList<Coche> coches;
    Context context;


    public AdaptadorPersonalizado(@NonNull Context context,ArrayList<Coche> coches) {
        super(context, R.layout.coches, coches);
        this.coches = coches;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.coches, null );

        TextView marca = vista.findViewById(R.id.marca);
        TextView modelo = vista.findViewById(R.id.modelo);

        marca.setText(this.coches.get(position).getMarca());
        modelo.setText(this.coches.get(position).getModelo());
        return vista;
    }
}
