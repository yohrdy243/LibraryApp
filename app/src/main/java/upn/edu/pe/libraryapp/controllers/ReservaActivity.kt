package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.services.reserva.ResponseApiServiceReserva

class ReservaActivity : AppCompatActivity() {
    val rasc = ResponseApiServiceReserva()
    val context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_reserva)

        val listaReserva = findViewById<ListView>(R.id.lst_listaReserva)
        val btnNuevaReserva = findViewById<FloatingActionButton>(R.id.btn_nuevaReserva)
        val btnEditReserva = findViewById<FloatingActionButton>(R.id.btn_editReserva)

        rasc.listarReserva(applicationContext,listaReserva)
        btnNuevaReserva.setOnClickListener {
            finish()
            val intent = Intent(applicationContext,NewReservaActivity::class.java)
            startActivity(intent)
        }
        btnEditReserva.setOnClickListener {
            val intent = Intent(applicationContext,EditReservaActiviy::class.java)
            startActivity(intent)
        }
    }
}