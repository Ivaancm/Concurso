package com.example.concurso

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.*



open class Camara : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara)
        val btnCamara = findViewById<Button>(R.id.btnCamara)
    }



    fun abrirCamara(view : View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val extras = data?.extras
            val imageBitmap = extras!!["data"] as Bitmap?
            val fos = openFileOutput(crearNombre(), Context.MODE_APPEND)
            if (imageBitmap != null) {
                imageBitmap.compress(Bitmap.CompressFormat.JPEG,100,fos)
            }
            fos.close()
        }
    }
    fun crearNombre() : String?{
        val fecha = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        return "$fecha.jpg"
    }

    fun siguientePantalla() {

    }
}