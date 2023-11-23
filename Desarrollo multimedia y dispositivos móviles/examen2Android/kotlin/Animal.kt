package com.example.recuandroidkotlin

import java.io.Serializable


class Animal(var codigo: Int, var nombre: String, var peso: Double, var tipo: String) : Serializable {

    override fun toString(): String {
        return "Animal{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", tipo='" + tipo + '\'' +
                '}'
    }
}