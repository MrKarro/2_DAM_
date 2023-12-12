package com.example.practica16.Vista;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.practica16.Interfaces.OnDialogEvent;
import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.R;

public class DialogAdd extends DialogFragment implements DialogInterface.OnClickListener {

    OnDialogEvent listener;
    Vehiculo add;

    EditText bastidor;
    EditText marca;
    EditText modelo;
    EditText kilometraje;
    Spinner color;
    Spinner combustible;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        add = new Vehiculo();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog, null);

        bastidor = v.findViewById(R.id.numBast);
        marca = v.findViewById(R.id.marca);
        modelo = v.findViewById(R.id.modelo);
        kilometraje = v.findViewById(R.id.kilom);
        color = v.findViewById(R.id.colores);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(getContext(), R.array.colores, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item );
        color.setAdapter(adap);
        combustible = v.findViewById(R.id.combus);
        adap = ArrayAdapter.createFromResource(getContext(), R.array.combustibles, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item );
        combustible.setAdapter(adap);



        builder.setView(v);

        builder.setTitle("Añadir vehiculo");

        builder.setPositiveButton("Añadir", this);


        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        switch (i){
            case -1:
                add.setNumBastidor(Integer.valueOf(bastidor.getText().toString()));
                add.setMarca(marca.getText().toString());
                add.setModelo(modelo.getText().toString());
                add.setKilometraje(Integer.valueOf(kilometraje.getText().toString()));
                add.setColor(color.getSelectedItem().toString());
                add.setCombustible(combustible.getSelectedItem().toString());

                listener.addVehiculo(add);
                break;

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDialogEvent){
            listener = (OnDialogEvent) getContext();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
