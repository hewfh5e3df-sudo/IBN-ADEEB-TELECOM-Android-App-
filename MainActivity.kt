package com.nazim.telecom

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ScrollView
import android.widget.Toast

class MainActivity : Activity() {

    private val green = Color.rgb(0, 110, 65)
    private val lightGreen = Color.rgb(232, 245, 238)
    private val dark = Color.rgb(35, 45, 40)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = green
        window.navigationBarColor = green

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(Color.rgb(247, 249, 247))

        val header = LinearLayout(this)
        header.orientation = LinearLayout.VERTICAL
        header.gravity = Gravity.CENTER
        header.setPadding(20, 30, 20, 30)
        header.setBackgroundColor(green)

        val title = TextView(this)
        title.text = "IBN ADEEB TELECOM"
        title.textSize = 25f
        title.setTextColor(Color.WHITE)
        title.gravity = Gravity.CENTER
        title.setTypeface(null, android.graphics.Typeface.BOLD)

        val subtitle = TextView(this)
        subtitle.text = "مرحباً بك في خدمات الاتصالات"
        subtitle.textSize = 17f
        subtitle.setTextColor(Color.WHITE)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 10, 0, 0)

        header.addView(title)
        header.addView(subtitle)
        root.addView(header)

        val scroll = ScrollView(this)
        val content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL
        content.setPadding(18, 20, 18, 24)

        val welcome = TextView(this)
        welcome.text = "اختر الخدمة التي تريدها"
        welcome.textSize = 21f
        welcome.setTextColor(dark)
        welcome.gravity = Gravity.RIGHT
        welcome.setPadding(0, 0, 0, 16)
        content.addView(welcome)

        addService(
            content,
            "📱  خدمات الرصيد",
            "الاستعلام عن الرصيد وشحن الحساب"
        )

        addService(
            content,
            "🌐  باقات الإنترنت",
            "التعرف على باقات الإنترنت المتاحة"
        )

        addService(
            content,
            "💳  خدمات السداد",
            "الاستعلام عن خدمات الدفع"
        )

        addService(
            content,
            "🧾  الاستعلامات",
            "معلومات الخدمات والعروض"
        )

        addService(
            content,
            "☎️  خدمة العملاء",
            "التواصل مع فريق الدعم"
        )

        val note = TextView(this)
        note.text = "IBN ADEEB TELECOM\nخدمات الاتصالات في مكان واحد"
        note.textSize = 14f
        note.setTextColor(Color.GRAY)
        note.gravity = Gravity.CENTER
        note.setPadding(0, 25, 0, 10)
        content.addView(note)

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(root)
    }

    private fun addService(
        parent: LinearLayout,
        title: String,
        description: String
    ) {
        val card = LinearLayout(this)
        card.orientation = LinearLayout.VERTICAL
        card.setPadding(18, 16, 18, 16)
        card.setBackgroundColor(Color.WHITE)
        card.elevation = 3f

        val heading = TextView(this)
        heading.text = title
        heading.textSize = 19f
        heading.setTextColor(green)
        heading.gravity = Gravity.RIGHT

        val details = TextView(this)
        details.text = description
        details.textSize = 14f
        details.setTextColor(dark)
        details.gravity = Gravity.RIGHT
        details.setPadding(0, 8, 0, 0)

        card.addView(heading)
        card.addView(details)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 0, 0, 14)

        card.isClickable = true
        card.isFocusable = true

        card.setOnClickListener {
            Toast.makeText(
                this,
                "هذه الخدمة تحتاج إلى الربط بالنظام الخاص بها",
                Toast.LENGTH_SHORT
            ).show()
        }

        parent.addView(card, params)
    }
}
