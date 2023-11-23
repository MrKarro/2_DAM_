package com.example.examen2_davidcarrosalinas_2023;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MiAdpter extends ArrayAdapter {

    ArrayList<Animal> animales;

    Context context;

    public MiAdpter(@NonNull Context context, ArrayList<Animal> animales) {
        super(context, R.layout.animales, animales);
        this.context = context;
        this.animales = animales;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.animales, null);


        ImageView img = vista.findViewById(R.id.imagAnimal);
        TextView nom = vista.findViewById(R.id.nomView);
        TextView pes = vista.findViewById(R.id.pesoView);

        if (this.animales.get(position).getTipo().equals("Gato")){
            img.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.gato));
        } else if (this.animales.get(position).getTipo().equals("Perro")){
            img.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.perro));
        } else if (this.animales.get(position).getTipo().equals("Pajaro")){
            img.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.pajaro));
        }
        nom.setText(this.animales.get(position).getNombre());
        pes.setText(String.valueOf(this.animales.get(position).getPeso()));

        return vista;
    }
}
