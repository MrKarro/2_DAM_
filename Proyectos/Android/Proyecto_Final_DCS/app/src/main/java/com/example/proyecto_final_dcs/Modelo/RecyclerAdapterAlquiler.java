package com.example.proyecto_final_dcs.Modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;

public class RecyclerAdapterAlquiler extends RecyclerView.Adapter{

    ArrayList<Alquiler> alqs;

    public RecyclerAdapterAlquiler(ArrayList<Alquiler> alqs) {
        this.alqs  = alqs;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alquiler, parent, false);
        return new ViewHolderAlquiler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderAlquiler holdAlq = (ViewHolderAlquiler) holder;
        holdAlq.getId_peli().setText(String.valueOf(((Alquiler) alqs.get(position)).getId_pelicula()));
        holdAlq.getId_user().setText(String.valueOf(((Alquiler) alqs.get(position)).getId_usuario()));
        holdAlq.getFecha_alq().setText(((Alquiler) alqs.get(position)).getFecha_alquiler().toString());
        holdAlq.getFecha_dev().setText(((Alquiler) alqs.get(position)).getFecha_devolucion().toString());
        holdAlq.getExtendido().setSelected(((Alquiler) alqs.get(position)).isExtendido());
    }

    @Override
    public int getItemCount() {
        return alqs.size();
    }
}
