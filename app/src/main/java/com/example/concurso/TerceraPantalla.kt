package com.example.concurso

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast

class TerceraPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tercera_pantalla)
    }

    fun opciones2() : String {

        var palabra : String
        var boton = findViewById<CheckBox>(R.id.verano)
        if(boton.isChecked) {
            palabra = "Verano"
            return palabra
        } else {
            boton = findViewById<CheckBox>(R.id.invierno)
            if(boton.isChecked) {
                palabra = "Invierno"
                return palabra
            }
        }
        return ""
    }

    fun siguientePantalla(view : View) {
        var boton = findViewById<CheckBox>(R.id.verano)
        var boton2 = findViewById<CheckBox>(R.id.invierno)
        if(boton.isChecked && boton2.isChecked) {
            Toast.makeText(this, "introduce solo 1 opción", Toast.LENGTH_SHORT).show()
        } else if (!boton.isChecked && !boton2.isChecked) {
            Toast.makeText(this,"introduce una opción", Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent(this, CuartaPantalla::class.java).apply {
                val nombre = intent.getStringExtra("usuario")
                val eleccion1 = intent.getStringExtra("eleccion")
                putExtra("usuario", nombre)
                putExtra("eleccion", eleccion1)
                putExtra("eleccion2", opciones2())
            }
            startActivity(intent)
        }
    }
}