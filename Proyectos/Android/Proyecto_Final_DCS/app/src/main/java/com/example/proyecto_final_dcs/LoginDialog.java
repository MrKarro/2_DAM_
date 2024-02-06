package com.example.proyecto_final_dcs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class LoginDialog extends DialogFragment implements DialogInterface.OnClickListener {

    EditText nombre, contra;
    Button enviar;
    OnDialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.user_dialog, null);

        nombre = view.findViewById(R.id.user);
        contra = view.findViewById(R.id.contra);
        enviar = view.findViewById(R.id.enviar);

        builder.setView(view);
        builder.setTitle("Insertar user");
        builder.setPositiveButton("Añadir", this);
        builder.setNegativeButton("Cancelar", this);




        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:


                break;
            case -2:
                Toast.makeText(getContext(), "Acción cancelada.", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDialogListener){
            listener = (OnDialogListener) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
