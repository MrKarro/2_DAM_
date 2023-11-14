package com.example.practica11_b;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Usuario> usuarios;
    ListView lista;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuarios = Usuario.nuevosUsuarios(5);
        lista = findViewById(R.id.lista);
        registerForContextMenu(lista);

        AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, usuarios);
        lista.setAdapter(adap);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                if (result.getData().getSerializableExtra("nuevo") != null) {
                                    Usuario u = (Usuario) result.getData().getSerializableExtra("nuevo");
                                    usuarios.add(u);
                                }
                                if (result.getData().getSerializableExtra("modificado") != null) {
                                    Usuario u = (Usuario) result.getData().getSerializableExtra("modificado");
                                    int posicion = result.getData().getIntExtra("posicion", -1);

                                    if (posicion == -1){
                                        Toast.makeText(MainActivity.this, "No ha llegado entero", Toast.LENGTH_SHORT).show();
                                    }else {
                                        usuarios.set(posicion, u);
                                    }

                                }
                                AdaptadorPersonalizado adap = new AdaptadorPersonalizado(getApplicationContext(), usuarios);

                                lista.setAdapter(adap);



                            }
                        }
                    }
                });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add){
            Intent intent = new Intent(this, AddActivity.class);


            launcher.launch(intent);

        } else if (item.getItemId() == R.id.restablecer){
            usuarios.clear();
            AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, usuarios);
            lista.setAdapter(adap);

        }

        return super.onOptionsItemSelected(item);
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

            Intent intent = new Intent(this, VisualizarActivity.class);
            intent.putExtra("usuario", usuarios.get(info.position));

            startActivity(intent);

        } else if (item.getItemId() == R.id.eliminar){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            usuarios.remove(info.position);
            AdaptadorPersonalizado adap = new AdaptadorPersonalizado(this, usuarios);
            lista.setAdapter(adap);


        } else if (item.getItemId() == R.id.modificar){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Intent intent = new Intent(this, AddActivity.class);
            intent.putExtra("usuario", usuarios.get(info.position));
            intent.putExtra("posicion", info.position);

            launcher.launch(intent);

        }


        return super.onContextItemSelected(item);
    }
}