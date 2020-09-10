package com.example.quizapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_quiz.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class QuizActivity : AppCompatActivity() {
    private var q1point = 0
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        q1group.setOnCheckedChangeListener { group, checkedId ->
            // Get which radio button is clicked
            val clicked = q1group.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            q1point = if(checked && clicked.text == getString(R.string.q1a1)) 50
            else 0
        }
    }

    fun viewRecycle(view: View){
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submitAnswer(view: View){
        total = q1point
        if(q2a2.isChecked) total += 50
        if(q2a1.isChecked) total -= 10
        if(q2a3.isChecked) total -= 10
        val currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy"))
        if(total > 0) Toast.makeText(this, "Congratulations! You submitted on $currentDate, You achieved $total%", Toast.LENGTH_LONG).show()
        else Toast.makeText(this, "Congratulations! You submitted on $currentDate, But result is not good. Try again later", Toast.LENGTH_LONG).show()
    }

    fun resetAnswer(view: View){
//        q1group.clearCheck()
        q1a1.isChecked = false
        q1a2.isChecked = false
        q1a3.isChecked = false
        q2a1.isChecked = false
        q2a2.isChecked = false
        q2a3.isChecked = false
    }
}