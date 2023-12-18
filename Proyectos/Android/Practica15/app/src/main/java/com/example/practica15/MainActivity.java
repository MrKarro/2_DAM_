package com.example.practica15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, OnFragmentEventListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Spinner lista;
    Button datos, foto, dialog, date, time;
    TextView delegado;

    Alumno a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);
        dialog = findViewById(R.id.dialog);
        dialog.setOnClickListener(this);
        datos = findViewById(R.id.datos);
        foto = findViewById(R.id.foto);
        delegado = findViewById(R.id.delegado);
        datos.setOnClickListener(this);
        foto.setOnClickListener(this);

        ArrayAdapter adapt = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Alumno.aleat(10));

        lista.setAdapter(adapt);
        lista.setOnItemSelectedListener(this);
        a = (Alumno) lista.getAdapter().getItem(0);

        date = findViewById(R.id.date);
        date.setOnClickListener(this);
        time = findViewById(R.id.time);
        time.setOnClickListener(this);

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
        } else if (view.getId() == R.id.dialog){
            DialogEliminar del = new DialogEliminar();
            del.show(getSupportFragmentManager(), "Eliminar");

        } else if (view.getId() == R.id.date){
            Calendar cal = Calendar.getInstance();
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);


            DatePickerDialog datepick = new DatePickerDialog(this,  this, year, month, day);
            datepick.show();

        } else if (view.getId() == R.id.time){
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);

            TimePickerDialog time = new TimePickerDialog(this, this, hour, minute, true);
            time.show();

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


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        delegado.setText(String.format("%02d/%02d/%4d", day, month+1, year));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        delegado.setText(String.format("%02d:%02d", hour, minute));
    }
}