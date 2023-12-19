package com.example.examenfragments_davidcarrosalinas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.examenfragments_davidcarrosalinas.Modelo.Libro;

public class InsertarDialog extends DialogFragment implements DialogInterface.OnClickListener {

    EditText titulo, autor, paginas;
    OnDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.insertar_dialog, null);

        titulo = view.findViewById(R.id.titulo);
        autor = view.findViewById(R.id.autor);
        paginas = view.findViewById(R.id.paginas);

        builder.setView(view);
        builder.setTitle("Insertar libro");
        builder.setPositiveButton("Añadir", this);
        builder.setNegativeButton("Cancelar", this);




        return builder.create();
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


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:
                Libro lib = new Libro (titulo.getText().toString(), autor.getText().toString(), Integer.parseInt(paginas.getText().toString()));
                listener.insertaLibro(lib);

                break;
            case -2:
                Toast.makeText(getContext(), "Libro no insertado.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        listener.actualizaLista(getResources().getConfiguration().orientation);
    }
}
