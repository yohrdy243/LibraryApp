package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro

class LibroActivity: AppCompatActivity() {
    var rasc = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_libro)

        val listaLibros = findViewById<ListView>(R.id.lst_listaLibro)
        val btnNuevoLibro = findViewById<FloatingActionButton>(R.id.btn_nuevoLibro)
        val btnEditarLibro = findViewById<FloatingActionButton>(R.id.btn_editLibro)

        rasc.listarLibros(applicationContext,listaLibros)

        btnNuevoLibro.setOnClickListener {
            finish()
            val intent = Intent(applicationContext,NewLibroActivity::class.java)
            startActivity(intent)
        }

        btnEditarLibro.setOnClickListener {
            finish()
            val intent = Intent(applicationContext,EditLibroActiviy::class.java)
            startActivity(intent)
        }
    }
}