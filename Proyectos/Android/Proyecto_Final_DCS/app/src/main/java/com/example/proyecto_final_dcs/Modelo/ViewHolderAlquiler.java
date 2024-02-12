package com.example.proyecto_final_dcs.Modelo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.R;


public class ViewHolderAlquiler extends RecyclerView.ViewHolder{

    private TextView id_peli, id_user, fecha_alq, fecha_dev;
    private CheckBox extendido;

    public ViewHolderAlquiler(@NonNull View view) {
        super(view);

        id_peli =  view.findViewById(R.id.id_peli);
        id_user = view.findViewById(R.id.id_user);
        fecha_alq = view.findViewById(R.id.fecha_alq);
        fecha_dev = view.findViewById(R.id.fecha_dev);
        extendido = view.findViewById(R.id.extendido);

    }

    public TextView getId_peli() {
        return id_peli;
    }

    public void setId_peli(TextView id_peli) {
        this.id_peli = id_peli;
    }

    public TextView getId_user() {
        return id_user;
    }

    public void setId_user(TextView id_user) {
        this.id_user = id_user;
    }

    public TextView getFecha_alq() {
        return fecha_alq;
    }

    public void setFecha_alq(TextView fecha_alq) {
        this.fecha_alq = fecha_alq;
    }

    public TextView getFecha_dev() {
        return fecha_dev;
    }

    public void setFecha_dev(TextView fecha_dev) {
        this.fecha_dev = fecha_dev;
    }

    public CheckBox getExtendido() {
        return extendido;
    }

    public void setExtendido(CheckBox extendido) {
        this.extendido = extendido;
    }
}
