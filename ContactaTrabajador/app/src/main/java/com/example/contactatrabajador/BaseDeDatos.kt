package com.example.contactatrabajador

import android.app.Activity
import com.google.firebase.firestore.DocumentSnapshot

interface BaseDeDatos {
    fun conectar()
    fun obtener(ubicacion : String) : DocumentSnapshot?
    fun enviar(hashMap : HashMap<String, Any>, ubicacion : String)
    fun reemplazar()
    fun escuchar()
    fun ingresar(valor : String? =  null, activity : Activity? = null)
    fun salir()
    fun registrar()
    fun retornarUsuario() : Any?

}