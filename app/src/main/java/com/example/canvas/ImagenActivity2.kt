package com.example.canvas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImagenActivity2 : AppCompatActivity() {
    private lateinit var img2 : ImageView
    private var imagenSeleccionada: Uri?=null
    private val CODIGO = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen2)
        img2= findViewById(R.id.img2)
        var btnCarga2 : Button = findViewById(R.id.btnCargar2)
        var btnTr2: Button = findViewById(R.id.btnTr2)

        btnCarga2.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, CODIGO)
        }
        btnTr2.setOnClickListener {
            Picasso.get()
                .load(imagenSeleccionada)
                .rotate(90f)
                .into(img2)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== CODIGO && resultCode == RESULT_OK && data!=null){
            imagenSeleccionada = data.data
            Picasso.get().load(imagenSeleccionada).into(img2)

        }
    }
}