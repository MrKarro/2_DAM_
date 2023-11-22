package com.example.practicaev_davidcarro_salinas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizado extends ArrayAdapter {
    ArrayList<Libro> libros;
    Context context;

    public AdaptadorPersonalizado(@NonNull Context context, ArrayList<Libro> libros) {
        super(context, R.layout.libros, libros);
        this.libros = libros;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.libros, null );

        TextView nombre = vista.findViewById(R.id.titulo);
        TextView autor = vista.findViewById(R.id.autor);

        nombre.setText(this.libros.get(position).getTitulo());
        autor.setText(this.libros.get(position).getAutor());
        if (this.libros.get(position).getPaginas() > 300)
            vista.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mayor));
        else
            vista.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.menor));



        return vista;
    }
}
