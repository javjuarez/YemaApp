package com.example.yemaapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.yemaapp.databinding.ActivityDatosUsuarioBinding
import com.google.android.material.datepicker.MaterialDatePicker

class DatosUsuario : AppCompatActivity() {

    private lateinit var binding: ActivityDatosUsuarioBinding
    private lateinit var datePicker: MaterialDatePicker<Long>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosUsuarioBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(root)
            setSupportActionBar(appToolbar.appToolbar)
            appToolbar.appToolbar.navigationIcon =
                ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_arrow_back_24, null)
            appToolbar.appToolbar.title = "Registro Productor"

            appToolbar.appToolbar.setNavigationOnClickListener {
                startActivity(Intent(this@DatosUsuario, MainActivity::class.java))
                finish()
            }

            scrollDatosRegistro.textInputEditTextFechaNac.setOnClickListener {
                datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Fecha de nacimiento")
                    .build()
                datePicker.show(supportFragmentManager, datePicker.toString())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}