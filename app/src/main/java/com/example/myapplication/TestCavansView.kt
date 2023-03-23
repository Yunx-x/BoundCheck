package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TestCavansView : View {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10f
    }

    private var pointList = mutableListOf<PointData>()

    private var rectPoint: PointData? = null
    private var rectW = 0
    private var rectH = 0

    fun drawRect(point: PointData, w: Int, h: Int) {
        rectPoint = point
        rectW = w
        rectH = h
        invalidate()
    }

    fun drawPoint(point: PointData) {
        pointList.add(point)
        invalidate()
    }

    fun reset() {
        pointList = mutableListOf()
        rectPoint = null
        invalidate()
    }

    val radius = 6f
    override fun onDraw(canvas: Canvas?) {
        if (rectPoint != null) {
            paint.color = rectPoint!!.color
            canvas?.drawRect(
                rectPoint!!.x,
                rectPoint!!.y,
                rectPoint!!.x + rectW,
                rectPoint!!.y + rectH,
                paint
            )
        }

        pointList.forEach {
            paint.color = it.color
            canvas?.drawCircle(it.x - radius / 2, it.y - radius / 2, radius, paint)
        }
    }
}