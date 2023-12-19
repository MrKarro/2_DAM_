package com.example.examenfragmentskotlin

import java.io.Serializable

class Usuario : Serializable {
    internal lateinit var user: String
    private lateinit var pass: String
    private lateinit var rol: String

    constructor (user: String, pass: String, rol: String) {
        this.user = user
        this.pass = pass
        this.rol = rol
    }

    fun getRol() : String {
        return rol;
    }

    override fun toString(): String {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", rol='" + rol + '\'' +
                '}'
    }
}