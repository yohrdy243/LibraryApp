package upn.edu.pe.libraryapp.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Estudiante

class AdaptadorEstudiante(context:Context, private val datos: List<Estudiante>):ArrayAdapter<Estudiante>(context,R.layout.fila_estudiantes,datos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater =LayoutInflater.from(context)
        val vista =inflater.inflate(R.layout.fila_estudiantes,null,true)

        val tv_id = vista.findViewById<TextView>(R.id.tv_id)
        val tv_nombres =vista.findViewById<TextView>(R.id.tv_nombres)
        val tv_email = vista.findViewById<TextView>(R.id.tv_email)
        val tv_carrera =vista.findViewById<TextView>(R.id.tv_carrera)

        tv_nombres.text =datos.get(position).nombres+" "+datos.get(position).apellidos
        tv_email.text =datos.get(position).email
        tv_carrera.text =datos.get(position).carrera
        tv_id.text = datos.get(position).id.toString()

        return vista
    }

}