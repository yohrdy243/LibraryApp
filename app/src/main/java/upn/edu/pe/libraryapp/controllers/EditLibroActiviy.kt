package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.estudiante.ResponseApiServiceEstudiante

class EditLibroActiviy : AppCompatActivity() {
    var rasc = ResponseApiServiceEstudiante()
    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_libro_edit)


    }

}