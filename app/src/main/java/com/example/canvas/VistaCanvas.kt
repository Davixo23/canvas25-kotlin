package com.example.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class VistaCanvas(context : Context) : View(context) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val pintura = Paint().apply{
            color = Color.LTGRAY
            style= Paint.Style.FILL
        }
        val pintura2 = Paint().apply{
            color = Color.BLACK
            style= Paint.Style.FILL
        }

        canvas.drawCircle(width/ 2f,
            height/2f,
            100f,pintura)
        canvas.drawRect(50f,50f,200f,200f,pintura)
        canvas.drawText("hola mundo",150f,200f,pintura2)
    }
}