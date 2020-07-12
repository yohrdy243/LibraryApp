package upn.edu.pe.libraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Reserva {
    @SerializedName("idReserva")
    @Expose
    var idReserva = 0;

    @SerializedName("libro")
    @Expose
    var libro: Libro = Libro()

    @SerializedName("estudiante")
    @Expose
    var estudiante: Estudiante = Estudiante()

    @SerializedName("createAt")
    @Expose
    var fecha: String? = ""

    constructor(idReserva: Int, libro: Libro, estudiante: Estudiante, fecha: String?) {
        this.idReserva = idReserva
        this.libro = libro
        this.estudiante = estudiante
        this.fecha = fecha
    }

}