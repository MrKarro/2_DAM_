package com.example.proyecto_final_dcs.Modelo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.R;

public class ViewHolder extends RecyclerView.ViewHolder{

    private ImageView foto;

    private TextView titulo, duracion;

    public ViewHolder(View view) {
        super(view);
        // Define click listener for the ViewHolder's View

        titulo = (TextView) view.findViewById(R.id.titulo);
        duracion = (TextView) view.findViewById(R.id.duracion);
        foto = (ImageView) view.findViewById(R.id.foto);


    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }


    public TextView getDuracion() {
        return duracion;
    }

    public void setDuracion(TextView duracion) {
        this.duracion = duracion;
    }
}
