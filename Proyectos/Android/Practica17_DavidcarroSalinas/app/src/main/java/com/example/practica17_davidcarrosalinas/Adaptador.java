package com.example.practica17_davidcarrosalinas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter {

    ArrayList<Usuario> users;


    public Adaptador(ArrayList<Usuario> users){
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ViewHolder hold = (ViewHolder) holder;
        hold.getNombre().setText(users.get(position).getNombre());
        hold.getApellido().setText(users.get(position).getApell());
        hold.getEdad().setText(String.valueOf(users.get(position).getEdad()));
        hold.getProvincia().setText(users.get(position).getProvincia());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }




}
