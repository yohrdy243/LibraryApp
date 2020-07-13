package upn.edu.pe.libraryapp.models.entity

class Usuario {
    var user: String? =" "
    var password: String? = " "

    constructor(user: String?, password: String?) {
        this.user = user
        this.password = password
    }
}