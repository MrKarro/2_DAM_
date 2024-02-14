package com.example.proyecto_final_dcs.Vista;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.VideoclubController;

import java.util.ArrayList;

public class AddPeliDialog extends DialogFragment implements DialogInterface.OnClickListener {


    EditText titulo, anho;
    Spinner director;
    NumberPicker horas, minutos;
    VideoclubController vc = new VideoclubController();
    ArrayList<Director> direcs = new ArrayList<>();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        rellenaDirecs(vc);

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.addpeli_layout, null);

        titulo = view.findViewById(R.id.titulo);
        anho = view.findViewById(R.id.anho);
        director  = view.findViewById(R.id.director);
        horas  = view.findViewById(R.id.numberPicker);
        minutos  = view.findViewById(R.id.numberPicker2);
        horas.setMaxValue(15);
        minutos.setMaxValue(59);
        horas.setMinValue(0);
        minutos.setMinValue(0);


        ArrayList<String> nomDirecs = new ArrayList<>();
        for (Director d : direcs){
            nomDirecs.add(d.getNombre());
        }


        builder.setView(view);
        builder.setTitle("Usuario");
        builder.setPositiveButton("Añadir", this);
        builder.setNegativeButton("Cancelar", this);



        return builder.create();
    }

    public void rellenaDirecs(VideoclubController vc) {
        vc.getDirectores(new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

            }
            public void alquileresIdCallback(ArrayList<Alquiler> alqs){}

            @Override
            public void directoresCallback(ArrayList<Director> directores) {
                direcs = directores;
                // Actualizar el Spinner en el hilo principal de la UI
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<String> nomDirecs = new ArrayList<>();
                        for (Director d : direcs){
                            nomDirecs.add(d.getNombre());
                        }
                        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, nomDirecs);
                        director.setAdapter(adaptador);
                    }
                });


            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

        });
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:
                Pelicula peli = new Pelicula();
                peli.setTitulo(titulo.getText().toString());
                peli.setAnho(Integer.parseInt(anho.getText().toString()));
                peli.setDuracion(horas.getValue() + ":" + minutos.getValue() + ":00");
                peli.setPortada("portada.jpeg");



                for (Director d :  direcs){
                    if (d.getNombre().equals(director.getSelectedItem().toString())){
                        peli.setIdDirector(d.getIdentificador());

                    }
                }
                Log.i("pelicula: ", peli.toString());
                System.out.println(peli);
                vc.createPelicula(getContext(), peli);


                break;
            case -2:
                Toast.makeText(getContext(), "Acción cancelada.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
