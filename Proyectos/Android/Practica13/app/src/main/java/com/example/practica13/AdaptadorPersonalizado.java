package com.example.practica13;

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

    ArrayList<Alumno> alumnos;
    Context context;

    public AdaptadorPersonalizado(@NonNull Context context, ArrayList<Alumno> alumnos) {
        super(context, R.layout.item, alumnos);
        this.alumnos = alumnos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.item, null);


        TextView dni = vista.findViewById(R.id.itemDni);
        TextView nombre = vista.findViewById(R.id.itemNombre);
        TextView apellidos = vista.findViewById(R.id.itemApellidos);
        TextView edad = vista.findViewById(R.id.itemEdad);
        TextView telefono = vista.findViewById(R.id.itemTelefono);


        dni.setText(this.alumnos.get(position).getDni());
        nombre.setText(this.alumnos.get(position).getNombre());
        apellidos.setText(this.alumnos.get(position).getApellidos());
        edad.setText(this.alumnos.get(position).getEdad());
        telefono.setText(this.alumnos.get(position).getTelefono());

        return vista;
    }
}
