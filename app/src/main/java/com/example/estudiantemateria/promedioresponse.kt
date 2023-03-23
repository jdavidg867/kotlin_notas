package com.example.estudiantemateria

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class promedioresponse : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiantesmateriaresponse)

        val campoMensaje=findViewById<TextView>(R.id.textMensaje)

        var miBundle: Bundle? = this.intent.extras

        if (miBundle != null){
            campoMensaje.text="${miBundle.getString("Promedionotas")}"
        }

        val botonSalir:Button=findViewById(R.id.btnSalir)
        botonSalir.setOnClickListener { onClick() }

    }

    private fun onClick() {
        finish()
    }
}