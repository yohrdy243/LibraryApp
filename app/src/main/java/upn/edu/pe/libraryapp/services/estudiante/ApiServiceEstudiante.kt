package upn.edu.pe.libraryapp.services.estudiante

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import upn.edu.pe.libraryapp.models.entity.Estudiante

interface ApiServiceEstudiante {

    @POST(".")
    fun grabaEstudiante(@Body estudiante: Estudiante?): Call<Estudiante>

    @GET(".")
    fun listarEstudiantes(): Call<List<Estudiante>>

    @PUT(".")
    fun editarEstudiante(@Body estudiante: Estudiante?):Call<Estudiante>
}