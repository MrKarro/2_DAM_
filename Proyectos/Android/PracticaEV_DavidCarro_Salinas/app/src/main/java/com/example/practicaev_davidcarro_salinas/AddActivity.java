package com.example.practicaev_davidcarro_salinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener  {


    EditText titulo, autor, paginas;
    Spinner categorias;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        titulo = findViewById(R.id.et_titulo);
        autor = findViewById(R.id.et_autor);
        paginas = findViewById(R.id.et_paginas);
        guardar = findViewById(R.id.guardar);
        categorias = findViewById(R.id.sp_categoria);
        guardar.setOnClickListener(this);

        ArrayAdapter<CharSequence> adaptCat = ArrayAdapter.createFromResource(this, R.array.categorias, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        categorias.setAdapter(adaptCat);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.guardar){
            if (categorias.getSelectedItem().toString().equals("Todos")){
                Toast.makeText(this, R.string.la_categor_a_no_puede_ser_todos, Toast.LENGTH_SHORT).show();
                return;
            } else if (!compruebaCampos()){
                Toast.makeText(this, R.string.todos_los_campos_deben_estar_rellenos, Toast.LENGTH_SHORT).show();
                return;

            } else {
                if (getIntent().getExtras() != null){
                    String tit = titulo.getText().toString();
                    String aut =  autor.getText().toString();
                    String cat = categorias.getAdapter().getItem(categorias.getSelectedItemPosition()).toString();
                    int pag = Integer.parseInt(paginas.getText().toString());

                    Libro nuevo = new Libro(tit, aut, cat, pag);
                    Intent intent = new Intent();
                    intent.putExtra("nuevo", nuevo);
                    setResult(RESULT_OK, intent);
                    finish();

                }
            }
        }
    }

    public boolean compruebaCampos(){
        if (titulo.getText().toString().isEmpty() || autor.getText().toString().isEmpty() || paginas.getText().toString().isEmpty())
            return false;
        else
            return true;
    }
}