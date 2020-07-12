package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Estudiante
import upn.edu.pe.libraryapp.models.entity.Libro
import upn.edu.pe.libraryapp.models.entity.Reserva
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro
import upn.edu.pe.libraryapp.services.reserva.ResponseApiServiceReserva

class NewReservaActivity: AppCompatActivity() {
    var rasr = ResponseApiServiceReserva()
    var rase = ResponseApiServiceEstudiante()
    var rasl = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_reserva)

        val listaLibros = findViewById<ListView>(R.id.lst_Libros)
        val listaEstudiantes = findViewById<ListView>(R.id.lst_Estudiantes)

        rase.listarEstudiantes(applicationContext,listaEstudiantes)
        rasl.listarLibros(applicationContext,listaLibros)

        val idEstudiante = findViewById<TextView>(R.id.idEstudiante)
        val idLibro = findViewById<TextView>(R.id.idLibro)
        val btnGrabarReserva = findViewById<Button>(R.id.btn_guardarReserva)

        val toast = Toast.makeText(applicationContext,"-", Toast.LENGTH_SHORT)

        btnGrabarReserva.setOnClickListener {
            val libro: Libro = Libro()
            libro.idLibro = idLibro.text.toString().toInt()

            val estudiante: Estudiante = Estudiante()
            estudiante.id= idEstudiante.text.toString().toInt()

            rasr.grabaReserva(0,libro,estudiante,null,toast)

            finish()
            val intent = Intent(context, ReservaActivity::class.java)
            startActivity(intent)
        }

    }
}