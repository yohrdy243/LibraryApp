package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante

class NewLibroActivity : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_libro)


    }
}