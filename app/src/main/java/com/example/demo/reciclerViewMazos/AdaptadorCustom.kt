package com.example.demo.reciclerViewMazos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.Mazo
import com.example.demo.R

class AdaptadorCustom(var contexto: Context, items:ArrayList<Mazo>): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {

    //configuracion
    var items: ArrayList<Mazo>? = null

    init {
        this.items = items
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.template_mazo,parent,false)
        val viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombreMazo?.text = item?.nombreMazo
        holder.tipoMazo?.text = item?.tipoMazo

    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        var vista = vista
        var foto: ImageView? = null
        var nombreMazo: TextView? = null
        var tipoMazo:TextView? = null

        init{
            foto = vista.findViewById(R.id.imagenMazo_imageView)
            nombreMazo = vista.findViewById(R.id.imagenMazo_imageView)
            tipoMazo = vista.findViewById(R.id.tipoMazo_textView)
        }
    }
}