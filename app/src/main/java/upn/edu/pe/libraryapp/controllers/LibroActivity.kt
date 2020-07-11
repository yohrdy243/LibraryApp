package upn.edu.pe.libraryapp.controllers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro

class LibroActivity: AppCompatActivity() {
    var rasc = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_libro)

        val listaLibros = findViewById<ListView>(R.id.lst_listaLibro)

        rasc.listarLibros(applicationContext,listaLibros)
    }
}