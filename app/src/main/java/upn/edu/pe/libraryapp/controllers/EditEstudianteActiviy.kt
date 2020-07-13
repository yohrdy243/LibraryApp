package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.form_estudiante.*
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Estudiante
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante

class EditEstudianteActiviy : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_estudiante_edit)

        val idEstudiante = findViewById<EditText>(R.id.edit_idEstudiante)
        val btnBuscarEstudiante = findViewById<Button>(R.id.btn_editar_buscarEstudiante)
        val btnEliminarEstudiante = findViewById<Button>(R.id.btn_eliminarEstudiante)
        val btnEditarEstudiante = findViewById<Button>(R.id.btn_editarEstudiante)

        val toast = Toast.makeText(applicationContext,"-", Toast.LENGTH_SHORT)

        var nombreEstudiante = findViewById<EditText>(R.id.edit_nombres)
        var apellidoEstudiante = findViewById<EditText>(R.id.edit_apellidos)
        var carreraEstudiante = findViewById<EditText>(R.id.edit_carrera)
        var emailEstudiante = findViewById<EditText>(R.id.edit_correo)


        btnBuscarEstudiante.setOnClickListener {
            rasc.buscarEstudiante(idEstudiante.text.toString().toInt(),nombreEstudiante,apellidoEstudiante,carreraEstudiante,emailEstudiante)
        }

        btnEliminarEstudiante.setOnClickListener {
            finish()
            rasc.eliminarEstudiante(idEstudiante.text.toString().toInt(),toast)
        }
        btnEditarEstudiante.setOnClickListener {
            finish()
            val estudiante:Estudiante = Estudiante(idEstudiante.text.toString().toInt(),apellidoEstudiante.text.toString(),nombreEstudiante.text.toString(),carreraEstudiante.text.toString(),emailEstudiante.text.toString())
            rasc.editarEstudiante(estudiante,toast)
        }

    }
}


