package com.example.proyecto_final_dcs.Vista;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.Modelo.VideoclubController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CambiaContraDialog extends DialogFragment implements DialogInterface.OnClickListener{

    Usuario user;
    VideoclubController vc = new VideoclubController();
    EditText actual, nueva, nueva2;

    public CambiaContraDialog(Usuario user){
        this.user = user;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_contra, null);

        actual = view.findViewById(R.id.actual);
        nueva = view.findViewById(R.id.nueva);
        nueva2 = view.findViewById(R.id.nueva2);




        builder.setView(view);
        builder.setTitle("Cambiar contraseña");
        builder.setPositiveButton("Cambiar", this);
        builder.setNegativeButton("Cancelar", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:
                if (user.getPassword().equals(getMD5(actual.getText().toString())) && (nueva.getText().toString().equals(nueva2.getText().toString()))){
                    vc.cambiaContra(user.getIdentificador(), getMD5(nueva.getText().toString()), getContext());

                }


                break;
            case -2:
                Toast.makeText(getContext(), "Acción cancelada.", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public static String getMD5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest)
                hexString.append(Integer.toHexString(0xFF & aMessageDigest));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
