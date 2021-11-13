package com.kotlinca.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val question_one : MaterialButton = findViewById(R.id.question_one)
        val question_two : MaterialButton = findViewById(R.id.question_two)

        question_one.setOnClickListener{
            val intent = Intent(this@MainActivity, QuesOne::class.java)
            startActivity(intent)
        }
        question_two.setOnClickListener{
            val intent = Intent(this@MainActivity, QuesTwo::class.java)
            startActivity(intent)
        }

    }
}