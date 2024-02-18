package com.example.proyecto_final_dcs.Modelo;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_dcs.Actividades.MainActivity2;
import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;


public class ViewHolderAlquiler extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView id_peli, id_user, fecha_alq, fecha_dev;
    private CheckBox extendido;
    Button opciones;
    ArrayList<Alquiler> alqs;
    VideoclubController vc = new VideoclubController();


    public ViewHolderAlquiler(@NonNull View view) {
        super(view);

        id_peli =  view.findViewById(R.id.id_peli);
        id_user = view.findViewById(R.id.id_user);
        fecha_alq = view.findViewById(R.id.fecha_alq);
        fecha_dev = view.findViewById(R.id.fecha_dev);
        extendido = view.findViewById(R.id.extendido);
        opciones = view.findViewById(R.id.opciones);
        opciones.setOnClickListener(this);

    }
    public ViewHolderAlquiler(@NonNull View view, ArrayList<Alquiler> alqs) {
        super(view);
        this.alqs = alqs;
        id_peli =  view.findViewById(R.id.id_peli);
        id_user = view.findViewById(R.id.id_user);
        fecha_alq = view.findViewById(R.id.fecha_alq);
        fecha_dev = view.findViewById(R.id.fecha_dev);
        extendido = view.findViewById(R.id.extendido);
        opciones = view.findViewById(R.id.opciones);
        opciones.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.opciones){

            Usuario user = MainActivity2.getUser();
            Alquiler seleccionada = alqs.get(getAdapterPosition());

            PopupMenu pm = new PopupMenu(view.getContext(), opciones);

            if (user.isTrabajador()){
                pm.getMenuInflater().inflate(R.menu.menu_contextual_trab_alqui, pm.getMenu());

            } else {
                pm.getMenuInflater().inflate(R.menu.menu_contextual_cli_alqui, pm.getMenu());
            }

            pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {


                    if (menuItem.getItemId() == R.id.eliminar){
                        vc.eliminarAlquiler(seleccionada.getId_pelicula(), seleccionada.getId_usuario());

                    } else if (menuItem.getItemId() == R.id.extender){



                    }

                    return false;
                }
            });
            pm.show();
        }
    }
}
