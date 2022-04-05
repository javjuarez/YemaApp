package com.example.yemaapp.models

import java.util.Date

data class Productor(
    var id: Int,
    var nombre: String,
    var apellidos: String,
    var email: String,
    var telefono: String,
    var genero: String, // H o M
    var fechaNac: Date,
    var experiencia: String,
    // otros
)
