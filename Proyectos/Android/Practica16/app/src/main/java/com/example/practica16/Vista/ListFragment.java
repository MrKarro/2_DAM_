package com.example.practica16.Vista;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.practica16.AdaptadorPersonalizado;
import com.example.practica16.Interfaces.OnFragmentEventListener;
import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.R;

import java.util.ArrayList;


public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {


    OnFragmentEventListener listener;
    ListView lista;
    String orientacion;
    public ListFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        lista = v.findViewById(R.id.lista);
        lista.setOnItemClickListener(this);
        if (getArguments() != null){
            ArrayList<Vehiculo> list = (ArrayList<Vehiculo>) getArguments().getSerializable("lista");
            orientacion = getArguments().getString("orientacion");
            AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(getContext(), list);
            lista.setAdapter(adapter);
        }
        if (orientacion.equals("vertical")){
            registerForContextMenu(lista);
        }


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        listener.mandaVehiculo((Vehiculo) adapterView.getAdapter().getItem(i));
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.modif){

        } else if (item.getItemId() == R.id.elim){

        }

        return super.onContextItemSelected(item);
    }

}