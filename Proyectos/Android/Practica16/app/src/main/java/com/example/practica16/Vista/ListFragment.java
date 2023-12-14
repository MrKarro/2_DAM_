package com.example.practica16.Vista;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.practica16.Modelo.AdaptadorPersonalizado;
import com.example.practica16.Interfaces.OnFragmentEventListener;
import com.example.practica16.Modelo.SQLHelper;
import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.R;

import java.util.ArrayList;


public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {


    OnFragmentEventListener listener;
    ListView lista;
    String orientacion;
    SQLHelper helper;
    ArrayList<Vehiculo> list;
    public ListFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new SQLHelper(getContext());


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentEventListener){
            listener = (OnFragmentEventListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);
        orientacion = "";
        lista = v.findViewById(R.id.lista);
        lista.setOnItemClickListener(this);
        list = helper.consultaVehiculos();
        if (getArguments() != null){
            list = (ArrayList<Vehiculo>) getArguments().getSerializable("lista");

            AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(getContext(), list);
            lista.setAdapter(adapter);

        }

        if (Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation){ //es vertical o portrait.
            registerForContextMenu(lista);
        }


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation) {
            listener.mandaVehiculo((Vehiculo) adapterView.getAdapter().getItem(i));
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.modif){

            DialogAdd dialog = new DialogAdd((Vehiculo) lista.getAdapter().getItem(info.position));
            dialog.show(getActivity().getSupportFragmentManager(), "Dialogo");
            helper.modificarCoche((Vehiculo) lista.getAdapter().getItem(info.position));
        } else if (item.getItemId() == R.id.elim){
            helper.borrarCoche((Vehiculo) lista.getAdapter().getItem(info.position));
            list.remove((Vehiculo) lista.getAdapter().getItem(info.position));
            AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(getContext(), list);
            lista.setAdapter(adapter);

        }

        return super.onContextItemSelected(item);
    }



}