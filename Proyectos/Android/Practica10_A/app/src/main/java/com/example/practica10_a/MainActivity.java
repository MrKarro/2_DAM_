package com.example.practica10_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    ArrayList<Coche> coches;

    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coches = new ArrayList<Coche>();
        llenaCoches(coches);

        lista = findViewById(R.id.lista);
        AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, coches);

        lista.setAdapter(adap);
        registerForContextMenu(lista);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.detalles){
            Toast.makeText(this, "Detalles", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.eliminar){
            Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.detalles){
           // item.getMenuInfo() te da la informacion del objeto en el que se ha hecho el contexto da un objeto de AdapterView.AdapterContextMenInfo

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Coche c = (Coche) lista.getAdapter().getItem(info.position);
            Toast.makeText(this, c.toString(), Toast
                    .LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.eliminar){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            coches.remove(info.position);
            AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, coches);

            lista.setAdapter(adap);

        }
        return super.onContextItemSelected(item);
    }

    public void llenaCoches(ArrayList<Coche> coches) {

        Coche[] arrayCoches = {new Coche("Audi", "A1"), new Coche("Audi", "A3"), new Coche("Audi", "A4"), new Coche("Seat", "Toledo"), new Coche("Seat", "Ibiza"), new Coche("Seat", "Leon"), new Coche("Peugeot", "207"), new Coche("Peugeot", "208"), new Coche("Peugeot", "408"), new Coche("Peugeot", "3008")};

        for (Coche c : arrayCoches){
            coches.add(c);
        }


    }


}
