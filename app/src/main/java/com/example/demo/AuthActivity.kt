package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Analytics Event - Evento de google analitics para saber cuando pasan por este layout
        val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        //Setup - funcion que llama la logica de la autenticacion
        setup()
    }

    private fun setup() {
        title="Autenticacion"
        signUpButton.setOnClickListener {
            if(emailEditText.text.isNotEmpty() == true && passwordEditText.text.isNotEmpty() == true){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailEditText.text.toString(),passwordEditText.text.toString()).addOnCompleteListener(){

                    if(it.isSuccessful){
                        showHome(it.result?.user?.email ?:"",ProviderType.BASIC_TYPE)
                    }else{
                        AlertError()
                    }
                }

            }
        }

        loginUpButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() == true && passwordEditText.text.isNotEmpty() == true){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString(),passwordEditText.text.toString()).addOnCompleteListener(){

                    if(it.isSuccessful){
                        showHome(it.result?.user?.email ?:"",ProviderType.BASIC_TYPE)
                    }else{
                        AlertError()
                    }
                }

            }
        }
    }

    private fun AlertError(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se genero un error al autenticar su usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String , provider:ProviderType){

        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }


























}