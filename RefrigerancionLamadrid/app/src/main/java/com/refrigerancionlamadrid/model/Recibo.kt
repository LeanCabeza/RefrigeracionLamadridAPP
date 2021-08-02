package com.refrigerancionlamadrid.model

import java.io.Serializable

data class Recibo(
     val  cliente: String?= null
    , val direccion:String?= null
    , val modeloElectrodomestico:String?= null
    , val reparacion:String?= null
    , val precio:String?= null
    , val fecha:String?= null)
    : Serializable