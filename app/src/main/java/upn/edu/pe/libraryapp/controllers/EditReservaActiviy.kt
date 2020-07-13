package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro
import upn.edu.pe.libraryapp.services.reserva.ResponseApiServiceReserva

class EditReservaActiviy : AppCompatActivity() {
    var rasc = ResponseApiServiceReserva()
    var rase = ResponseApiServiceEstudiante()
    var rasl = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_reserva_edit)

        val listaLibros = findViewById<ListView>(R.id.lst_reserva_Libros)
        val listaEstudiantes = findViewById<ListView>(R.id.lst_reserva_Estudiantes)

        rase.listarEstudiantes(applicationContext,listaEstudiantes)
        rasl.listarLibros(applicationContext,listaLibros)

        val btnBuscarReserva = findViewById<Button>(R.id.btn_editar_buscarReserva)
        var idReserva = findViewById<EditText>(R.id.edit_idReserva)
        var idLibro = findViewById<EditText>(R.id.edit_reserva_idLibro)
        var idEstudiante = findViewById<EditText>(R.id.edit_reserva_idEstudiante)
        var fechaReserva = findViewById<EditText>(R.id.edit_reserva_fecha)

        btnBuscarReserva.setOnClickListener {
            rasc.buscarReserva(idReserva.text.toString().toInt(),idLibro,idEstudiante,fechaReserva)
        }

    }


}