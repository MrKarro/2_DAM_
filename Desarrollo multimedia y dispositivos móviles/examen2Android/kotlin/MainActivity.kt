package com.example.recuandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var insertar: Button
    private lateinit var mostrar: Button
    private lateinit var buscar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertar = findViewById(R.id.insertar)
        mostrar = findViewById(R.id.mostrar)
        buscar = findViewById(R.id.buscar)

        insertar.setOnClickListener(this)
        mostrar.setOnClickListener(this)
        buscar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var intent: Intent? = null
        when (v.id) {
            R.id.insertar -> intent = Intent(this, InsertarActivity::class.java)
            R.id.mostrar -> intent = Intent(this, MostrarActivity::class.java)
            R.id.buscar -> intent = Intent(this, BuscarActivity::class.java)
        }
        intent?.let { startActivity(it) }
    }
}