package upn.edu.pe.libraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Usuario

class MenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val admin:Usuario = Usuario("admin","admin")
    private val user:Usuario = Usuario("user","user")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var usuario: Usuario = Usuario("","")

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val context: Context = this
        val toast = Toast.makeText(applicationContext,"-", Toast.LENGTH_SHORT)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val linkEstudiantes = findViewById<Button>(R.id.btn_estudiantes)
        val linkLibros = findViewById<Button>(R.id.btn_libros)
        val linkReservas = findViewById<Button>(R.id.btn_reservas)
        val btnIngrear = findViewById<Button>(R.id.btn_ingresar)

        val userid = findViewById<EditText>(R.id.et_usuario)
        val password = findViewById<EditText>(R.id.et_password)

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
        btnIngrear.setOnClickListener {
            if(userid.text.toString() == admin.user && password.text.toString() == admin.password){
                usuario = admin
                toast.setText("Ingresaste como Administrador")
                toast.show()
            }else{
                if(userid.text.toString() == user.user && password.text.toString() == user.password){
                    usuario = user
                    toast.setText("Ingresaste como Usuario")
                    toast.show()
                }else{
                    toast.setText("Usuario o contraseña Incorrectos")
                    toast.show()
                }
            }
        }

    }
}



