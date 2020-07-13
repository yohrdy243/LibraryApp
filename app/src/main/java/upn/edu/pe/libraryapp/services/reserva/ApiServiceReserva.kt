package upn.edu.pe.libraryapp.services.reserva

import retrofit2.Call
import retrofit2.http.*
import upn.edu.pe.libraryapp.models.entity.Libro
import upn.edu.pe.libraryapp.models.entity.Reserva

interface ApiServiceReserva {
    @POST(".")
    fun grabaReserva(@Body reserva: Reserva?): Call<Reserva>

    @GET(".")
    fun listarReservas(): Call<List<Reserva>>

    @GET("{idReserva}")
    fun buscarReserva(@Path("idReserva") idReserva: Int): Call<Reserva>

    @PUT("{idReserva}")
    fun editarReserva(@Body libro: Libro?, @Path("idReserva") id: Int):Call<Reserva>

    @DELETE("{idReserva}")
    fun eliminarLibro(@Path("idReserva") id: Int):Call<Reserva>
}