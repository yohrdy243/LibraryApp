package upn.edu.pe.libraryapp.controllers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante

class EstudianteActivity : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_estudiante)

        val listaEstudiante = findViewById<ListView>(R.id.lst_listaEstudiantes)

        rasc.listarEstudiantes(applicationContext,listaEstudiante)

    }
}