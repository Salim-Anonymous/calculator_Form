package com.example.student_registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Results : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val extras = intent.extras

        if (extras != null) {
            findViewById<TextView>(R.id.textView10).text = extras.getString("Student_ID")
            findViewById<TextView>(R.id.textView11).text = extras.getString("Name")
            findViewById<TextView>(R.id.textView12).text = extras.getString("programme")
            findViewById<TextView>(R.id.textView13).text = extras.getString("sem_name")
            findViewById<TextView>(R.id.textView14).text = extras.getString("academic_year")
            findViewById<TextView>(R.id.textView15).text = extras.getString("year")
            findViewById<TextView>(R.id.textView16).text = extras.getString("semester")

            val length = extras.getInt("length")
            var i=0
            while (i<length){
                val view = findViewById<TextView>(R.id.textView17)
                val texts = view.text
                view.text = "$texts \n"+extras.getString("$i")
                i++
            }

        }

    }
}