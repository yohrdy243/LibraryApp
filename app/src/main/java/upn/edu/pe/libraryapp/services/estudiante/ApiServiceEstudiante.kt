package upn.edu.pe.libraryapp.services.estudiante

import retrofit2.Call
import retrofit2.http.*
import upn.edu.pe.libraryapp.models.entity.Estudiante

interface ApiServiceEstudiante {

    @POST(".")
    fun grabaEstudiante(@Body estudiante: Estudiante?): Call<Estudiante>

    @GET(".")
    fun listarEstudiantes(): Call<List<Estudiante>>

    @GET("{id}")
    fun buscarEstudiante(@Path("id") id: Int): Call<Estudiante>

    @PUT("{id}")
    fun editarEstudiante(@Body estudiante: Estudiante?, @Path("id") id: Int): Call<Estudiante>

    @DELETE("{id}")
    fun eliminarEstudiante(@Path("id") id: Int): Call<Estudiante>
}
