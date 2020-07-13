package upn.edu.pe.libraryapp.services.reserva

import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upn.edu.pe.libraryapp.models.entity.Estudiante
import upn.edu.pe.libraryapp.models.entity.Libro

import upn.edu.pe.libraryapp.models.entity.Reserva
import upn.edu.pe.libraryapp.services.RetrofitLibro

import upn.edu.pe.libraryapp.services.RetrofitReserva
import upn.edu.pe.libraryapp.services.libro.ApiServiceLibro

import upn.edu.pe.libraryapp.utils.AdaptadorReserva

class ResponseApiServiceReserva {
        fun grabaReserva(idReserva: Int, libro:Libro,estudiante:Estudiante, fecha:String?, toast: Toast) {

            val r = Reserva(0,libro,estudiante,fecha)
            val re = RetrofitReserva.buildService(ApiServiceReserva::class.java)
            val call = re.grabaReserva(r)
            var mensaje: String=""

            call!!.enqueue(object :Callback<Reserva>{
                override fun onResponse(call: Call<Reserva>, response: Response<Reserva>) {
                    if(response.isSuccessful) mensaje= "Reserva Guardada"
                    else mensaje ="Reintente Nuevamente"
                    toast.setText(mensaje)
                    toast.show()
                }

                override fun onFailure(call: Call<Reserva>, t: Throwable) {
                    mensaje =" Reintente Nuevamente "
                    toast.setText(mensaje)
                    toast.show()
                }
            })
        }
        fun listarReserva(context: Context, listView: ListView){
            val r = RetrofitReserva.buildService(ApiServiceReserva::class.java)
            val call = r.listarReservas()

            call!!.enqueue(object :Callback<List<Reserva>> {
                override fun onResponse(call: Call<List<Reserva>>, response: Response<List<Reserva>>) {
                    if(response.isSuccessful){
                        val rpta =response.body()!!
                        val adap = AdaptadorReserva(context,rpta)
                        rpta.forEach {
                            Log.d("fecha",it.fecha.toString())
                        }
                        listView.adapter = adap
                    }
                }

                override fun onFailure(call: Call<List<Reserva>>, t: Throwable) {
                    println(t.toString())

                }
            })
        }
        fun buscarReserva(idReserva: Int,libro:EditText, estudiante: EditText,fecha: EditText){
            val r = RetrofitReserva.buildService(ApiServiceReserva::class.java)
            val call = r.buscarReserva(idReserva)

            call!!.enqueue(object :Callback<Reserva> {
                override fun onResponse(call: Call<Reserva>, response: Response<Reserva>) {
                    if(response.isSuccessful){
                        estudiante.setText(response.body()!!.estudiante.id.toString())
                        libro.setText(response.body()!!.libro.idLibro.toString())
                        fecha.setText(response.body()!!.fecha.toString())
                    }
                }
                override fun onFailure(call: Call<Reserva>, t: Throwable) {
                    println(t.toString())

                }
            })

        }

        fun eliminarReserva(idReserva: Int, toast: Toast) {
            val r = RetrofitReserva.buildService(ApiServiceReserva::class.java)
            val call = r.eliminarLibro(idReserva)
            var mensaje: String = ""
            call!!.enqueue(object : Callback<Reserva> {
                override fun onResponse(call: Call<Reserva>, response: Response<Reserva>) {
                    if(response.isSuccessful) mensaje = "ELIMINADO"
                    else mensaje = "REINTENTE NUEVAMENTE"
                    toast.setText(mensaje)
                    toast.show()
                }

                override fun onFailure(call: Call<Reserva>, t: Throwable) {
                    mensaje = "REINTENTE NUEVAMENTE"
                    toast.setText(mensaje)
                    toast.show()
                }
            })
        }

    fun editarReserva(reserva: Reserva, toast: Toast) {
        val r = RetrofitReserva.buildService(ApiServiceReserva::class.java)
        val call = r.editarReserva(reserva,reserva.idReserva)
        var mensaje: String = ""
        call!!.enqueue(object : Callback<Reserva> {
            override fun onResponse(call: Call<Reserva>, response: Response<Reserva>) {
                if(response.isSuccessful) mensaje = "EDITADO"
                else mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }

            override fun onFailure(call: Call<Reserva>, t: Throwable) {
                mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }
        })
    }
}