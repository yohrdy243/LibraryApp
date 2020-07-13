package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Libro
import upn.edu.pe.libraryapp.models.entity.Usuario
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante
import upn.edu.pe.libraryapp.services.libro.ResponseApiServiceLibro

class EditLibroActiviy : AppCompatActivity() {
    var rasc = ResponseApiServiceLibro()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_libro_edit)

        val btnBuscarLibro = findViewById<Button>(R.id.btn_editar_buscarLibro)
        val btnEliminarLibro = findViewById<Button>(R.id.btn_eliminarLibro)
        val btnEditarLibro = findViewById<Button>(R.id.btn_editarLibro)

        val toast = Toast.makeText(applicationContext,"-", Toast.LENGTH_SHORT)

        var idLibro = findViewById<EditText>(R.id.edit_IDLibro)
        var nombreLibro = findViewById<EditText>(R.id.edit_nombreLibro)
        var editorialLibro = findViewById<EditText>(R.id.edit_editorialLibro)
        var categoriaLibro = findViewById<EditText>(R.id.edit_categoriaLibro)
        var idiomaLibro = findViewById<EditText>(R.id.edit_idiomaLibro)
        var ejemplarLibro = findViewById<EditText>(R.id.edit_ejemplarLibro)

        btnBuscarLibro.setOnClickListener {
            rasc.buscarLibros(idLibro.text.toString().toInt(),nombreLibro,editorialLibro,categoriaLibro,ejemplarLibro,idiomaLibro)
        }
        btnEliminarLibro.setOnClickListener {
            finish()
            rasc.eliminarLibro(idLibro.text.toString().toInt(),toast)
        }
        btnEditarLibro.setOnClickListener {
            finish()
            val libro: Libro = Libro(idLibro.text.toString().toInt(),nombreLibro.text.toString(),editorialLibro.text.toString(),categoriaLibro.text.toString(),ejemplarLibro.text.toString(),idiomaLibro.text.toString())
            rasc.editarLibro(libro,toast)
        }
    }

}