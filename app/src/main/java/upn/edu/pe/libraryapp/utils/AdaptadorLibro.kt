package upn.edu.pe.libraryapp.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Libro

class AdaptadorLibro (context:Context, private val datos: List<Libro>):ArrayAdapter<Libro>(context,R.layout.fila_libros,datos) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater =LayoutInflater.from(context)
            val vista =inflater.inflate(R.layout.fila_libros,null,true)

            val tv_nombreLibro =vista.findViewById<TextView>(R.id.tv_nombreLibro)
            val tv_editorialLibro = vista.findViewById<TextView>(R.id.tv_editorialLibro)
            val tv_categoriaLibro =vista.findViewById<TextView>(R.id.tv_categoriaLibro)

            tv_nombreLibro.text =datos.get(position).nombreLibro
            tv_editorialLibro.text =datos.get(position).editorialLibro
            tv_categoriaLibro.text =datos.get(position).categoriaLibro

            return vista
        }

}