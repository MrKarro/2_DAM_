package com.example.proyecto_final_dcs.Interfaces;

import com.example.proyecto_final_dcs.Modelo.Alquiler;
import com.example.proyecto_final_dcs.Modelo.Director;
import com.example.proyecto_final_dcs.Modelo.Pelicula;
import com.example.proyecto_final_dcs.Modelo.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;


public interface VideoclubDAO {
    @POST("crearUsuario.php")
    public Call<Usuario> createUsuario(@Body Usuario user);

    @GET("getUsuario.php")
    public Call<Usuario> getUsuario(@Query("login") String login);

    @GET("getUsuarios.php")
    public Call<List<Usuario>> getUsuarios();

    @POST("crearDirector.php")
    public Call<Director> createDirector(@Body Director direc);

    @GET("getDirector.php")
    public Call<Director> getDirector(@Query("nombre") String nombre);

    @GET("getDirectores.php")
    public Call<List<Director>> getDirectores();

    @POST("crearPelicula.php")
    public Call<Pelicula> createPelicula(@Body Pelicula peli);

    @GET("getPelicula.php")
    public Call<Pelicula> getPelicula(@Query("titulo") String titulo);

    @GET("getPeliculas.php")
    public Call<List<Pelicula>> getPeliculas();

    @POST("crearAlquiler.php")
    public Call<Alquiler> createAlquiler(@Body Alquiler alq);

    @GET("getAlquiler.php")
    public Call<Alquiler> getAlquiler(@Query("id_usuario") int id);

    @GET("getAlquileres.php")
    public Call<List<Alquiler>> getAlquileres();

}
