package com.example.practica12_davidcarrosalinas;

import android.content.Context;
import android.graphics.drawable.Icon;
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

public class AdaptadorPersonalizado extends ArrayAdapter {
    ArrayList<Producto> productos;
    Context context;


    public AdaptadorPersonalizado(@NonNull Context context, ArrayList<Producto> productos) {
        super(context, R.layout.item, productos);
        this.productos = productos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.item, null );



        TextView descr = vista.findViewById(R.id.descr);
        TextView precio = vista.findViewById(R.id.precio);
        ImageView imagen = vista.findViewById(R.id.imagenProd);
        if (this.productos.get(position).getNombreImagen().equals("msi")){

            imagen.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.msi));


        } else if (this.productos.get(position).getNombreImagen().equals("fuente")){
            imagen.setImageIcon(Icon.createWithFilePath("@drawable/fuente.jpg"));

        }


        descr.setText(this.productos.get(position).getDescripcion());
        precio.setText(String.valueOf(this.productos.get(position).getPrecio()));


        return vista;
    }
}

