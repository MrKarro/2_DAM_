package com.example.practica15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, OnFragmentEventListener {

    Spinner lista;
    Button datos, foto;
    TextView delegado;
    Alumno a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);

        datos = findViewById(R.id.datos);
        foto = findViewById(R.id.foto);
        delegado = findViewById(R.id.delegado);
        datos.setOnClickListener(this);
        foto.setOnClickListener(this);

        ArrayAdapter adapt = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Alumno.aleat(10));

        lista.setAdapter(adapt);
        lista.setOnItemSelectedListener(this);
        a = (Alumno) lista.getAdapter().getItem(0);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.datos){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            BlankFragment frag = new BlankFragment(a);

            fragmentTransaction.replace(R.id.frag, frag);
            fragmentTransaction.commit();
        } else if (view.getId() == R.id.foto){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            BlankFragment2 frag = new BlankFragment2(a);

            fragmentTransaction.replace(R.id.frag, frag);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        a = (Alumno) lista.getAdapter().getItem(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void setDelegado(Alumno a) {
        delegado.setText(a.getNombre() + " " + a.getApellidos());
    }
}