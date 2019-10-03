package com.example.contactatrabajador

import java.util.*

class Descuento {
    var desde : Date = Date(0)
    var hasta : Date = Date(0)
    var id : String = ""
    var monto : Number = 0
    var tipo : String = "" //crear enum luego
    var veces : Number = 0
}