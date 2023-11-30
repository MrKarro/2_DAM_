package com.example.practica14_tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica14_tienda.Entidades.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, pass;
    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        entrar = findViewById(R.id.entrar);

        entrar.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.entrar){
            Usuario u = new Usuario(user.getText().toString(), pass.getText().toString());
            SQLHelper helper = new SQLHelper(this);
            u = helper.consultaUser(u);
            if (u.getNombre().equals("")){
                Intent intent = new Intent(this, CatalogoActivity.class);
                intent.putExtra("usuario", u);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.no_ha_introducido_unas_credenciales_correctas, Toast.LENGTH_SHORT).show();
            }
        }
    }
}