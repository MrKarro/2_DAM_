package com.example.proyecto_final_dcs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.proyecto_final_dcs.Interfaces.ComponentListener;
import com.example.proyecto_final_dcs.Interfaces.VideoclubCallback;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;
import com.example.proyecto_final_dcs.Vista.AlquileresFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TooManyListenersException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoclubController implements ComponentListener {
    private final VideoclubService service = new VideoclubService();
    VideoclubCallback interfaz;

    public VideoclubController(){

    }

    public void createUsuario(Context context, Usuario user){
        service.createUsuario(context, user);
    }
    public void createDirector(Context context, Director direc){
        service.createDirector(context, direc);
    }
    public void createPelicula(Context context, Pelicula peli){
        service.createPelicula(context, peli);
    }
    public void createAlquiler(Context context, Alquiler alq){
        service.createAlquiler(context, alq);
    }


    public void getUsuarios(VideoclubCallback interfaz) {
        service.getUsuarios().enqueue(

                new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Usuario>> call, @NonNull Response<List<Usuario>> response) {
                        ArrayList<Usuario> users = new ArrayList<>();
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            for (Usuario user: response.body()) {
                                users.add(user);
                                Log.d("TAG", user.toString());
                            }
                        } else {
                            Log.d("TAG", "Error");
                        }
                        interfaz.usuariosCallback(users);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Usuario>> call, @NonNull Throwable t) {
                        Log.d("Error", Objects.requireNonNull(t.getMessage()));
                    }
                }
        );
    }

    public void getUsuario(Context context, String login) {
        service.getUsuario(login).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(@NonNull Call<Usuario> call, @NonNull Response<Usuario> response) {
                Toast.makeText(context, "onresponse", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    Toast.makeText(context, "paso por if", Toast.LENGTH_SHORT).show();
                    assert response.body() != null;
                    Log.d("TAG", response.body().toString());
                    Usuario user = response.body();

                    Intent intent = new Intent(context, MainActivity2.class);
                    Bundle bun = new Bundle();
                    bun.putSerializable("user", user);
                    intent.putExtras(bun);
                    context.startActivity(intent);

                } else {
                    Log.d("TAG", "Error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Usuario> call, @NonNull Throwable t) {
                Toast.makeText(context, "onfailure", Toast.LENGTH_SHORT).show();
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }



    public void getDirectores(VideoclubCallback interfaz) {
        service.getDirectores().enqueue(
                new Callback<List<Director>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Director>> call, @NonNull Response<List<Director>> response) {
                        ArrayList<Director> dires = new ArrayList<>();
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            for (Director direc: response.body()) {
                                dires.add(direc);

                                Log.d("TAG", direc.toString());
                            }
                        } else {
                            Log.d("TAG", "Error");
                        }
                        interfaz.directoresCallback(dires);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Director>> call, @NonNull Throwable t) {
                        Log.d("Error", Objects.requireNonNull(t.getMessage()));
                    }
                }
        );
    }


    public void getDirector(String nombre) {
        service.getDirector(nombre).enqueue(new Callback<Director>() {
            @Override
            public void onResponse(@NonNull Call<Director> call, @NonNull Response<Director> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.d("TAG", response.body().toString());
                } else {
                    Log.d("TAG", "Error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Director> call, @NonNull Throwable t) {
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }


    public void getPeliculas(VideoclubCallback interfaz) {
        service.getPeliculas().enqueue(
                new Callback<List<Pelicula>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Pelicula>> call, @NonNull Response<List<Pelicula>> response) {
                        ArrayList<Pelicula> pelis = new ArrayList<>();
                        if (response.isSuccessful()) {

                            assert response.body() != null;
                            for (Pelicula peli: response.body()) {
                                pelis.add(peli);

                                Log.d("TAG", peli.toString());
                            }
                        } else {
                            Log.d("TAG", "Error");
                        }
                        interfaz.peliculasCallback(pelis);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Pelicula>> call, @NonNull Throwable t) {
                        Log.d("Error", Objects.requireNonNull(t.getMessage()));
                    }
                }
        );
    }


    public void getPelicula(String titulo) {
        service.getPelicula(titulo).enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(@NonNull Call<Pelicula> call, @NonNull Response<Pelicula> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.d("TAG", response.body().toString());
                } else {
                    Log.d("TAG", "Error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Pelicula> call, @NonNull Throwable t) {
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void getAlquileres(VideoclubCallback interfaz) {
        service.getAlquileres().enqueue(
                new Callback<List<Alquiler>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Alquiler>> call, @NonNull Response<List<Alquiler>> response) {
                        ArrayList<Alquiler> alqs = new ArrayList<>();
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            for (Alquiler alq: response.body()) {
                                alqs.add(alq);

                                Log.d("TAG", alq.toString());
                            }
                        } else {
                            Log.d("TAG", "Error");
                        }
                        interfaz.alquileresCallback(alqs);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Alquiler>> call, @NonNull Throwable t) {
                        Log.d("Error", Objects.requireNonNull(t.getMessage()));
                    }
                }
        );
    }


    public void getAlquiler(int id_usuario) {
        service.getAlquiler(id_usuario).enqueue(new Callback<Alquiler>() {
            @Override
            public void onResponse(@NonNull Call<Alquiler> call, @NonNull Response<Alquiler> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.d("TAG", response.body().toString());
                } else {
                    Log.d("TAG", "Error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Alquiler> call, @NonNull Throwable t) {
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }


    @Override
    public Usuario getUser(Usuario user) {

        return user;
    }

    public void getTodo(VideoclubCallback interfaz){
        getUsuarios(interfaz);
        getAlquileres(interfaz);
        getDirectores(interfaz);
        getPeliculas(interfaz);
    }


}
