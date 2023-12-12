package com.example.practica15;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogEliminar extends DialogFragment implements DialogInterface.OnClickListener {

    OnDialogEvent listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


        LayoutInflater infletar = requireActivity().getLayoutInflater();
        View v = infletar.inflate(R.layout.dialog, null);
        builder.setView(v);

        builder.setTitle("adsas");
        builder.setMessage("asdas");
        builder.setPositiveButton("Eliminar", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:
                Toast.makeText(getContext(), "Eliminado", Toast.LENGTH_SHORT).show();
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
