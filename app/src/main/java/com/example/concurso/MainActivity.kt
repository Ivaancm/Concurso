package com.example.concurso

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nombreUsuario(view : View) {
        val editarTexto = findViewById<EditText>(R.id.editTextTextPersonName)
        val nombre = editarTexto.text.toString()
        if(nombre != "") {
            val intent = Intent(this, SegundaPantalla::class.java).apply {
                putExtra("usuario", nombre)
            }
            startActivity(intent)
        }else {
            Toast.makeText(this, "introduce un nombre de usuario por favor",
            Toast.LENGTH_SHORT).show()
        }
    }
}