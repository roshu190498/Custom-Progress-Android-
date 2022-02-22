package com.example.customprogressdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        onClickListners()
    }

    private fun onClickListners() {
        button1.setOnClickListener {
            val intent = Intent(this,SampleOne::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this,SampleTwo::class.java)
            startActivity(intent)
        }
    }

}