package com.example.yemaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children
import com.example.yemaapp.databinding.ActivityDatosProductorSeleccionadoBinding

class DatosProductorSeleccionado : AppCompatActivity() {

    private lateinit var binding: ActivityDatosProductorSeleccionadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosProductorSeleccionadoBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(root)

            setSupportActionBar(appToolbar.appToolbar)
            appToolbar.appToolbar.navigationIcon =
                ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_arrow_back_24, null)
            appToolbar.appToolbar.title = "Productor Seleccionado"

            appToolbar.appToolbar.setNavigationOnClickListener {
                startActivity(Intent(this@DatosProductorSeleccionado, MainActivity::class.java))
                finish()
            }

            prepareScrollDatosProdSelect()
        }
    }

    private fun prepareScrollDatosProdSelect() {
        with(binding) {
            scrollDatosProductorSeleccionado.textViewInfo.visibility = View.GONE
            scrollDatosProductorSeleccionado.btnGuardar.visibility = View.GONE

            scrollDatosProductorSeleccionado.showImage.visibility = View.VISIBLE
            scrollDatosProductorSeleccionado.btnComprar.visibility = View.VISIBLE

            scrollDatosProductorSeleccionado.showImage.setImageResource(R.drawable.prod1)
            scrollDatosProductorSeleccionado.textInputEditTextNombre.setText("Alma")
            scrollDatosProductorSeleccionado.textInputEditTextApellidos.setText("Rodriguez Becerril")
            scrollDatosProductorSeleccionado.textInputEditTextEmail.setText("micorreo123@dominio.com")
            scrollDatosProductorSeleccionado.textInputEditTextPhone.setText("5512345678")
            scrollDatosProductorSeleccionado.radioButtonMujer.isChecked = true
            scrollDatosProductorSeleccionado.textInputEditTextFechaNac.setText("10/10/1992")
            scrollDatosProductorSeleccionado.textInputEditTextExperiencia.setText("Lorem ipsum...")

            scrollDatosProductorSeleccionado.textInputEditTextNombre.isEnabled = false
            scrollDatosProductorSeleccionado.textInputEditTextApellidos.isEnabled = false
            scrollDatosProductorSeleccionado.textInputEditTextEmail.isEnabled = false
            scrollDatosProductorSeleccionado.textInputEditTextPhone.isEnabled = false
            scrollDatosProductorSeleccionado.textInputEditTextFechaNac.isEnabled = false
            scrollDatosProductorSeleccionado.textInputEditTextExperiencia.isEnabled = false
            for (radio in scrollDatosProductorSeleccionado.radioGroupGenero.children) {
                radio.isEnabled = false
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