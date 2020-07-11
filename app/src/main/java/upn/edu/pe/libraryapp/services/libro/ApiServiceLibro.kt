package upn.edu.pe.libraryapp.services.libro

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import upn.edu.pe.libraryapp.models.entity.Libro

interface ApiServiceLibro {

    @POST(".")
    fun grabaLibro(@Body libro: Libro?): Call<Libro>

    @GET(".")
    fun listarLibros(): Call<List<Libro>>

}