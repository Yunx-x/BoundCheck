package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


class BtnView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private var bgPaint:Paint?=null

    private fun init(attrs: AttributeSet?) {
        bgPaint=Paint(Paint.ANTI_ALIAS_FLAG)
        bgPaint?.color=Color.RED
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val shader: Shader = RadialGradient(
            measuredWidth.toFloat(), 0f, measuredWidth.toFloat(),
            Color.parseColor("#F43E06"),
            Color.parseColor("#FFA60F"),
            Shader.TileMode.CLAMP
        )
        paint.shader = shader
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawPaint(paint)
        super.onDraw(canvas)
    }
}