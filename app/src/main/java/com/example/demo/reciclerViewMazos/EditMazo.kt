package com.example.demo.reciclerViewMazos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.Mazo
import com.example.demo.R

class EditMazo : AppCompatActivity() {

    var listMazo: RecyclerView? = null
    var adaptador: AdaptadorCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_mazo)

        val mazos = ArrayList<Mazo>()
        mazos.add(Mazo("mazo1","Resistencia", R.drawable.boca_abajo_defensa))
        mazos.add(Mazo("mazo2","Resistencia", R.drawable.boca_abajo_defensa))
        mazos.add(Mazo("mazo3","Resistencia", R.drawable.boca_abajo_defensa))

        listMazo = findViewById(R.id.listMazo)
        //esto anade mas procesamiento al decir que tiene un tamano fijo
        listMazo?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        listMazo?.layoutManager = layoutManager

        adaptador = AdaptadorCustom(this, mazos)
        listMazo?.adapter = adaptador

    }
}