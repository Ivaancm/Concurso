package com.example.concurso

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class CuartaPantalla : AppCompatActivity() {

    var opciones : Spinner ?= null
    var opcion : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuarta_pantalla)

        opciones = findViewById(R.id.spinner)
        val musica = arrayOf("Seleccione genero de música", "Electrónica", "Rap", "Reggaeton")
        var adaptador: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, musica)
        opciones?.adapter = adaptador

    }

    fun siguientePantalla(view : View) {
        opcion = opciones?.selectedItem.toString()
        if(opcion == "Seleccione genero de música") {
            Toast.makeText(this, "selecciona una opción", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, PantallaRespuestas::class.java).apply {
                val nombre = intent.getStringExtra("usuario")
                val eleccion1 = intent.getStringExtra("eleccion")
                val eleccion2 = intent.getStringExtra("eleccion2")
                putExtra("usuario", nombre)
                putExtra("eleccion", eleccion1)
                putExtra("eleccion2", eleccion2)
                putExtra("eleccion3", opcion)
            }
            startActivity(intent)
        }
    }


}