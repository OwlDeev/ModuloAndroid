package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

enum class ProviderType{
    BASIC_TYPE
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Setup

        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?:"", provider ?:"")

    }

    private fun setup(email: String, provider:String){
        title = "Inicio"
        emailTextView.text = email
        providerTextView.text = provider

        loginDownButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        CollectionButton.setOnClickListener{
            val collectionIntent = Intent(this, CollectionActivity::class.java).apply {
            }
            startActivity(collectionIntent)
        }
    }
}