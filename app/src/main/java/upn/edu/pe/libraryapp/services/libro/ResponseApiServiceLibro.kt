package upn.edu.pe.libraryapp.services.libro

import android.content.Context
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import upn.edu.pe.libraryapp.models.entity.Libro
import upn.edu.pe.libraryapp.services.RetrofitLibro
import upn.edu.pe.libraryapp.utils.AdaptadorLibro

class ResponseApiServiceLibro {
    fun grabaLibro(idLibro: Int, nombreLibro:String?,editorialLibro:String?,idiomaLibro:String?,
                        categoriaLibro:String?, ejemplarLibro:String?, toast: Toast) {

        val l = Libro(0,nombreLibro,editorialLibro,idiomaLibro,categoriaLibro,ejemplarLibro)
        val r = RetrofitLibro.buildService(ApiServiceLibro::class.java)
        val call =r.grabaLibro(l)
        var mensaje: String =""

        call!!.enqueue(object : Callback<Libro>{
            override fun onResponse(call: Call<Libro>, response: Response<Libro>) {
                if(response.isSuccessful) mensaje= "Libro Grabado"
                else mensaje ="Reintente nuevamente"
                toast.setText(mensaje)
                toast.show()
            }

            override fun onFailure(call: Call<Libro>, t: Throwable) {
                mensaje="Reintente nuevamente"
                toast.setText(mensaje)
                toast.show()
            }
        })
    }

    fun listarLibros(context: Context, listView: ListView){
        val r = RetrofitLibro.buildService(ApiServiceLibro::class.java)
        val call = r.listarLibros()

        call!!.enqueue(object :Callback<List<Libro>> {
            override fun onResponse(call: Call<List<Libro>>, response: Response<List<Libro>>) {
                if(response.isSuccessful){
                    val rpta =response.body()!!
                    rpta.forEach {
                        Log.d(" ",it.nombreLibro +" " +it.categoriaLibro)
                    }
                    val adap = AdaptadorLibro(context,rpta)
                    listView.adapter = adap
                }
            }

            override fun onFailure(call: Call<List<Libro>>, t: Throwable) {
                println(t.toString())

            }
        })
    }
    fun buscarLibros(context: Context,idLibro: Int): Libro{
        val r = RetrofitLibro.buildService(ApiServiceLibro::class.java)
        val call = r.listarLibros()
        val libro:Libro = Libro()

        call!!.enqueue(object :Callback<List<Libro>> {
            override fun onResponse(call: Call<List<Libro>>, response: Response<List<Libro>>) {
                if(response.isSuccessful){
                    val rpta =response.body()!!
                    rpta.forEach {
                        if(it.idLibro == idLibro){
                            libro.categoriaLibro=it.categoriaLibro
                            libro.editorialLibro= it.editorialLibro
                            libro.ejemplarLibro=it.ejemplarLibro
                            libro.nombreLibro=it.nombreLibro
                            libro.idiomaLibro=it.idiomaLibro
                        }
                    }

                }
            }

            override fun onFailure(call: Call<List<Libro>>, t: Throwable) {
                println(t.toString())

            }
        })
        return libro
    }
}