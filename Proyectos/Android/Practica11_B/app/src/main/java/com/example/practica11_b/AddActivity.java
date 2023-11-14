package com.example.practica11_b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, apellidos, edad, dni, telefono;
    Spinner provincia;
    Button aceptar;
    Boolean recibido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nombre = findViewById(R.id.edNombre);
        apellidos = findViewById(R.id.edApellidos);
        edad = findViewById(R.id.edEdad);
        dni = findViewById(R.id.edDni);
        telefono = findViewById(R.id.edTelef);
        provincia = findViewById(R.id.provincias);
        aceptar = findViewById(R.id.aceptar);

        aceptar.setOnClickListener(this);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.provincias , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        provincia.setAdapter(adaptador);

        if (getIntent().getExtras() == null){
            aceptar.setText("Añadir");
            recibido = false;
        } else if (getIntent().getSerializableExtra("usuario") != null) {
            aceptar.setText("Modificar");
            recibido = true;
            Usuario u =(Usuario) getIntent().getSerializableExtra("usuario");

            nombre.setText(u.getNombre());
            apellidos.setText(u.getApell());
            edad.setText(String.valueOf(u.getEdad()));
            dni.setText(u.getDni());
            telefono.setText(u.getTelefono());
            provincia.setSelection(adaptador.getPosition(u.getProvincia()));

            /*
            if (u.getProvincia().equals("Salamanca")){
                provincia.setSelection(0);
            } else if (u.getProvincia().equals("Ávila")) {
                provincia.setSelection(1);
            } else if (u.getProvincia().equals("Zamora")) {
                provincia.setSelection(2);
            } else if (u.getProvincia().equals("Valladolid")) {
                provincia.setSelection(3);
            } else if (u.getProvincia().equals("León")) {
                provincia.setSelection(4);
            }
            */


        }

    }

    @Override
    public void onClick(View view) {


        String nom = nombre.getText().toString();
        String apell = apellidos.getText().toString();
        int ed = Integer.parseInt(edad.getText().toString());
        String dniOk = dni.getText().toString();
        String telef = telefono.getText().toString();
        String prov = provincia.getSelectedItem().toString();

        Usuario u = new Usuario(nom, apell, ed, dniOk, telef, prov);
        Intent intent = new Intent();
        if (!recibido) {
            intent.putExtra("nuevo", u);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            intent.putExtra("posicion", getIntent().getIntExtra("posicion", -1));
            intent.putExtra("modificado", u);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}