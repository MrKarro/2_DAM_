package com.example.examen2_davidcarrosalinas_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {


    ListView lista;
    ArrayList<Animal> animales;

    ArrayList<Animal> animalesPrueba;
    SQLHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        lista = findViewById(R.id.lista);
        helper = new SQLHelper(this);
        animales = helper.consultaTodo();
        animalesPrueba = new ArrayList<>();
        //Animal a = new Animal(11, "prueba", 12.0f, "Gato");
        //animalesPrueba.add(a);
        //a = new Animal(111, "prueba", 12.0f, "Perro");
        //animalesPrueba.add(a);



        registerForContextMenu(lista);

        if (getIntent().getExtras() != null){
            String anim = getIntent().getStringExtra("animal");
            Toast.makeText(this, anim, Toast.LENGTH_SHORT).show();
            actualizaLista(helper.consultaAnimal("Gato"));

        } else
            actualizaLista(animalesPrueba);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
        menu.findItem(R.id.detalles).setEnabled(false);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onResume() {
        //actualizaLista(animales);

        super.onResume();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.eliminar){
            SQLHelper helper = new SQLHelper(this);
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            helper.eliminaAnimal(animales.get(info.position));
            animales = helper.consultaTodo();
            actualizaLista(animales);
        }

        return super.onContextItemSelected(item);
    }
    public void actualizaLista(ArrayList<Animal> anima){

        MiAdpter adapt = new MiAdpter(this, anima);

        lista.setAdapter(adapt);
    }
}