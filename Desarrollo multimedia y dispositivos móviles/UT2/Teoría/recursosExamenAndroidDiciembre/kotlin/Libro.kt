package com.example.examenfragmentskotlin

import java.io.Serializable

class Libro(s: String, s1: String, i: Int) : Serializable {
    private var id = 0
    private lateinit var titulo: String
    private lateinit var autor: String
    private var numPags = 0

    fun Libro(titulo: String, autor: String, numPags: Int) {
        this.titulo = titulo
        this.autor = autor
        this.numPags = numPags
    }

    fun Libro(id: Int, titulo: String, autor: String, numPags: Int) {
        this.id = id
        this.titulo = titulo
        this.autor = autor
        this.numPags = numPags
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitulo(): String {
        return titulo
    }

    fun setTitulo(titulo: String) {
        this.titulo = titulo
    }

    fun getAutor(): String {
        return autor
    }

    fun setAutor(autor: String) {
        this.autor = autor
    }

    fun getNumPags(): Int {
        return numPags
    }

    fun setNumPags(numPags: Int) {
        this.numPags = numPags
    }

    override fun toString(): String {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPags=" + numPags +
                '}'
    }
}