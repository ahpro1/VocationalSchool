package com.example.vocationalschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val db=DataBase(this)
        val data=db.Get()
        val myAdapter=CustomAdapter(this,data)
        myList.adapter=myAdapter
    }
}