package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.core.view.ViewCompat
import androidx.fragment.app.DialogFragment


class DebugDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        val view = inflater.inflate(R.layout.activity_main, container, false)
        return view
    }

    override fun onStart() {
        setStyle(STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        super.onStart()
        dialog?.window!!.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;//字体默认白色
        dialog?.window!!.statusBarColor = Color.TRANSPARENT//透明背景

        val decorView = dialog?.window!!.decorView
        val layout = dialog?.window!!.decorView.layoutParams as WindowManager.LayoutParams
        layout.width = WindowManager.LayoutParams.MATCH_PARENT
        layout.height = WindowManager.LayoutParams.MATCH_PARENT
        layout.y = 0
//        layout.height = Util.getScreenHeight(requireContext()) + 1000
        dialog?.window!!.decorView.layoutParams = layout
        dialog?.window!!.decorView.setBackgroundColor(Color.GREEN)
        decorView.setPadding(0, 0, 0, 0)
        dialog?.window!!.decorView.fitsSystemWindows = false
        dialog?.window!!.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        ViewCompat.requestApplyInsets(dialog?.window!!.decorView)
        dialog?.window!!.setGravity(Gravity.TOP)

        val attr = dialog?.window!!.attributes
        attr.height = WindowManager.LayoutParams.MATCH_PARENT
        attr.width = WindowManager.LayoutParams.MATCH_PARENT
        attr.gravity = Gravity.TOP
        attr.y = 0
        attr.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        attr.dimAmount = 0f
        dialog?.window!!.attributes = attr
        dialog?.window!!.attributes.debug("")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.bg_view)?.setBackgroundColor(Color.parseColor("#6F91FF"))
    }
}