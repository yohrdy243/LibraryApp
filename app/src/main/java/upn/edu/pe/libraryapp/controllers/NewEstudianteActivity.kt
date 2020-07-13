package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Usuario
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante


class NewEstudianteActivity : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this
    private val user: Usuario = Usuario("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_estudiante)

        val nombres = findViewById<EditText>(R.id.nombres)
        val apellidos = findViewById<EditText>(R.id.apellidos)
        val carrera = findViewById<EditText>(R.id.carrera)
        val correo = findViewById<EditText>(R.id.correo)

        val btnGuardarEstudiante = findViewById<Button>(R.id.btn_guardarEstudiante)

        val toast = Toast.makeText(applicationContext,"-",Toast.LENGTH_SHORT)

        btnGuardarEstudiante.setOnClickListener {
            rasc.grabaEstudiante(0,apellidos.text.toString(),nombres.text.toString(),carrera.text.toString(),correo.text.toString(),toast)
            finish()
            val intent = Intent(context, EstudianteActivity::class.java)
            startActivity(intent)
        }
    }


}