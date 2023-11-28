package com.example.practica14_tienda.Entidades;

public class Carrito {
    private Usuario usuario;
    private Articulo articulo;
    private int cantidad;

    public Carrito(Usuario usuario, Articulo articulo, int cantidad) {
        this.usuario = usuario;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "usuario=" + usuario +
                ", articulo=" + articulo +
                ", cantidad=" + cantidad +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
