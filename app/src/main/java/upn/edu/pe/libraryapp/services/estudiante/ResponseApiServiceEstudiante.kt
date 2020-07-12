package upn.edu.pe.libraryapp.services.estudiante

import android.content.Context
import android.util.Log
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import upn.edu.pe.libraryapp.models.entity.Estudiante
import upn.edu.pe.libraryapp.services.RetrofitEstudiante
import upn.edu.pe.libraryapp.utils.AdaptadorEstudiante

class ResponseApiServiceEstudiante {
    fun listarEstudiantes(context: Context, listView: ListView) {
        val r = RetrofitEstudiante.buildService(ApiServiceEstudiante::class.java)
        val call = r.listarEstudiantes()

        call.enqueue(object : Callback<List<Estudiante>> {
            override fun onResponse(
                call: Call<List<Estudiante>>,
                response: Response<List<Estudiante>>
            ) {
                if (response.isSuccessful) {
                    val rpta = response.body()!!
                    rpta.forEach {
                        Log.d(" ", it.nombres + " " + it.apellidos)
                    }
                    val adap = AdaptadorEstudiante(context, rpta)
                    listView.adapter = adap
                }
            }

            override fun onFailure(call: Call<List<Estudiante>>, t: Throwable) {
                println(t.toString())

            }
        })
    }

    fun buscarEstudiante(context: Int, idEstudiante: Int): Estudiante {
        val r = RetrofitEstudiante.buildService(ApiServiceEstudiante::class.java)
        val call = r.listarEstudiantes()
        val estudiante: Estudiante = Estudiante()
        call.enqueue(object : Callback<List<Estudiante>> {
            override fun onResponse(
                call: Call<List<Estudiante>>,
                response: Response<List<Estudiante>>
            ) {
                if (response.isSuccessful) {
                    val rpta = response.body()!!
                    rpta.forEach {
                        if (it.id == idEstudiante) {
                            estudiante.nombres = it.nombres
                            estudiante.apellidos = it.apellidos
                            estudiante.carrera = it.carrera
                            estudiante.email = it.email
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Estudiante>>, t: Throwable) {
                println(t.toString())

            }
        })
        return estudiante
    }

    fun grabaEstudiante(id: Int, apellidos: String?, nombre: String?, carrera: String?, email: String?, toast: Toast) {

        val e = Estudiante(0, apellidos, nombre, carrera, email)
        val r = RetrofitEstudiante.buildService(ApiServiceEstudiante::class.java)
        val call = r.grabaEstudiante(e)
        var mensaje: String = ""

        call!!.enqueue(object : Callback<Estudiante> {
            override fun onResponse(call: Call<Estudiante>, response: Response<Estudiante>) {
                if (response.isSuccessful) mensaje = "GRABADO"
                else mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }

            override fun onFailure(call: Call<Estudiante>, t: Throwable) {
                mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }
        })
    }

    fun eliminarEstudiante(id: Int, toast: Toast) {
        val r = RetrofitEstudiante.buildService(ApiServiceEstudiante::class.java)
        val call = r.eliminarEstudiante(id)
        var mensaje: String = ""
        call!!.enqueue(object : Callback<Estudiante> {
            override fun onResponse(call: Call<Estudiante>, response: Response<Estudiante>) {
                if (response.isSuccessful) mensaje = "ELIMINADO"
                else mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }

            override fun onFailure(call: Call<Estudiante>, t: Throwable) {
                mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }
        })
    }
}