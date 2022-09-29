package com.example.lugares_j

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lugares_j.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    //Definicion de objeto para hacer la autenticacion

    private lateinit var auth : FirebaseAuth
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btRegistro.setOnClickListener { haceRegistro() }
        binding.btLogin.setOnClickListener { haceLogin() }
    }

    private fun haceRegistro() {
        // recuperamos la informacion del usuario
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        //se llama a la funcion para crear un usuario en firebase (correo/contraseña)
        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this){ task ->
                var user: FirebaseUser? = null

                if(task.isSuccessful){ //si pudo crear el usuario
                    Log.d("Autenticando","usuario creado")
                    user = auth.currentUser // aqui recupero la info del usuario creado

                }else {
                    Log.d("Autenticando","Error creando usuario")
                }
                actualiza(user)

            }
    }

    private fun haceLogin() {
        // recuperamos la informacion del usuario
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        //se llama a la funcion para crear un usuario en firebase (correo/contraseña)
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this){ task ->
                var user: FirebaseUser? = null

                if(task.isSuccessful){ //si pudo crear el usuario
                    Log.d("Autenticando","usuario autenticado")
                    user = auth.currentUser // aqui recupero la info del usuario creado

                }else {
                    Log.d("Autenticando","Error autenticando usuario")
                }
                actualiza(user)
        }
    }

    private fun actualiza(user: FirebaseUser?) {
        //si hay un usuerio definido se pasa a la pantalla principal (Activity)
        if(user != null){
            //se pasa a la otra pantalla
            val intent = Intent(this,Principal::class.java)
            startActivity(intent)
        }
    }

    //se ejecuta cuando el app aparezca en la pantalla
    public override fun onStart() {
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }

}