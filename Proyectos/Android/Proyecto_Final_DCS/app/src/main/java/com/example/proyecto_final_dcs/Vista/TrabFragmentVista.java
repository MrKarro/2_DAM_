package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto_final_dcs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrabFragmentVista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrabFragmentVista extends Fragment {



    public TrabFragmentVista() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trab_vista, container, false);


        return view;
    }
}