package com.example.practica15;

import java.util.ArrayList;
import java.util.Random;

public class Alumno {

    private String nombre;
    private String apellidos;
    private String dni;
    private int foto;

    public Alumno(String nombre, String apellidos, String dni, int foto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public static ArrayList<Alumno> aleat(int num){
        Random aleat = new Random();
        String[] nombres = {"David", "Mía", "Alberto", "Adrián", "Victor"};
        String[] apellidos = {"Carro", "Martín", "Rodriguez", "Pérez", "García"};
        int[] fotos = {R.drawable.a0, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,R.drawable.a5,R.drawable.a6};
        String dni =String.valueOf(aleat.nextInt(89999999) + 10000000);
        ArrayList<Alumno> lista = new ArrayList<>();
        for (int i = 0; i< num; i++){
            Alumno a = new Alumno(nombres[aleat.nextInt(nombres.length)], apellidos[aleat.nextInt(apellidos.length)], dni, fotos[aleat.nextInt(fotos.length)]);
            lista.add(a);
        }
        return lista;

    }
}
