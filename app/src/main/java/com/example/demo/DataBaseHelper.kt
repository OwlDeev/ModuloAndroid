package com.example.demo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context): SQLiteOpenHelper(context,CartaContract.Companion.Entrada.NAME_TABLE,null,CartaContract.Companion.VERSION) {
    companion object{
        val CREATE_CARTA_TABLE = "CREATE TABLE " + CartaContract.Companion.Entrada.NAME_TABLE +
                "(" + CartaContract.Companion.Entrada.COLUMNA_ID + " TEXT PRIMARY KEY, " +
                CartaContract.Companion.Entrada.COLUMNA_NAME + "TEXT"

        val REMOVE_CARTA_TABLE = "DROP TABLE IF EXISTS " + CartaContract.Companion.Entrada.NAME_TABLE
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_CARTA_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(REMOVE_CARTA_TABLE)
        onCreate(db)
    }

}