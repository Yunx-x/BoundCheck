package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View

class WShopLoadingView : View {

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }


    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val capPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    fun init(attrs: AttributeSet?) {
        //进度条
        progressPaint.strokeWidth = 40f
        progressPaint.style = Paint.Style.STROKE

        capPaint.color = Color.parseColor("#F43E06")
        capPaint.style = Paint.Style.FILL_AND_STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        //取宽高最小的那个作为长度，因为要画圆，要求宽高相等
        val minLength = Math.min(width, height)
        val shader = SweepGradient(
            minLength / 2f, minLength / 2f,
            Color.parseColor("#F43E06"),
            Color.parseColor("#FFFFFF")
        )

        progressPaint.shader = shader

        canvas?.drawArc(
            progressPaint.strokeWidth,
            progressPaint.strokeWidth,
            minLength.toFloat() - progressPaint.strokeWidth,
            minLength.toFloat() - progressPaint.strokeWidth,
            0f, -360f, false, progressPaint
        )

        canvas?.drawCircle(
            minLength.toFloat() - (progressPaint.strokeWidth),
            minLength.toFloat() / 2,
            progressPaint.strokeWidth / 2,
            capPaint
        )
    }
}