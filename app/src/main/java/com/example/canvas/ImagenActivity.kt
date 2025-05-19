package com.example.canvas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.Rotate
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class ImagenActivity : AppCompatActivity() {
    private val CODIGO =1
    private lateinit var img : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)
        val btnCargar : Button = findViewById(R.id.btnCarga)
        val btnRotar : Button = findViewById(R.id.btnTr)
        img = findViewById(R.id.img)

        btnCargar.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, CODIGO)
        }
        btnRotar.setOnClickListener {
            Glide.with(this)
                .load(img.drawable)
                .transform(MultiTransformation(
                    Rotate(180),
                    RoundedCorners(40),
                    CircleCrop()
                ))

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODIGO && resultCode == RESULT_OK  && data!=null)
        {
            val imagenSeleccionada = data.data
            Glide.with(this)
                .load(imagenSeleccionada)
                .into(img)

        }
    }
}