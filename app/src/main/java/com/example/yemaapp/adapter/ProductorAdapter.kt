package com.example.yemaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.yemaapp.databinding.GridCardItemBinding
import com.example.yemaapp.models.Productor

class ProductorAdapter(private val context: Context, private var datos: ArrayList<Productor>): BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return datos[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = GridCardItemBinding.inflate(layoutInflater)
        val element = datos[p0]
        with(binding) {
            // cardImageProductor =
            cardNombreProductor.text = element.nombre
        }
        return binding.root
    }
}