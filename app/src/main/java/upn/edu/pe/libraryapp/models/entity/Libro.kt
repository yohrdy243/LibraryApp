package upn.edu.pe.libraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Libro {

    @SerializedName("idlibro")
    @Expose
    var idLibro =0

    @SerializedName("nombrelibro")
    @Expose
    var nombreLibro: String? = ""

    @SerializedName("editoriallibro")
    @Expose
    var editorialLibro: String? = ""

    @SerializedName("categorialibro")
    @Expose
    var categoriaLibro: String? = ""

    @SerializedName("ejemplarlibro")
    @Expose
    var ejemplarLibro: String? = ""

    @SerializedName("idiomalibro")
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
