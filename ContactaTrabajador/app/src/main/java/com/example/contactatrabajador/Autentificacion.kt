package com.example.contactatrabajador

import android.app.Activity

interface Autentificacion {
    fun ingresar(valor : String? = null, activity : Activity? = null)
    fun salir()
    fun registrar()
    fun retornarUsuario() : Any?
}