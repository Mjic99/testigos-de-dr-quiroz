package com.example.contactatrabajador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var bd : BaseDeDatos = FirestoreBD
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        salir.setOnClickListener {
            bd.salir()
            startActivity(Intent(this, AutentificacionNumero::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        if (bd.retornarUsuario() == null) {
            startActivity(Intent(this, AutentificacionNumero::class.java))
        }
        var trabajador : TrabajadorPrueba= TrabajadorPrueba
        numeroView.setText(trabajador.data.numero.toString())
        nombreView.setText(trabajador.data.nombre)
        dniView.setText(trabajador.data.documento)
        especialidadView.setText(trabajador.data.trabajosOfrecidos.nodeAtIndex(0)?.value)
    }
}

