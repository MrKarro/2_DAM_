package com.example.practicaev_davidcarro_salinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {


    TextView titulo, autor, paginas, categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        titulo = findViewById(R.id.titulo);
        autor = findViewById(R.id.autor);
        paginas = findViewById(R.id.paginas);
        categoria = findViewById(R.id.categoria);



        if (getIntent().getExtras() != null){
            Libro u =(Libro) getIntent().getSerializableExtra("libro");

            titulo.setText(u.getTitulo());
            autor.setText(u.getAutor());
            paginas.setText(String.valueOf(u.getPaginas()));
            categoria.setText(u.getCategoria());

        }


    }
}