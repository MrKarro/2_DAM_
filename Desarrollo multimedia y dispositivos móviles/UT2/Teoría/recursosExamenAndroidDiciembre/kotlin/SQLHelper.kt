package com.example.examenfragmentskotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLHelper (context: Context) : SQLiteOpenHelper(context, "Examen.db", null, 1) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(
            ((((("CREATE TABLE " + LibroContract.TABLE_NAME).toString() + "( "
                    + LibroContract.ID).toString() + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + LibroContract.TITULO).toString() + " TEXT NOT NULL,"
                    + LibroContract.AUTOR).toString() + " TEXT NOT NULL,"
                    + LibroContract.NUMPAGS).toString() + " INTEGER NOT NULL)"
        )
        sqLiteDatabase.execSQL(
            ((((("CREATE TABLE " + UsuarioContract.TABLE_NAME).toString() + "( "
                    + UsuarioContract.USER).toString() + " TEXT PRIMARY KEY,"
                    + UsuarioContract.PASSWORD).toString() + " TEXT NOT NULL,"
                    + UsuarioContract.ROL).toString() + " TEXT NOT NULL)")
        )

        var u = Usuario("u1", "p1", "cliente")
        var values = ContentValues()
        values.put(UsuarioContract.USER, u.getUser())
        values.put(UsuarioContract.PASSWORD, u.getPass())
        values.put(UsuarioContract.ROL, u.getRol())
        sqLiteDatabase.insert(UsuarioContract.TABLE_NAME, null, values)

        u = Usuario("u2", "p2", "cliente")
        values = ContentValues()
        values.put(UsuarioContract.USER, u.getUser())
        values.put(UsuarioContract.PASSWORD, u.getPass())
        values.put(UsuarioContract.ROL, u.getRol())
        sqLiteDatabase.insert(UsuarioContract.TABLE_NAME, null, values)

        u = Usuario("admin", "admin", "administrador")
        values = ContentValues()
        values.put(UsuarioContract.USER, u.getUser())
        values.put(UsuarioContract.PASSWORD, u.getPass())
        values.put(UsuarioContract.ROL, u.getRol())
        sqLiteDatabase.insert(UsuarioContract.TABLE_NAME, null, values)

        var l = Libro("La sombra del viento", "Carlos Ruiz Zafon", 450)
        values = ContentValues()
        values.put(LibroContract.TITULO, l.getTitulo())
        values.put(LibroContract.AUTOR, l.getAutor())
        values.put(LibroContract.NUMPAGS, l.getNumPags())
        sqLiteDatabase.insert(LibroContract.TABLE_NAME, LibroContract.ID, values)

        l = Libro("El manuscrito de piedra", "Luis García Jambrina", 270)
        values = ContentValues()
        values.put(LibroContract.TITULO, l.getTitulo())
        values.put(LibroContract.AUTOR, l.getAutor())
        values.put(LibroContract.NUMPAGS, l.getNumPags())
        sqLiteDatabase.insert(LibroContract.TABLE_NAME, LibroContract.ID, values)

        l = Libro("Todas las criaturas oscuras", "Paula Gallego ", 630)
        values = ContentValues()
        values.put(LibroContract.TITULO, l.getTitulo())
        values.put(LibroContract.AUTOR, l.getAutor())
        values.put(LibroContract.NUMPAGS, l.getNumPags())
        sqLiteDatabase.insert(LibroContract.TABLE_NAME, LibroContract.ID, values)

        l = Libro("El infierno", "Carmen Mola", 320)
        values = ContentValues()
        values.put(LibroContract.TITULO, l.getTitulo())
        values.put(LibroContract.AUTOR, l.getAutor())
        values.put(LibroContract.NUMPAGS, l.getNumPags())
        sqLiteDatabase.insert(LibroContract.TABLE_NAME, LibroContract.ID, values)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, i: Int, i1: Int) {}

    fun iniciarSesion(user: String, pass: String): Usuario? {
        val db = this.readableDatabase
        val c = db.query(
            UsuarioContract.TABLE_NAME,
            arrayOf<String>(UsuarioContract.ROL),
            (UsuarioContract.USER + " = ? AND " + UsuarioContract.PASSWORD).toString() + " = ?",
            arrayOf<String>(user, pass),
            null,
            null,
            null,
            null
        )
        return if (c.moveToNext()) {
            Usuario(user, pass, c.getString(c.getColumnIndexOrThrow(UsuarioContract.ROL)))
        } else {
            null
        }
    }

    fun insertarLibro(l: Libro) {
        val sql = writableDatabase
        val values = ContentValues()
        values.put(LibroContract.TITULO, l.getTitulo())
        values.put(LibroContract.AUTOR, l.getAutor())
        values.put(LibroContract.NUMPAGS, l.getNumPags())
        sql.insert(LibroContract.TABLE_NAME, LibroContract.ID, values)
    }

    fun getLibros(): ArrayList<Libro>? {
        val db = readableDatabase
        val c = db.query(
            LibroContract.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            LibroContract.TITULO,
            null
        )
        val libros = ArrayList<Libro>()
        while (c.moveToNext()) {
            libros.add(
                Libro(
                    c.getString(c.getColumnIndexOrThrow(LibroContract.TITULO)),
                    c.getString(c.getColumnIndexOrThrow(LibroContract.AUTOR)),
                    c.getInt(c.getColumnIndexOrThrow(LibroContract.NUMPAGS))
                )
            )
        }
        return libros
    }
}