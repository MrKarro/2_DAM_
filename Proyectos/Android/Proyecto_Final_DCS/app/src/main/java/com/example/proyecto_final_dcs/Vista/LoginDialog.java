package com.example.proyecto_final_dcs.Vista;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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
import com.example.proyecto_final_dcs.VideoclubController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginDialog extends DialogFragment implements DialogInterface.OnClickListener {

    EditText nombre, contra, dni, nick;


    boolean add;
    VideoclubController vc = new VideoclubController();


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view;
        if (!add){
            view = inflater.inflate(R.layout.user_dialog_login, null);
            nick = view.findViewById(R.id.user);
            contra = view.findViewById(R.id.contra);
            builder.setPositiveButton("Ingresar", this);
        } else {
            view = inflater.inflate(R.layout.user_dialog_register, null);
            nick = view.findViewById(R.id.user);
            contra = view.findViewById(R.id.contra);
            nombre = view.findViewById(R.id.nombre);
            dni = view.findViewById(R.id.dni);
            builder.setPositiveButton("Añadir", this);


        }

        builder.setView(view);
        builder.setTitle("Usuario");

        builder.setNegativeButton("Cancelar", this);




        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:
                if (add){
                    Usuario user = new Usuario();
                    user.setNombre(nombre.getText().toString());
                    user.setDni(dni.getText().toString());
                    user.setLogin(nick.getText().toString());

                    user.setPassword(getMD5(contra.getText().toString()));


                    vc.createUsuario(getContext(), user);
                } else {
                    // comprobar si el usuario existe mediante el vc.getUsuario pero no se como recogerlo


                    vc.getUsuario(getContext(), nick.getText().toString(), getMD5(contra.getText().toString()));
                }


                break;
            case -2:
                Toast.makeText(getContext(), "Acción cancelada.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public VideoclubController getVc() {
        return vc;
    }

    public void setVc(VideoclubController vc) {
        this.vc = vc;
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
