package com.example.proyecto_final_dcs.Interfaces;

import com.example.proyecto_final_dcs.Modelo.*;

import java.util.ArrayList;

public interface VideoclubCallback {
    public void peliculasCallback(ArrayList<Pelicula> pelis);
    public void alquileresCallback(ArrayList<Alquiler> alqs);
    public void alquileresIdCallback(ArrayList<Alquiler> alqs);
    public void alquileresDNICallback(ArrayList<Alquiler> alqs);
    public void directoresCallback(ArrayList<Director> direcs);
    public void usuariosCallback(ArrayList<Usuario> users);
    public void usuarioIdCallback(Usuario user);


}
