package com.example.examenfragmentskotlin

import android.provider.BaseColumns

class UsuarioContract : BaseColumns {
    companion object {
        val TABLE_NAME = "Usuarios"
        val USER = "user"
        val PASSWORD = "password"
        val ROL = "rol"
    }
}