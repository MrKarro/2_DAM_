package com.example.proyecto_final_dcs;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.proyecto_final_dcs.Interfaces.VideoclubDAO;
import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;

import java.util.List;

import retrofit2.*;

import retrofit2.converter.gson.GsonConverterFactory;

public class VideoclubService {

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/app-dcs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Métodos para usuarios
    public void createUsuario(Context context, Usuario user) {
        getRetrofit().create(VideoclubDAO.class).createUsuario(user).enqueue(
                new Callback<Usuario>() {
                    @Override
                    public void onResponse(@NonNull Call<Usuario> call, @NonNull Response<Usuario> response) {
                        Log.d("TAG", "RESPONSE: " + response);
                        Toast.makeText(context, "Usuario añadido correctamente", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Usuario> call, @NonNull Throwable t) {
                        Log.d("TAG", "Error");
                        Log.d("TAG", "ERROR: " + t.getMessage());
                        Toast.makeText(context, "Usuario no añadido", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public Call<Usuario> getUsuario(String login){
        return getRetrofit().create(VideoclubDAO.class).getUsuario(login);
    }
    public Call<List<Usuario>> getUsuarios(){
        return getRetrofit().create(VideoclubDAO.class).getUsuarios();
    }
    public void createDirector(Context context, Director direc) {
        getRetrofit().create(VideoclubDAO.class).createDirector(direc).enqueue(
                new Callback<Director>() {
                    @Override
                    public void onResponse(@NonNull Call<Director> call, @NonNull Response<Director> response) {
                        Log.d("TAG", "RESPONSE: " + response);
                        Toast.makeText(context, "Director añadido correctamente", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Director> call, @NonNull Throwable t) {
                        Log.d("TAG", "Error");
                        Log.d("TAG", "ERROR: " + t.getMessage());
                        Toast.makeText(context, "Director no añadido", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public Call<Director> getDirector(String nombre){
        return getRetrofit().create(VideoclubDAO.class).getDirector(nombre);
    }
    public Call<List<Director>> getDirectores(){
        return getRetrofit().create(VideoclubDAO.class).getDirectores();
    }

    public void createPelicula(Context context, Pelicula peli) {
        getRetrofit().create(VideoclubDAO.class).createPelicula(peli).enqueue(
                new Callback<Pelicula>() {
                    @Override
                    public void onResponse(@NonNull Call<Pelicula> call, @NonNull Response<Pelicula> response) {
                        Log.d("TAG", "RESPONSE: " + response);
                        Toast.makeText(context, "Película añadida correctamente", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Pelicula> call, @NonNull Throwable t) {
                        Log.d("TAG", "Error");
                        Log.d("TAG", "ERROR: " + t.getMessage());
                        Toast.makeText(context, "Película no añadida", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public Call<Pelicula> getPelicula(String titulo){
        return getRetrofit().create(VideoclubDAO.class).getPelicula(titulo);
    }
    public Call<List<Pelicula>> getPeliculas(){
        return getRetrofit().create(VideoclubDAO.class).getPeliculas();
    }

    public void createAlquiler(Context context, Alquiler alq) {
        getRetrofit().create(VideoclubDAO.class).createAlquiler(alq).enqueue(
                new Callback<Alquiler>() {
                    @Override
                    public void onResponse(@NonNull Call<Alquiler> call, @NonNull Response<Alquiler> response) {
                        Log.d("TAG", "RESPONSE: " + response);
                        Toast.makeText(context, "Alquiler añadido correctamente", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Alquiler> call, @NonNull Throwable t) {
                        Log.d("TAG", "Error");
                        Log.d("TAG", "ERROR: " + t.getMessage());
                        Toast.makeText(context, "Alquiler no añadido", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public Call<Alquiler> getAlquiler(int id){
        return getRetrofit().create(VideoclubDAO.class).getAlquiler(id);
    }
    public Call<List<Alquiler>> getAlquileres(){
        return getRetrofit().create(VideoclubDAO.class).getAlquileres();
    }


}
