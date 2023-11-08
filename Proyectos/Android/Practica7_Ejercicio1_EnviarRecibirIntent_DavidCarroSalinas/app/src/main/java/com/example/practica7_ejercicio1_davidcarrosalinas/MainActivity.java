package com.example.practica7_ejercicio1_davidcarrosalinas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    static final int CODE = 1234;
    String nombre;
    EditText usuario;
    Button avanzar;
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.editTextUsuario);
        avanzar = findViewById(R.id.buttonAvanzar);
        mensaje = findViewById(R.id.mensaje);
        avanzar.setOnClickListener(this);
        usuario.addTextChangedListener(this);
        avanzar.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonAvanzar){
            Intent intent = new Intent(this, ConfirmActivity.class);
            intent.putExtra("usuario", usuario.getText().toString());
            startActivityForResult(intent, CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE && resultCode == RESULT_OK ){
            mensaje.setText(String.format(getString(R.string.resultado), nombre, data.getStringExtra("resultado")));
            usuario.setText("");
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (!usuario.getText().toString().isEmpty()){
            avanzar.setEnabled(true);
        } else
            avanzar.setEnabled(false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        nombre = usuario.getText().toString();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}