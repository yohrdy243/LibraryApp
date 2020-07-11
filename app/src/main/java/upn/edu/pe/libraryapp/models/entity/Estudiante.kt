package upn.edu.pe.libraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Estudiante {
    @SerializedName("id")
    @Expose
    var id= 0

    @SerializedName("nombre")
    @Expose
    var nombres: String? = ""

    @SerializedName ("apellido")
    @Expose
    var apellidos: String? = ""

    @SerializedName("email")
    @Expose
    var email: String? = ""
    @SerializedName("carrera")
    @Expose
    var carrera: String? = ""


    constructor(id: Int, apellidos:String?, nombres: String?, carrera: String?, email:String?){
        this.id= id
        this.apellidos=apellidos
        this.nombres=nombres
        this.carrera=carrera
        this.email=email
    }

    constructor()


}