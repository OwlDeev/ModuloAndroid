package com.example.demo

import android.provider.BaseColumns

class CartaContract {

    companion object {

        val VERSION = 1
        class Entrada: BaseColumns {
            companion object{
                val NAME_TABLE = "Carta"
                val COLUMNA_ID = "idCarta"
                val COLUMNA_NAME = "nombre"
                val COLUMNA_EDITION = "edicion"
                val COLUMNA_INGAME = "enJuego"
                val COLUMNA_PRICEGAMBAS = "numeroDeGambas"
            }
        }
    }
}