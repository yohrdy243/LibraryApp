package upn.edu.pe.libraryapp.services.libro

import retrofit2.Call
import retrofit2.http.*
import upn.edu.pe.libraryapp.models.entity.Estudiante
import upn.edu.pe.libraryapp.models.entity.Libro

interface ApiServiceLibro {

    @POST(".")
    fun grabaLibro(@Body libro: Libro?): Call<Libro>

    @GET(".")
    fun listarLibros(): Call<List<Libro>>

    @GET("{idLibro}")
    fun buscarLibro(@Path("idLibro") idLibro: Int): Call<Libro>

    @PUT("{idLibro}")
    fun editarLibro(@Body libro: Libro?,@Path("idLibro") id: Int):Call<Libro>

    @DELETE("{idLibro}")
    fun eliminarLibro(@Path("idLibro") id: Int): Call<Libro>
}