package com.example.contactatrabajador

import java.util.*

class Servicio {
    var calificacion : Number = 0
    var chat : String = "" //clase??
    var cliente : String = ""  //clase??
    var comentario : LinkedList<String> = LinkedList()
    var costo : Number = 0
    var descripcion : String = ""
    var descuento : LinkedList<String> = LinkedList()
    var direccion : String = ""
    var estado : String = "" //crear enum luego
    var fechaInicio : Date = Date(0)
    var fechaFin : Date = Date(0)
    var id : String = ""
    var trabajador : String = ""
}