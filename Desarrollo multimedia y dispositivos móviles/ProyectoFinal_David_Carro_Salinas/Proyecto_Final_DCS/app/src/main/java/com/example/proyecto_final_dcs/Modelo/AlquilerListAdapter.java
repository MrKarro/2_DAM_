package com.example.proyecto_final_dcs.Modelo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.R;

import java.util.ArrayList;

public class AlquilerListAdapter extends ArrayAdapter<Alquiler>  {

    private ArrayList<Alquiler> alquileres;
    private Context context;

    VideoclubController vc = new VideoclubController();
    String nombreId;

    public AlquilerListAdapter(Context context, ArrayList<Alquiler> alquileres) {
        super(context, R.layout.item_alquiler, alquileres);
        this.context = context;
        this.alquileres = alquileres;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_alquiler, parent, false);

        TextView id_peli = view.findViewById(R.id.id_peli);
        TextView id_user = view.findViewById(R.id.id_user);
        TextView fecha_alq = view.findViewById(R.id.fecha_alq);
        TextView fecha_dev = view.findViewById(R.id.fecha_dev);
        CheckBox extendido = view.findViewById(R.id.extendido);


        Alquiler alquiler = alquileres.get(position);

        id_peli.setText(alquiler.getTitulo_pelicula());

        id_user.setText(alquiler.getNombre_usuario());

        fecha_alq.setText(alquiler.getFecha_alquiler());
        fecha_dev.setText(alquiler.getFecha_devolucion());
        extendido.setChecked(alquiler.isExtendido());


        return view;
    }

    public void buscaNombre(int id, VideoclubController vc) {
        vc.getUsuarioId(id, new VideoclubCallback() {
            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void alquileresIdCallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void alquileresDNICallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void directoresCallback(ArrayList<Director> direcs) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> users) {

            }

            @Override
            public void usuarioIdCallback(Usuario user) {
                nombreId = user.getNombre();


            }
        });


    }


}
