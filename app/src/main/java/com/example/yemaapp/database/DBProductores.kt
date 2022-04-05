package com.example.yemaapp.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.yemaapp.models.Productor
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@SuppressLint("SimpleDateFormat")
class DBProductores(private val context: Context?) : DBHelper(context) {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")

    fun insertProductores(
        nombre: String,
        apellidos: String,
        email: String,
        telefono: String,
        genero: String,
        fechaNac: Date,
        experiencia: String
    ): Long {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var id: Long = 0

        try {
            val values = ContentValues()
            values.put("nombre", nombre)
            values.put("apellidos", apellidos)
            values.put("email", email)
            values.put("telefono", telefono)
            values.put("genero", genero)
            values.put("fechaNac", simpleDateFormat.format(fechaNac))
            values.put("experiencia", experiencia)
            id = db.insert(TABLE_PRODS, null, values)
        } catch (e: Exception) {

        } finally {
            db.close()
        }

        return id
    }

    fun getProductores(): ArrayList<Productor> {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        val listProductores = ArrayList<Productor>()
        var productorTmp: Productor?
        var cursorProductores: Cursor? = null

        cursorProductores = db.rawQuery("SELECT * FROM $TABLE_PRODS", null)
        if (cursorProductores.moveToFirst()) {
            do {
                productorTmp = Productor(
                    cursorProductores.getInt(0),
                    cursorProductores.getString(1),
                    cursorProductores.getString(2),
                    cursorProductores.getString(3),
                    cursorProductores.getString(4),
                    cursorProductores.getString(5),
                    simpleDateFormat.parse(cursorProductores.getString(6)) as Date,
                    cursorProductores.getString(7)
                )
                listProductores.add(productorTmp)
            } while (cursorProductores.moveToNext())
        }
        cursorProductores.close()

        return listProductores
    }

    fun getProductores(id: Int): Productor? {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        var productor: Productor? = null
        var cursorProductores: Cursor? = null

        cursorProductores = db.rawQuery("SELECT * FROM $TABLE_PRODS WHERE id = $id LIMIT 1", null)
        if (cursorProductores.moveToFirst())
            Productor(
                cursorProductores.getInt(0),
                cursorProductores.getString(1),
                cursorProductores.getString(2),
                cursorProductores.getString(3),
                cursorProductores.getString(4),
                cursorProductores.getString(5),
                simpleDateFormat.parse(cursorProductores.getString(6)) as Date,
                cursorProductores.getString(7)
            )
        cursorProductores.close()
        return productor
    }

    fun updateProductores(
        id: Int,
        nombre: String,
        apellidos: String,
        email: String,
        telefono: String,
        genero: String,
        fechaNac: Date,
        experiencia: String
    ): Boolean {
        var flagCorrecto = false
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        try {
            db.execSQL(
                "UPDATE $TABLE_PRODS " +
                        "SET nombre = '$nombre', apellidos = '$apellidos', email = '$email', " +
                        "telefono = '$telefono', genero = '$genero', " +
                        "fechaNac = '${simpleDateFormat.format(fechaNac)}', " +
                        "experiencia = '$experiencia' WHERE id = $id"
            )
            flagCorrecto = true
        } catch (e: Exception) {
        } finally {
            db.close()
        }

        return flagCorrecto
    }

    fun deleteProductores(id: Int): Boolean {
        var flagCorrecto = false
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        try {
            db.execSQL("DELETE FROM $TABLE_PRODS WHERE id = $id")
            flagCorrecto = true
        } catch (e: Exception) {
        } finally {
            db.close()
        }

        return flagCorrecto
    }

}