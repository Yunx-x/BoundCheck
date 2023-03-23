package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testBtn = findViewById<View>(R.id.test_btn)
        val testBtn2 = findViewById<View>(R.id.test_btn2)
        val testBtn3 = findViewById<View>(R.id.test_btn3)
        val testBtn4 = findViewById<View>(R.id.test_btn4)
        val testBtn5 = findViewById<View>(R.id.test_btn5)
        val inputDrgee = findViewById<EditText>(R.id.input_draee)
        val testClearBtn = findViewById<View>(R.id.test_clear_btn)

        val testCavans = findViewById<TestCavansView>(R.id.test_cavans)
        val dragView = findViewById<DragView>(R.id.test_drag_view)
        val dragLayout = findViewById<FrameLayout>(R.id.test_drag_layout)
        dragLayout.post {
            log("Layout：${dragView.x}，${dragView.y}")
            log("LayoutWH：${dragView.width}，${dragView.height}")

            dragView.parentWidth = dragLayout.width
            dragView.parentHeight = dragLayout.height
        }

        dragView.setPointCavans(testCavans)

        testBtn3.setOnClickListener {
            dragView.setImageResource(R.drawable.test_b)
            dragView.rotation = 0f
            testCavans.reset()
        }

        testBtn4.setOnClickListener {
            dragView.setImageResource(R.drawable.test_a)
            dragView.rotation = 0f
            testCavans.reset()
        }

        testBtn5.setOnClickListener {
            dragView.setImageResource(R.drawable.a)
            dragView.rotation = 0f
            testCavans.reset()
        }

        testBtn.setOnClickListener {
            dragView.rotation = inputDrgee.text.toString().toFloat()
        }

        testBtn2.setOnClickListener {
            dragView.rotation = 0f
        }

        testClearBtn.setOnClickListener {
            testCavans.reset()
        }
    }
}