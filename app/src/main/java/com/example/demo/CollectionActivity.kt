package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.reciclerViewMazos.EditMazo
import kotlinx.android.synthetic.main.activity_collection.*

class CollectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)

        setup()
    }

    private fun setup(){

        EditMazoButton.setOnClickListener{
            val editMazoIntent = Intent(this, EditMazo::class.java).apply {
            }
            startActivity(editMazoIntent)
        }
    }
}