package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import upn.edu.pe.libraryapp.R

class MenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val context: Context = this

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val linkEstudiantes = findViewById<Button>(R.id.btn_estudiantes)
        val linkLibros = findViewById<Button>(R.id.btn_libros)
        val linkReservas = findViewById<Button>(R.id.btn_reservas)

        linkEstudiantes.setOnClickListener {
            val intent = Intent(context, EstudianteActivity::class.java)
            startActivity(intent)
        }
        linkLibros.setOnClickListener {
            val intent = Intent(context, LibroActivity::class.java)
            startActivity(intent)
        }
        linkReservas.setOnClickListener {
            val intent = Intent(context, ReservaActivity::class.java)
            startActivity(intent)
        }
    }
}



