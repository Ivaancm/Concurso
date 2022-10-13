package com.example.concurso

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.io.OutputStreamWriter

class PantallaRespuestas : AppCompatActivity() {

    var nombree : String = ""
    var nombreElem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_respuestas)

        val nombre = intent.getStringExtra("usuario").toString()
        val eleccion1 = intent.getStringExtra("eleccion")
        val eleccion2 = intent.getStringExtra("eleccion2")
        val eleccion3 = intent.getStringExtra("eleccion3")

        val mensaje1 = "Tus respuestaas! " + nombre.toString() + " Disfruta el resultado!! :)"
        val mensaje2 = "Color: " + eleccion1.toString()
        val mensaje3 = "Estación del año: " + eleccion2.toString()
        val mensaje4 = "Género de música: " + eleccion3.toString()


        val textView4 = findViewById<TextView>(R.id.textView13).apply {
            text = mensaje1
        }
        val textview = findViewById<TextView>(R.id.textView14).apply {
            text = mensaje2
        }
        val textView20 = findViewById<TextView>(R.id.textView15).apply {
            text = mensaje3
        }
        val textView21 = findViewById<TextView>(R.id.textView16).apply {
            text = mensaje4
        }
        imagenes()
        grabar()

    }


    fun imagenes() {
        val eleccion1 = intent.getStringExtra("eleccion")
        val eleccion2 = intent.getStringExtra("eleccion2")
        val eleccion3 = intent.getStringExtra("eleccion3")
        var imagen = findViewById<ImageView>(R.id.imageView2)
        val nombreElemento = findViewById<TextView>(R.id.nombreElemento)

        if(eleccion1 == "Rojo") {
            if (eleccion2 == "Verano") {
                if (eleccion3 == "Reggaeton") {
                    imagen.setImageResource(R.drawable.fuego)
                    nombreElemento.setText("Fuego")
                    nombreElem = "Fuego"
                }
            }else if(eleccion2 == "Invierno") {
                if(eleccion3 == "Rap") {
                    imagen.setImageResource(R.drawable.agua)
                    nombreElemento.setText("Agua")
                    nombreElem = "Agua"
                }else {
                    if(eleccion3 == "Eletrónica") {
                        imagen.setImageResource(R.drawable.tierra)
                        nombreElemento.setText("Tierra")
                        nombreElem = "Tierra"
                    }
                }
            }else{
                if(eleccion3 == "rap") {
                    imagen.setImageResource(R.drawable.fuego)
                    nombreElemento.setText("Fuego")
                    nombreElem = "Fuego"
                }
                else{
                    imagen.setImageResource(R.drawable.agua)
                    nombreElemento.setText("Agua")
                    nombreElem = "Agua"
                }
            }
        }else if(eleccion1 == "Azul") {
            if (eleccion2 == "Invierno") {
                if (eleccion3 == "Rap") {
                    imagen.setImageResource(R.drawable.agua)
                    nombreElemento.setText("Agua")
                    nombreElem = "Agua"
                }
            }
        } else if(eleccion1 == "Verde") {
            if(eleccion2 == "Invierno") {
                if(eleccion3 == "Electrónica"){
                    imagen.setImageResource(R.drawable.tierra)
                    nombreElemento.setText("Tierra")
                    nombreElem = "Tierra"
                }
            }
        }

        val tv = findViewById<TextView>(R.id.nombreElemento)
        tv.setText(nombreElem)
    }

    fun reiniciar(view : View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun grabar() {
        val archivo = OutputStreamWriter(openFileOutput("datos.csv", Context.MODE_APPEND))
        val nombreElem = findViewById<TextView>(R.id.textView)
        val puntuacion = "$nombree, $nombreElem\n"
        archivo.write(puntuacion)
        archivo.flush()
    }

    fun PantallaCamara(view : View) {
        val intent = Intent(this, Camara::class.java).apply {

        }
        startActivity(intent)
    }
}