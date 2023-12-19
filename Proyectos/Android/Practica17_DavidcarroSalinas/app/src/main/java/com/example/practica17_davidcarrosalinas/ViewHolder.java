package com.example.practica17_davidcarrosalinas;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{

    private TextView nombre;
    private TextView apellido;
    private TextView edad;
    private TextView provincia;

    public ViewHolder(View view) {
        super(view);
        // Define click listener for the ViewHolder's View

        nombre = (TextView) view.findViewById(R.id.nombre);
        apellido = (TextView) view.findViewById(R.id.apellido);
        edad = (TextView) view.findViewById(R.id.edad);
        provincia = (TextView) view.findViewById(R.id.provincia);


    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getApellido() {
        return apellido;
    }

    public void setApellido(TextView apellido) {
        this.apellido = apellido;
    }

    public TextView getEdad() {
        return edad;
    }

    public void setEdad(TextView edad) {
        this.edad = edad;
    }

    public TextView getProvincia() {
        return provincia;
    }

    public void setProvincia(TextView provincia) {
        this.provincia = provincia;
    }
}
