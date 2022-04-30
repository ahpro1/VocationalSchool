package com.example.vocationalschool

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        btnAdd2.setOnClickListener {
            if (Check(edtNameSc) && Check(edtAddress) && Check(edtPhoneNum) && Check(edtPop)) {
                val name = edtNameSc.text.toString()
                val Address = edtAddress.text.toString()
                val phone = edtPhoneNum.text.toString().toInt()
                val Pop = edtPop.text.toString().toInt()

                AddNew(name, Address, phone, Pop)



            }
        }

        btnBack.setOnClickListener {
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }


    }

    fun Check(edt: EditText): Boolean {
        if (edt.text.isEmpty()) {
            edt.setError("Empty!")

            return false
        }
        return true
    }


    fun AddNew(name: String, Address: String, phone: Int, Pop: Int) {
        val dp = DataBase(this)

        val c = ContentValues()
        c.put("NAME",name)
        c.put("ADDRESS",Address)
        c.put("PHONE",phone)
        c.put("NUMBER",Pop)

        val index=dp.ADD(c)
        if (index>0){
            Toast.makeText(this, "success Add", Toast.LENGTH_SHORT).show()

        }else
            Toast.makeText(this, "faild Add", Toast.LENGTH_SHORT).show()

    }


}