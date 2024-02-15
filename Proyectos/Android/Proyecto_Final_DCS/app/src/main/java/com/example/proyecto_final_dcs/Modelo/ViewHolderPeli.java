package com.example.proyecto_final_dcs.Modelo;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.MainActivity2;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.VideoclubController;
import com.example.proyecto_final_dcs.Vista.PeliculaFragment;

import java.util.ArrayList;

public class ViewHolderPeli extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView foto;

    private TextView titulo, duracion;
    Button opciones;
    VideoclubController vc = new VideoclubController();

    public ViewHolderPeli(View view) {
        super(view);
        // Define click listener for the ViewHolder's View

        titulo = (TextView) view.findViewById(R.id.titulo);
        duracion = (TextView) view.findViewById(R.id.duracion);
        foto = (ImageView) view.findViewById(R.id.foto);
        opciones = (Button) view.findViewById(R.id.opciones);



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

    public Button getOpciones() {
        return opciones;
    }

    public void setOpciones(Button opciones) {
        this.opciones = opciones;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.opciones){
            ArrayList<Pelicula> pelis = RecyclerAdapterPelicula.pelis;
            Usuario user = MainActivity2.getUser();
            Pelicula seleccionada = pelis.get(getAdapterPosition());

            PopupMenu pm = new PopupMenu(view.getContext(), opciones);

            if (user.isTrabajador()){
                pm.getMenuInflater().inflate(R.menu.menu_contextual_trab, pm.getMenu());

            } else {
                pm.getMenuInflater().inflate(R.menu.menu_contextual_cli, pm.getMenu());
            }
            pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {


                    if (menuItem.getItemId() == R.id.devolverPeli){
                        vc.eliminarAlquiler(seleccionada.getIdentificador(), user.getIdentificador());

                    } else if (menuItem.getItemId() == R.id.modifPeli){



                    } else if (menuItem.getItemId() == R.id.elimPeli){


                    } else if (menuItem.getItemId() == R.id.alquilar){


                    }

                        return false;
                }
            });

        }
    }
}

