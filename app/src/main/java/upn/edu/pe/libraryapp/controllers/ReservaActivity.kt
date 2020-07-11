package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.reserva.ResponseApiServiceReserva

class ReservaActivity : AppCompatActivity() {
    val rasc = ResponseApiServiceReserva()
    val context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_reserva)

        val listaReserva = findViewById<ListView>(R.id.lst_listaReserva)

        rasc.listarReserva(applicationContext,listaReserva)
    }
}