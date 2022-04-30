package com.example.vocationalschool

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class DataBase(context: Context) :
    SQLiteOpenHelper(context, NAME_DATA_BASE, null, VERSION_DATA_BASE) {

    companion object {
        private val NAME_DATA_BASE = "school_db"
        private val VERSION_DATA_BASE = 1
        private val TABLE_NAME = "SCHOOL_TABLE"
        private val ID = "ID"
        private val NAME = "NAME"
        private val ADDRESS = "ADDRESS"
        private val PHONE = "PHONE"
        private val NUMBER = "NUMBER"


        val createSql = "create table $TABLE_NAME($ID integer primary key autoincrement, " +
                "$NAME text , " +
                "$ADDRESS text," +
                "$PHONE integer," +
                "$NUMBER integer);"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(createSql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("drop table if exists $TABLE_NAME ; ")
        onCreate(p0)
    }


    fun ADD(data: ContentValues): Long {
        var i = 0L
        try {
            val b = writableDatabase
            i = b.insert(TABLE_NAME, null, data)
            b.close()

        } catch (e: Exception) {
            throw e.fillInStackTrace()
        }
        return i
    }


    @SuppressLint("Range")
    fun Get(): ArrayList<SchoolModel> {
        val arrayList = ArrayList<SchoolModel>()
        try {
            val p = readableDatabase
            val sql = "select * from $TABLE_NAME;"
            p.rawQuery(sql, null).use {
                it.moveToFirst()
                if (it.count != 0) {
                    do {
                        val id = it.getInt(it.getColumnIndex(ID))
                        val name = it.getString(it.getColumnIndex(NAME))
                        val address = it.getString(it.getColumnIndex(ADDRESS))
                        val phone = it.getInt(it.getColumnIndex(PHONE))
                        val number = it.getInt(it.getColumnIndex(NUMBER))
                        arrayList.add(SchoolModel(id, name, address, phone, number))
                    } while (it.moveToNext())
                }

            }
            p.close()

        } catch (e: Exception) {
            throw e.fillInStackTrace()
        }

        return arrayList
    }

    fun Delete(id: Int) {
        try {
            val b = writableDatabase
            val sql = "delete from $TABLE_NAME where $ID=$id ; "
            b.execSQL(sql)

        } catch (e: Exception) {
            throw e.fillInStackTrace()
        }
    }


    fun delete2(id: Int):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, id)
        val success = db.delete(TABLE_NAME,"$ID="+ id,null)
        db.close()
        return success
    }


}