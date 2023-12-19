package com.example.examenfragments_davidcarrosalinas.Fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.examenfragments_davidcarrosalinas.Modelo.Adaptador;
import com.example.examenfragments_davidcarrosalinas.Modelo.Libro;
import com.example.examenfragments_davidcarrosalinas.Modelo.SQLHelper;
import com.example.examenfragments_davidcarrosalinas.R;

import java.util.ArrayList;


public class ListaFragment extends Fragment implements AdapterView.OnItemClickListener {


    ListView lista;
    ArrayList<Libro> libros;
    SQLHelper helper;


    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new SQLHelper(getContext());


        libros = helper.getLibros();






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        lista = view.findViewById(R.id.lista);
        Adaptador adap = new Adaptador(getContext(), libros);
        lista.setAdapter(adap);
        lista.setOnItemClickListener(this);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            DetallesFragment detalles = new DetallesFragment();
            Bundle args = new Bundle();
            args.putSerializable("libro", (Libro) lista.getAdapter().getItem(i));
            detalles.setArguments(args);
            fragmentTransaction.replace(R.id.fragDere, detalles);
            fragmentTransaction.commit();
                    }
    }
}