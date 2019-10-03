package com.example.contactatrabajador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_autentificacion_numero.*

class AutentificacionNumero : AppCompatActivity() {
    var bd  = FirestoreBD

    override fun onCreate(savedInstanceState: Bundle?) {
        bd.auth = PhoneAuthFirebase.singleton(
            fun () {
                if(bd.obtener("Trabajador_modelo/${PhoneAuthFirebase.retornarUsuario()}")==null){
                    startActivity(Intent(this, RegistroDatosPersonales1::class.java))
                }
                else{
                    startActivity(Intent(this, MainActivity::class.java))
                }
            },
            fun () {
                editText.setText(null)
                editText.setHint("Codigo de confirmacion")
                button.setText("Ingresar")
            },
            fun () {
                editText.setText(null)
                editText.setHint("Numero Celular")
                button.setText("Enviar Codigo")
            })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autentificacion_numero)
        button.setOnClickListener{
            val dato : String = editText.text.toString()
            bd.ingresar(dato, this)
        }
    }
}

