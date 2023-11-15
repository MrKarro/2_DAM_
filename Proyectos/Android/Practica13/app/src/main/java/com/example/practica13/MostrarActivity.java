package com.example.practica13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {


    ListView lista;
    static SQLHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        helper = new SQLHelper(this);
        lista = findViewById(R.id.lista);
        registerForContextMenu(lista);
        actualizarAdapter(helper);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.modificar){
            Alumno a = (Alumno) lista.getAdapter().getItem(info.position);
            helper.modificarAlumno(a);
            actualizarAdapter(helper);

        } else if (item.getItemId() == R.id.eliminar) {
            Alumno a = (Alumno) lista.getAdapter().getItem(info.position);
            helper.borrarAlumno(a);
            actualizarAdapter(helper);
        }

        return super.onContextItemSelected(item);
    }

    public void actualizarAdapter(SQLHelper helper){
        Cursor c = helper.consultarTodo();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        while (c.moveToNext()){

            String dni = c.getString(c.getColumnIndexOrThrow(AlumnosContract.DNI));
            String nombre = c.getString(c.getColumnIndexOrThrow(AlumnosContract.NOMBRE));
            String apellido = c.getString(c.getColumnIndexOrThrow(AlumnosContract.APELLIDOS));
            int edad = c.getInt(c.getColumnIndexOrThrow(AlumnosContract.EDAD));
            String telefono = c.getString(c.getColumnIndexOrThrow(AlumnosContract.TELEFONO));

            Alumno a = new Alumno(dni, nombre, apellido, edad, telefono);
            alumnos.add(a);
        }

        AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(this, alumnos);

        lista.setAdapter(adaptador);


    }
}