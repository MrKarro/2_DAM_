package com.example.proyecto_final_dcs.Modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;

public class RecyclerAdapterPelicula extends RecyclerView.Adapter  {

    static ArrayList<Pelicula> pelis;



    boolean peli;

    public RecyclerAdapterPelicula(ArrayList<Pelicula> pelis) {
        this.pelis  = pelis;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_peli, parent, false);


        return new ViewHolderPeli(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            ViewHolderPeli hold = (ViewHolderPeli) holder;
            //hold.getFoto().setImageDrawable(pelis.get(position).getPortada());
            hold.getTitulo().setText(((Pelicula) pelis.get(position)).getTitulo());

            hold.getDuracion().setText(((Pelicula) pelis.get(position)).getDuracion().toString());




    }

    @Override
    public int getItemCount() {
            return pelis.size();

    }

}
