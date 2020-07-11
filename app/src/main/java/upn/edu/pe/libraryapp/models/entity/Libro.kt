package upn.edu.pe.libraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Libro {

    @SerializedName("idLibro")
    @Expose
    var idLibro =0

    @SerializedName("nombreLibro")
    @Expose
    var nombreLibro: String? = ""

    @SerializedName("editorialLibro")
    @Expose
    var editorialLibro: String? = ""

    @SerializedName("categoriaLibro")
    @Expose
    var categoriaLibro: String? = ""

    @SerializedName("ejemplarLibro")
    @Expose
    var ejemplarLibro: String? = ""

    @SerializedName("idiomaLibro")
    @Expose
    var idiomaLibro: String? = ""

    constructor(idLibro: Int, nombreLibro: String?, editorialLibro: String?,
                categoriaLibro: String?, ejemplarLibro: String?,idiomaLibro:String?){
        this.idLibro=idLibro
        this.nombreLibro=nombreLibro
        this.editorialLibro=editorialLibro
        this.categoriaLibro=categoriaLibro
        this.ejemplarLibro=ejemplarLibro
        this.idiomaLibro=idiomaLibro
    }

    constructor()

}
