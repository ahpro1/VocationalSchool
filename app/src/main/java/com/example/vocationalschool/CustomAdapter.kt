package com.example.vocationalschool

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_item.view.*

class CustomAdapter(context:Context,val  data: ArrayList<SchoolModel>) : ArrayAdapter<SchoolModel>(context,R.layout.custom_item,data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val customView=LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false)
            customView.txtItem.text=data[position].name



        customView.imgInfo.setOnClickListener {
            val i=Intent(context,DetailActivity::class.java)
            i.putExtra("name",data[position].name)
            i.putExtra("address",data[position].address)
            i.putExtra("num",data[position].phone)
            i.putExtra("pop",data[position].number)
            context.startActivity(i)


        }
        customView.imgDelete.setOnClickListener {
            val builder= AlertDialog.Builder(context)
            builder.setTitle("Title")
            builder.setMessage("هل تريد الحذف؟")
            builder.setPositiveButton("ok"){ _: DialogInterface, Int ->

                val db=DataBase(context)
                db.delete2(data[position].id)
                data.removeAt(position)
                this.notifyDataSetChanged()
                Toast.makeText(context, "record deleted", Toast.LENGTH_LONG).show()

            }
            builder.setNeutralButton("cancel"){_: DialogInterface , Int ->

            }

            val dialog=builder.create()
            dialog.show()
        }
  return customView
    }
}
