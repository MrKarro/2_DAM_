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

    public RecyclerAdapter(ArrayList<Pelicula> pelis) {
        this.pelis = pelis;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_peli, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder hold = (ViewHolder) holder;
        //hold.getFoto().setImageDrawable(pelis.get(position).getPortada());
        hold.getTitulo().setText(pelis.get(position).getTitulo());

        hold.getDuracion().setText(pelis.get(position).getDuracion().toString());
    }

    @Override
    public int getItemCount() {
        return pelis.size();
    }
}
