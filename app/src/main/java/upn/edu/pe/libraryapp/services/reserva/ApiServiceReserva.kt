package upn.edu.pe.libraryapp.services.reserva

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import upn.edu.pe.libraryapp.models.entity.Reserva

interface ApiServiceReserva {
    @POST(".")
    fun grabaReserva(@Body reserva: Reserva?): Call<Reserva>

    @GET(".")
    fun listarReservas(): Call<List<Reserva>>

}