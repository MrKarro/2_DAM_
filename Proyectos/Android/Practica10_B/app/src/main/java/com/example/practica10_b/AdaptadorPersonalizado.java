package com.example.practica10_b;

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
        TextView telefono = vista.findViewById(R.id.telefono);
        TextView provincia = vista.findViewById(R.id.provincia);
        TextView dni = vista.findViewById(R.id.dni);
        TextView edad = vista.findViewById(R.id.edad);


        nombre.setText(this.usuarios.get(position).getNombre().toUpperCase() + " " + this.usuarios.get(position).getApell().toUpperCase());
        telefono.setText(this.usuarios.get(position).getTelefono());
        provincia.setText(this.usuarios.get(position).getProvincia());
        dni.setText(this.usuarios.get(position).getDni());
        edad.setText(String.valueOf(this.usuarios.get(position).getEdad()));

        return vista;
    }
}

