package com.example.zapateria_david_carro_salinas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnClickListener {

    static final int CODE = 1234;

    static String[] tipos = {"Bota", "Zapato", "Sandalia", "Zapatilla"};
    Spinner spTipos;
    ListView lista;
    Button registrar;
    ArrayList<Calzado> listaCalzado = new ArrayList<Calzado>();
    ArrayList<Calzado> buffer = new ArrayList<Calzado>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTipos = findViewById(R.id.spTipos);



        spTipos.setOnItemSelectedListener(this);

        lista = findViewById(R.id.lista);
        lista.setOnItemClickListener(this);


        //listaCalzado.add(new Calzado("Bota", "Bota cuero baja", 41, "BB123"));
       // listaCalzado.add(new Calzado("Zapatilla", "Nike Air Force", 44, "NAF123"));
        
        registrar = findViewById(R.id.registrar);
        registrar.setOnClickListener(this);



        compruebaLista();


    }

    private void compruebaLista() {
        if (listaCalzado.size() >0) {
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipos);
            spTipos.setAdapter(adaptador);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Calzado c = buffer.get(i);

        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("calzado", c);
        startActivity(intent);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        actualizaLista(i);

    }

    private void actualizaLista(int i) {
        buffer.clear();

        for (int j = 0; j< listaCalzado.size(); j++){

            if (tipos[i].equals(listaCalzado.get(j).getTipo())){
                buffer.add(listaCalzado.get(j));
            }
        }
        if (buffer.size() < 1){
            Toast.makeText(this, R.string.no_hay_calzado_de_este_tipo, Toast.LENGTH_SHORT).show();
            return;
        } else {
            String[] encontrados = new String[buffer.size()];
            for (int k = 0 ; k < buffer.size(); k++) {
                encontrados[k] = buffer.get(k).getDescripción();

            }
            ArrayAdapter<String> adapLista = new ArrayAdapter<String>(this, R.layout.itemlista, encontrados);
            lista.setAdapter(adapLista);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registrar){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivityForResult(intent, CODE);

        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data) {


        if (resultCode == RESULT_OK && requestCode == CODE) {
            Calzado c = (Calzado) data.getSerializableExtra("calzado");
            listaCalzado.add(c);
        }
        compruebaLista();
        actualizaLista(spTipos.getSelectedItemPosition());


    }
}