package com.example.examenfragmentskotlin

import android.provider.BaseColumns

class LibroContract : BaseColumns {
    companion object {
        val TABLE_NAME = "Libros"
        val ID = "id"
        val TITULO = "titulo"
        val AUTOR = "autor"
        val NUMPAGS = "paginas"
    }
}