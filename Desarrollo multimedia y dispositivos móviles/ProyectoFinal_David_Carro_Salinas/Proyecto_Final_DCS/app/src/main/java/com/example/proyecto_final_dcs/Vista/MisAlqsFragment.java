package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.Actividades.MainActivity2;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.AlquilerListAdapter;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.Modelo.VideoclubController;

import java.util.ArrayList;

public class MisAlqsFragment extends Fragment {

    ArrayList<Alquiler> alqs = new ArrayList<>();
    ListView lista;
    Usuario user;
    VideoclubController vc = new VideoclubController();


    public MisAlqsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        user = MainActivity2.getUser();

        View view = inflater.inflate(R.layout.fragment_mis_alqs, container, false);
        lista = view.findViewById(R.id.lista);
        //registerForContextMenu(lista);
        rellenaAlqs(vc, user);

        vc.getAlquilerId(getContext(), user.getIdentificador(), lista);
        return view;
    }
    private void rellenaAlqs(VideoclubController vc, Usuario user){
        vc.getAlquilerId( user.getIdentificador(), new VideoclubCallback() {

            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {


            }
            public void alquileresIdCallback(ArrayList<Alquiler> alquis){
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        alqs = alquis;

                        AlquilerListAdapter adapter = new AlquilerListAdapter(getContext(), alqs);

                        lista.setAdapter(adapter);
                    }
                });


            }

            @Override
            public void alquileresDNICallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void directoresCallback(ArrayList<Director> directores) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> usuarios) {

            }

            @Override
            public void usuarioIdCallback(Usuario user) {

            }

        });

    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getActivity().getMenuInflater();

        inflater.inflate(R.menu.menu_contextual_cli_alqui, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.extender){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Alquiler alq = alqs.get(info.position);
            Toast.makeText(getContext(), "alqid : " + alq.getIdentificador() , Toast.LENGTH_SHORT).show();
            int extendido = 1;
            vc.setExtendido(alq.getIdentificador(), extendido);
        }

        return super.onContextItemSelected(item);
    }

}