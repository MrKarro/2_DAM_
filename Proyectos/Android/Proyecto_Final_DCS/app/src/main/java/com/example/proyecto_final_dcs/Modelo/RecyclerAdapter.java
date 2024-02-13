package com.example.proyecto_final_dcs.Modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter {

    ArrayList<Pelicula> pelis;
    ArrayList<Alquiler> alqs;

    boolean peli;

    public RecyclerAdapter(ArrayList<Pelicula> pelis, boolean peli) {
        this.pelis  = pelis;
        this.peli = peli;


    }
    public RecyclerAdapter(ArrayList<Alquiler> alqs) {
        this.alqs  = alqs;
        this.peli = false;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view;
        if (peli){
           view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_peli, parent, false);


        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_alquiler, parent, false);
        }


        return new ViewHolderPeli(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (peli){

            ViewHolderPeli hold = (ViewHolderPeli) holder;
            //hold.getFoto().setImageDrawable(pelis.get(position).getPortada());
            hold.getTitulo().setText(((Pelicula) pelis.get(position)).getTitulo());

            hold.getDuracion().setText(((Pelicula) pelis.get(position)).getDuracion().toString());
        } else {
            ViewHolderAlquiler holdAlq = (ViewHolderAlquiler) holder;
            holdAlq.getId_peli().setText(((Alquiler) alqs.get(position)).getId_pelicula());
            holdAlq.getId_user().setText(((Alquiler) alqs.get(position)).getId_usuario());
            holdAlq.getFecha_alq().setText(((Alquiler) alqs.get(position)).getFecha_alquiler().toString());
            holdAlq.getFecha_dev().setText(((Alquiler) alqs.get(position)).getFecha_devolucion().toString());
            holdAlq.getExtendido().setSelected(((Alquiler) alqs.get(position)).isExtendido());


        }


    }

    @Override
    public int getItemCount() {
        if (peli)
            return pelis.size();
        else
            return alqs.size();
    }
}
