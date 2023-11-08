package com.example.practica11_b;

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
    ArrayList<Usuario> usuarios;
    Context context;


    public AdaptadorPersonalizado(@NonNull Context context, ArrayList<Usuario> usuarios) {
        super(context, R.layout.usuario, usuarios);
        this.usuarios = usuarios;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.usuario, null );

        TextView nombre = vista.findViewById(R.id.nombre);
        TextView apellidos = vista.findViewById(R.id.apellidos);



        nombre.setText(this.usuarios.get(position).getNombre().toUpperCase());
        apellidos.setText(this.usuarios.get(position).getApell().toUpperCase());


        return vista;
    }
}

