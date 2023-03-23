package com.example.estudiantemateria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular:Button= findViewById(R.id.btncalcular)
        botonCalcular.setOnClickListener { realizarCalculo() }

    }

    private fun realizarCalculo() {

        val Nombre:EditText = findViewById(R.id.idNombreText)
        val Materia:EditText = findViewById(R.id.idNombreMateriaText)
        val Nota1:EditText = findViewById(R.id.idMateria1Text)
        val Nota2:EditText = findViewById(R.id.idMateria2Text)
        val Nota3:EditText = findViewById(R.id.idMateria3Text)
        val Resultado:TextView = findViewById(R.id.txtMensaje1)

        val nombre:String = Nombre.text.toString()
        val materia:String = Materia.text.toString()
        val nota1:Double = Nota1.text.toString().toDouble()
        val nota2:Double = Nota2.text.toString().toDouble()
        val nota3:Double = Nota3.text.toString().toDouble()

        var promedio:Double=(nota1+nota2+nota3)/3

        var message=""

        if (promedio>=3.5){
            message=" Estudiante: $nombre \n Materia: $materia \n Nota 1: $nota1 \n Nota 2: $nota2 \n Nota 3: $nota3 \n " +
                    "Ganó con una nota de: $promedio"
            Resultado.setTextColor(Color.GREEN)

        }else{
            message=" Estudiante: $nombre \n Materia: $materia \n Nota 1: $nota1 \n Nota 2: $nota2 \n Nota 3: $nota3 \n " +
                    "Perdió con una nota de: $promedio"
            Resultado.setTextColor(Color.RED)
        }

        Resultado.text=message

        //Mostrar en otra pantalla
        val intent = Intent(this,promedioresponse::class.java)

        val miBundle:Bundle = Bundle()
        miBundle.putString("Promedionotas",Resultado!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
        }
    }