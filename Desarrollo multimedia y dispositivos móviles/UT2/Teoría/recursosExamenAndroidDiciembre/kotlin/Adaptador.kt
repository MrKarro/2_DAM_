package com.example.examenfragmentskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Adaptador(private val context: Context, libros: ArrayList<Libro>) :
    ArrayAdapter<Libro>(context, R.layout.item, libros) {
    private val lista: ArrayList<Libro>

    init {
        lista = libros
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View = LayoutInflater.from(context).inflate(R.layout.item, null)
        val titulo = v.findViewById<TextView>(R.id.titulo)
        val autor = v.findViewById<TextView>(R.id.autor)
        titulo.setText(lista[position].getTitulo())
        autor.setText(lista[position].getAutor())
        return v
    }
}
