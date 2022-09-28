package com.lugares_j

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lugares_j.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //DEfinición del objeto para hacer la autenticación
    private lateinit var auth : FirebaseAuth
    private lateinit var binding:  ActivityMainBinding


    //Explicar esto de entrada en semana 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

    }
}