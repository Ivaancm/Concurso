package com.example.concurso

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class SegundaPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)
    }

    fun opciones1() : String {
        var palabra : String ="hola"
        var boton = findViewById<RadioButton>(R.id.azul)

        if(boton.isChecked) {
            palabra = "Azul"
            return palabra
        }else {
            boton = findViewById<RadioButton>(R.id.rojo)
            if(boton.isChecked) {
                palabra = "Rojo"
                return palabra
            }else {
                boton = findViewById<RadioButton>(R.id.verde)
                if(boton.isChecked) {
                    palabra = "Verde"
                    return palabra
                }
            }
        }
        return " "
    }

    fun siguientePantalla(view : View) {
        val grupoRadio = findViewById<RadioGroup>(R.id.opciones)
        var id : Int = grupoRadio.checkedRadioButtonId
        if(id != -1) {
            val intent = Intent(this, TerceraPantalla::class.java).apply {
                val nombre = intent.getStringExtra("usuario")
                putExtra("usuario", nombre)
                putExtra("eleccion", opciones1())
            }
            startActivity(intent)
        }else {
            Toast.makeText(this, "no has marcado opciones", Toast.LENGTH_SHORT).show()
        }
    }

}