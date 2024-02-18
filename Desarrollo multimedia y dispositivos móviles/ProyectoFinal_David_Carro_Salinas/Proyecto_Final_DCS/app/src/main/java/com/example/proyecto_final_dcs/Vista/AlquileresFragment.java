package com.example.proyecto_final_dcs.Vista;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyecto_final_dcs.Actividades.MainActivity2;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.AlquilerListAdapter;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.R;
import com.example.proyecto_final_dcs.Modelo.VideoclubController;
import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class AlquileresFragment extends Fragment implements View.OnClickListener {

    private ListView listView;
    private EditText dni;
    private VideoclubController vc;
    ArrayList<Alquiler> alqs = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    Usuario user = MainActivity2.getUser();
    Button filtrar;

    public AlquileresFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alquileres, container, false);

        listView = view.findViewById(R.id.listView);
        registerForContextMenu(listView);
        dni = view.findViewById(R.id.dni);
        vc = new VideoclubController();
        filtrar = view.findViewById(R.id.botFiltrar);
        filtrar.setOnClickListener(this);

        CompletableFuture<Void> directoresFuture = CompletableFuture.runAsync(() -> rellenaAlquileres(vc));

        CompletableFuture<Void> peliculasFuture = CompletableFuture.runAsync(() -> rellenaUsuarios(vc));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(directoresFuture, peliculasFuture);
        allFutures.thenRun(() -> {
        });
        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getActivity().getMenuInflater();

        inflater.inflate(R.menu.menu_contextual_trab_alqui, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.eliminar){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Alquiler borrar = alqs.get(info.position);

            vc.eliminarAlquiler(borrar.getId_pelicula(), borrar.getId_usuario());
        }

        return super.onContextItemSelected(item);
    }

    private void rellenaAlquileres(VideoclubController vc) {
        vc.getAlquileres(new VideoclubCallback() {
            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alquileres) {

                alqs = alquileres;
                AlquilerListAdapter adapter = new AlquilerListAdapter(getContext(), alqs);
                listView.setAdapter(adapter);


            }

            @Override
            public void alquileresIdCallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void alquileresDNICallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void directoresCallback(ArrayList<Director> direcs) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> users) {

            }

            @Override
            public void usuarioIdCallback(Usuario user) {

            }

        });
    }

    private void rellenaUsuarios(VideoclubController vc) {
        vc.getUsuarios(new VideoclubCallback() {
            @Override
            public void peliculasCallback(ArrayList<Pelicula> pelis) {

            }

            @Override
            public void alquileresCallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void alquileresIdCallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void alquileresDNICallback(ArrayList<Alquiler> alqs) {

            }

            @Override
            public void directoresCallback(ArrayList<Director> direcs) {

            }

            @Override
            public void usuariosCallback(ArrayList<Usuario> users) {

                       usuarios = users;

            }

            @Override
            public void usuarioIdCallback(Usuario user) {

            }

        });
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botFiltrar){
            vc.getAlquileresDNI(getContext(), dni.getText().toString(), listView);
        }
    }
}
