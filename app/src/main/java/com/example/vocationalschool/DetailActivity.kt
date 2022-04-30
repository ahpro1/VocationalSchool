package com.example.vocationalschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val b=intent.extras
        val name=b!!["name"].toString()
        val address=b!!["address"].toString()
        val phone=b!!["num"].toString()
        val num=b!!["pop"].toString()



        txtNameD.text=name
        txtAddressD.text=address
        txtPhoneD.text=phone
        txtPopD.text=num





        imgBack.setOnClickListener {
            val i=Intent(this,ShowActivity::class.java)
            startActivity(i)
        }
    }
}