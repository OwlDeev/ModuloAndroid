package com.example.demo

class Carta {

    private var idCarta:Int? = null
    private var nombre:String? = null
    private var edicion:String? = null
    private var enJuego:Boolean? = null
    private var numeroDeGambas:Int? = null

    fun Carta(idCarta:Int?, nombre:String?, edicion:String?, enJuego:Boolean?, numeroDeGambas:Int?) {
        this.idCarta = idCarta
        this.nombre = nombre
        this.edicion = edicion
        this.enJuego = enJuego
        this.numeroDeGambas = numeroDeGambas
    }


}
