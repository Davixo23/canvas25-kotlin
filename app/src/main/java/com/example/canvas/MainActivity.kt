package com.example.canvas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 : Button = findViewById(R.id.btn)
        // creamos instancia de canvas preparada
        val ejemploCanvas = VistaCanvas(this)

        // agregamos el lienzo al layout principal y mostramos el dibujo
        val layout = findViewById<LinearLayout>(R.id.layout_principal)
        //layout.addView(ejemploCanvas)

        val lienzo = Lienzo2(this)
        layout.addView(lienzo)

        btn1.setOnClickListener {
            val intent = Intent(this, ImagenActivity::class.java)
            startActivity(intent)
        }
    }
}