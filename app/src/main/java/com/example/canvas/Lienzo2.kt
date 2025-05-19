package com.example.canvas

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

import android.view.View

class Lienzo2(context : Context) : View(context) {
    private val pintadoOvalo= Paint().apply{
        color = Color.CYAN
        style = Paint.Style.FILL
    }
    private val pintadoBorde = Paint().apply {
        color = Color.RED
        strokeWidth = 6f
        style= Paint.Style.STROKE

    }
    private val pintadoTexto = Paint().apply {
        color = Color.MAGENTA
        textSize= 50f
        textAlign= Paint.Align.LEFT
        letterSpacing= 0.5f
    }

    private val pintadoBordeImg = Paint().apply {
        color= Color.GREEN
        style= Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // crear la instancia del trazo
        val path = Path()
        path.addOval(100f,
            100f,
            500f,
            400f,
            Path.Direction.CW )
        canvas.drawPath(path,pintadoOvalo)
        canvas.drawPath(path,pintadoBorde)
        // crear texto
        val text = "Hola Mundo"
        val text2 = "Hola Pedro"
        // inicio
        val inicio = 550f
        val inicio2 = 100f
        // posicion en el trazo
        val posicion = -20f
        val posicion2= 40f
        canvas.drawTextOnPath(text,
            path,
            inicio,
            posicion,
            pintadoTexto)
        canvas.drawTextOnPath(text2,
            path,
            inicio2,
            posicion2,pintadoTexto)
        // cargar la imagen a partir de un btimap
        //val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pedro)
        //val escaladaBitmap = Bitmap.createScaledBitmap(bitmap,
        //    400, 300, false)
        //canvas.drawBitmap(escaladaBitmap, 50f, 50f, pintadoBordeImg)



    }
}