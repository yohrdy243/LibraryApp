package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro

class NewReservaActivity: AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var rasl = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_reserva)

        val listaLibros = findViewById<ListView>(R.id.lst_Libros)
        val listaEstudiantes = findViewById<ListView>(R.id.lst_Estudiantes)

        rasc.listarEstudiantes(applicationContext,listaEstudiantes)
        rasl.listarLibros(applicationContext,listaLibros)
    }
}