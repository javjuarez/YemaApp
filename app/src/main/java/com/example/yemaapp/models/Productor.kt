package com.example.yemaapp.models

import java.util.Date

data class Productor(
    var nombre: String,
    var apellidos: String,
    var email: String,
    var telefono: String,
    var genero: Genero,
    var fechaNac: Date,
    var experiencia: String,
    // otros
)
