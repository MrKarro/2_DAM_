package com.example.practica14_tienda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica14_tienda.Entidades.Articulo;
import com.example.practica14_tienda.Entidades.Carrito;
import com.example.practica14_tienda.Entidades.Usuario;

public class CatalogoActivity extends AppCompatActivity {

    ListView lista;
    TextView usuario, cantidad;
    Usuario u;
    SQLHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        lista = findViewById(R.id.lista);
        usuario = findViewById(R.id.usuario);
        cantidad = findViewById(R.id.cantidad);
        helper = new SQLHelper(this);
        registerForContextMenu(lista);
        if (getIntent().getExtras() != null){
            Usuario u =(Usuario) getIntent().getSerializableExtra("usuario");
        }



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.anadir){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Articulo a = (Articulo) lista.getAdapter().getItem(info.position);

            Carrito c = new Carrito(u, a, 1);
            if (helper.actualizaCarrito(c) == -1){
                helper.insertaCarrito(c);
            }


        }
        return super.onContextItemSelected(item);
    }
}