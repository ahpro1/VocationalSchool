package com.example.vocationalschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            val i=Intent(this,AddActivity::class.java)
            startActivity(i)
        }
        btnShow.setOnClickListener {
            val i=Intent(this,ShowActivity::class.java)
            startActivity(i)
        }
    }
}