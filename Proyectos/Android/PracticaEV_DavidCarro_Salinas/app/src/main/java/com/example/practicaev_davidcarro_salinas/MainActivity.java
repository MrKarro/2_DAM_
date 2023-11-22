package com.example.practicaev_davidcarro_salinas;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner categoria;
    ListView lista;

    ActivityResultLauncher<Intent> launcher;
    ArrayList<Libro> libros;
    ArrayList<Libro> buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoria = findViewById(R.id.categoria);
        lista = findViewById(R.id.lista);
        registerForContextMenu(lista);
        libros = Biblioteca.rellenar();
        AdaptadorPersonalizado adapt = new AdaptadorPersonalizado(this, libros);

        lista.setAdapter(adapt);
        buffer = new ArrayList<>();

        ArrayAdapter<CharSequence> adaptCat = ArrayAdapter.createFromResource(this, R.array.categorias, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        categoria.setAdapter(adaptCat);
        categoria.setOnItemSelectedListener(this);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                if (result.getData().getSerializableExtra("nuevo") != null) {
                                    Libro u = (Libro) result.getData().getSerializableExtra("nuevo");
                                    libros.add(u);
                                }

                                AdaptadorPersonalizado adap = new AdaptadorPersonalizado(getApplicationContext(), libros);

                                lista.setAdapter(adap);
                            }
                        }
                    }
                });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);



        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.detalles){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            Intent intent = new Intent(this, DetallesActivity.class);
            intent.putExtra("libro", libros.get(info.position));

            startActivity(intent);

        } else if (item.getItemId() == R.id.prestar){

            if (!categoria.getSelectedItem().toString().equals("Todos")) {
                Toast.makeText(this, R.string.no_se_puede_mostrar, Toast.LENGTH_SHORT).show();

            } else {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                libros.remove(info.position);
                AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, libros);
                lista.setAdapter(adap);
            }


        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (categoria.getSelectedItem().toString().equals("Todos"))
            menu.findItem(R.id.actualizar).setEnabled(true);
        else
            menu.findItem(R.id.actualizar).setEnabled(false);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.anadir){
            Intent intent = new Intent(this, AddActivity.class);

            launcher.launch(intent);

        } else if (item.getItemId() == R.id.actualizar){
            libros = Biblioteca.rellenar();
            AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, libros);
            lista.setAdapter(adap);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        actualizaLista(i);
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void actualizaLista(int i) {
        buffer.clear();

        for (int j = 0; j< libros.size(); j++){
            if (categoria.getAdapter().getItem(i).toString().equals("Todos")){
                buffer.add(libros.get(j));
            } else if (categoria.getAdapter().getItem(i).toString().equals(libros.get(j).getCategoria())){
                buffer.add(libros.get(j));
            }
        }
        if (buffer.size() < 1){
            Toast.makeText(this, "No hay libros de esta categoria", Toast.LENGTH_SHORT).show();
            return;
        } else {

            AdaptadorPersonalizado adapLista = new AdaptadorPersonalizado(this, buffer);
            lista.setAdapter(adapLista);
        }
    }
}