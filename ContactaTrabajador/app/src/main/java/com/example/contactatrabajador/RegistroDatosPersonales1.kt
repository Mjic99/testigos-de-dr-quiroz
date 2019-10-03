package com.example.contactatrabajador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registro_datos_personales.*

class RegistroDatosPersonales1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bd : BaseDeDatos = FirestoreBD
        setContentView(R.layout.activity_registro_datos_personales)
        siguienteBoton.setOnClickListener {
            var trabajador: TrabajadorPrueba = TrabajadorPrueba
            trabajador.data.nombre = nombreText.text.toString()
            trabajador.data.documento = dniText.text.toString()
            trabajador.data.trabajosOfrecidos.append(especialidadText.text.toString())
            trabajador.data.id = bd.retornarUsuario().toString()
            trabajador.data.enviar(bd,"Trabajador_modelo/${bd.retornarUsuario()}")
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
