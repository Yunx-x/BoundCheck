package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView

class DragView : AppCompatImageView {

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        setImageResource(R.drawable.a)
        setBackgroundColor(Color.BLUE)
    }

    var parentWidth = 0
    var parentHeight = 0

    private var lastDownPoint: PointF? = null
    private var lastDownXY: PointF? = null

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastDownPoint = PointF(event.rawX, event.rawY)
                lastDownXY = PointF(event.x, event.y)
            }
            MotionEvent.ACTION_MOVE -> {
                val moveX: Float = event.rawX - lastDownPoint!!.x
                val moveY: Float = event.rawY - lastDownPoint!!.y

                val tmpAfterX = translationX + moveX
                val tmpAfterY = translationY + moveY

                val x0 = tmpAfterX + width / 2
                val y0 = tmpAfterY + height / 2

                //获取旋转后的坐标
                val p1 =
                    getLeftTopPointRaw(x0, y0, tmpAfterX, tmpAfterY)
                val p2 =
                    getLeftTopPointRaw(x0, y0, tmpAfterX + width, tmpAfterY)
                val p3 =
                    getLeftTopPointRaw(x0, y0, tmpAfterX, tmpAfterY + height)
                val p4 =
                    getLeftTopPointRaw(x0, y0, tmpAfterX + width, tmpAfterY + height)

                val l = listOf(p1, p2, p3, p4)
                val left = getLeftPoint(l)
                val top = getTopPoint(l)

                val xDiff = tmpAfterX - left.x
                val yDiff = tmpAfterY - top.y

                //view可移动的最大范围。父布局宽度-view宽度-x方向旋转后的差值
                val maxX = (parentWidth - width).toFloat() - xDiff
                //原理同X轴
                val maxY = (parentHeight - height).toFloat() - yDiff

                val positionX =
                    Math.min(
                        //X轴可移动到的最大值
                        maxX,
                        //X轴准备移动的位置。
                        Math.max(
                            xDiff,//最小为旋转坐标与原坐标的差值，保证图片不被遮挡
                            translationX + moveX//动态计算触摸移动后的位置
                        )
                    )
                val positionY =
                    Math.min(
                        //Y轴可移动到的最大值
                        maxY,
                        //Y轴准备移动的位置。
                        Math.max(
                            yDiff,//最小为旋转坐标与原坐标的差值，保证图片不被遮挡
                            translationY + moveY//动态计算触摸移动后的位置
                        )
                    )

                pointCavansView?.drawRect(
                    PointData(
                        positionX,
                        positionY,
                        Color.GREEN
                    ), width, height
                )

                pointCavansView?.drawPoint(
                    PointData(
                        positionX,
                        positionY,
                        Color.BLUE
                    )
                )

                pointCavansView?.drawPoint(
                    PointData(
                        p1.x,
                        p1.y,
                        Color.RED
                    )
                )

                translationX = positionX
                translationY = positionY

                lastDownPoint = PointF(event.rawX, event.rawY)
                lastDownXY = PointF(event.x, event.y)
            }
        }
        return true
    }

    fun getLeftPoint(pointList: List<PointF>): PointF {
        var p: PointF? = null
        pointList.forEach {
            if (p == null || it.x < p!!.x) {
                p = it
            }
        }
        return p!!
    }

    fun getTopPoint(pointList: List<PointF>): PointF {
        var p: PointF? = null
        pointList.forEach {
            if (p == null || it.y < p!!.y) {
                p = it
            }
        }
        return p!!
    }

    fun getRightPoint(pointList: List<PointF>): PointF {
        var p: PointF? = null
        pointList.forEach {
            if (p == null || it.x > p!!.x) {
                p = it
            }
        }
        return p!!
    }

    fun getBottomPoint(pointList: List<PointF>): PointF {
        var p: PointF? = null
        pointList.forEach {
            if (p == null || it.y > p!!.y) {
                p = it
            }
        }
        return p!!
    }

    /**
     * 获取旋转后的坐标。如果未旋转，返回原坐标
     */
    fun getLeftTopPointRaw(x0: Float, y0: Float, x1: Float, y1: Float): PointF {
        return if (rotation != 0f) {

            val angle = Math.PI / 180 * rotation
            log("rotation:${rotation}")
            log("Angle:${angle}")
            val newX =
                (x1 - x0) * Math.cos(angle) - (y1 - y0) * Math.sin(angle) + x0
            val newY =
                (y1 - y0) * Math.cos(angle) + (x1 - x0) * Math.sin(angle) + y0
            PointF(newX.toFloat(), newY.toFloat())
        } else {
            PointF(x1, y1)
        }
    }


    var pointCavansView: TestCavansView? = null
    fun setPointCavans(testCavans: TestCavansView) {
        pointCavansView = testCavans
    }
}