package com.example.contactatrabajador

import com.google.firebase.firestore.model.value.ReferenceValue
import com.google.rpc.Help
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class Trabajador {
    var calificacion : Double = 0.000
    var certificados : LinkedList<String> = LinkedList()
    var chatAdmin : String = "" //clase??
    var descuentos : LinkedList<String> = LinkedList()
    var documento : String = ""
    var foto : String = ""
    var horario : LinkedList<String> = LinkedList()
    var id : String = ""
    var imagenes : LinkedList<String> = LinkedList()
    var nombre : String = ""
    var numero : Number = 0
    var serviciosRealizados : LinkedList<String> = LinkedList() //crear un enum luego
    var trabajosOfrecidos : LinkedList<String> = LinkedList()

    fun obtener(db : BaseDeDatos, ubicacion : String){
        //this = db.obtener(ubicacion)?.toObject(Trabajador::class.java)
    }

    fun enviar(db: BaseDeDatos, ubicacion : String){
        db.enviar(
            hashMapOf(
                "NOMBRE" to this.nombre,
                "DOCUMENTO" to this.documento,
                "TRABAJOSOFRECIDOS" to this.trabajosOfrecidos.toString(),
                "ID" to this.id
            ),
            ubicacion
        )
    }

}