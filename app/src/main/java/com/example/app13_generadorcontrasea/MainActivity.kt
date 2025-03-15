package com.example.app13_generadorcontrasea

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private lateinit var editTextLongitud: EditText
    private lateinit var buttonGenerar: Button
    private lateinit var textViewContraseña: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextLongitud = findViewById(R.id.editTextLongitud)
        buttonGenerar = findViewById(R.id.buttonGenerar)
        textViewContraseña = findViewById(R.id.textViewContraseña)

        buttonGenerar.setOnClickListener {
            val longitud = editTextLongitud.text.toString().toIntOrNull() ?: 8
            textViewContraseña.text = generarContraseña(longitud)
        }
    }

    private fun generarContraseña(longitud: Int): String {
        val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#\$%^&*()"
        return (1..longitud)
            .map { caracteres[Random.nextInt(caracteres.length)] }
            .joinToString("")
    }
}