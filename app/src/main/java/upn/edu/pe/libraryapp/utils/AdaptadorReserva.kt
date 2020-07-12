package upn.edu.pe.libraryapp.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import upn.edu.pe.libraryapp.R
import upn.edu.pe.libraryapp.models.entity.Reserva

class AdaptadorReserva (context: Context, private val datos: List<Reserva>): ArrayAdapter<Reserva>(context, R.layout.fila_reservas,datos) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val inflater = LayoutInflater.from(context)
                val vista =inflater.inflate(R.layout.fila_reservas,null,true)

                val tv_ReservaId = vista.findViewById<TextView>(R.id.tv_reservaId)
                val tv_libro =vista.findViewById<TextView>(R.id.tv_libro)
                val tv_estudiante = vista.findViewById<TextView>(R.id.tv_estudiante)
                val tv_fecha =vista.findViewById<TextView>(R.id.tv_fechaReserva)

                tv_libro.text =datos.get(position).libro.nombreLibro
                tv_estudiante.text =datos.get(position).estudiante.nombres+" "+datos.get(position).estudiante.apellidos
                tv_fecha.text =datos.get(position).fecha
                tv_ReservaId.text = datos.get(position).idReserva.toString()

                return vista
            }

}