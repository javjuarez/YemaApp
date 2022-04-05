package com.example.yemaapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "productores.db"
        const val TABLE_PRODS = "productores"
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(
            "CREATE TABLE $TABLE_PRODS (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT NOT NULL, " +
                    "apellidos TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "telefono TEXT NOT NULL, " +
                    "genero VARCHAR(1) NOT NULL, " +
                    "fechaNac DATETIME NOT NULL, " +
                    "experiencia TEXT NOT NULL)"
        )
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, p1: Int, p2: Int) {
        sqLiteDatabase?.execSQL("DROP TABLE $TABLE_PRODS")
        onCreate(sqLiteDatabase)
    }
}