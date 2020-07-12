package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante

class EstudianteActivity : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_estudiante)

        val listaEstudiante = findViewById<ListView>(R.id.lst_listaEstudiantes)
        val btnNuevoEstudiante = findViewById<FloatingActionButton>(R.id.btn_nuevoEstudiante)
        val btnEditarEstudiante = findViewById<FloatingActionButton>(R.id.btn_editEstudiante)

        rasc.listarEstudiantes(applicationContext,listaEstudiante)

        btnNuevoEstudiante.setOnClickListener {
            finish()
            val intent = Intent(applicationContext,NewEstudianteActivity::class.java)
            startActivity(intent)
        }

        btnEditarEstudiante.setOnClickListener {
            val intent = Intent(applicationContext,EditEstudianteActiviy::class.java)
            startActivity(intent)
        }

    }


}