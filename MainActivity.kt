package com.nazim.telecom

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(32, 32, 32, 32)
        layout.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "ناظم لتليكوم"
        title.textSize = 30f
        title.setTextColor(Color.rgb(0, 100, 60))
        title.gravity = Gravity.CENTER

        val subtitle = TextView(this)
        subtitle.text = "مرحباً بك في تطبيق ناظم لتليكوم"
        subtitle.textSize = 18f
        subtitle.setTextColor(Color.DKGRAY)
        subtitle.gravity = Gravity.CENTER

        layout.addView(title)
        layout.addView(subtitle)

        setContentView(layout)
    }
}
