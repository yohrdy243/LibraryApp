package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro

class NewLibroActivity : AppCompatActivity() {
    var rasc = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_libro)

        val nombreLibro = findViewById<TextView>(R.id.nombreLibro)
        val editorialLibro = findViewById<TextView>(R.id.editorialLibro)
        val idiomaLibro = findViewById<TextView>(R.id.idiomaLibro)
        val categoriaLibro = findViewById<TextView>(R.id.categoriaLibro)
        val ejemplarLibro = findViewById<TextView>(R.id.ejemplarLibro)
        val btnGrabarLibro = findViewById<Button>(R.id.btn_guardarLibro)

        val toast = Toast.makeText(applicationContext,"-", Toast.LENGTH_SHORT)

        btnGrabarLibro.setOnClickListener {
            rasc.grabaLibro(0,nombreLibro.text.toString(),editorialLibro.text.toString(),categoriaLibro.text.toString(),ejemplarLibro.text.toString(),idiomaLibro.text.toString(),toast)
            finish()
            val intent = Intent(context, LibroActivity::class.java)
            startActivity(intent)
        }
    }
}