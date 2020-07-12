package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante

class NewEstudianteActivity : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_estudiante)

        val nombres = findViewById<EditText>(R.id.nombres)
        val apellidos = findViewById<EditText>(R.id.apellidos)
        val carrera = findViewById<EditText>(R.id.carrera)
        val correo = findViewById<EditText>(R.id.correo)

        val btnGuardarEstudiante = findViewById<Button>(R.id.btn_guardarEstudiante)

        btnGuardarEstudiante.setOnClickListener {
            
        }
    }
}