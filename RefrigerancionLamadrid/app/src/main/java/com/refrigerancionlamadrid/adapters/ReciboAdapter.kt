package com.refrigerancionlamadrid.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.refrigerancionlamadrid.R
import com.refrigerancionlamadrid.model.Recibo
import com.refrigerancionlamadrid.view.activity_recibo
import java.lang.Exception

class ReciboAdapter(val lista: ArrayList<Recibo>) : RecyclerView.Adapter<ReciboAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recibo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cliente.text = lista[position].cliente
        holder.direccion.text = lista[position].direccion
        holder.modeloElectrodomestico.text = lista[position].modeloElectrodomestico
        holder.reparacion.text = lista[position].reparacion
        holder.precio.text = lista[position].precio
        holder.fecha.text = lista[position].fecha



        holder.ver.setOnClickListener(
            View.OnClickListener {
                try {
                    val intent: Intent = Intent(it.context,activity_recibo::class.java)
                    intent.putExtra("cliente", lista[position].cliente)
                    intent.putExtra("direccion", lista[position].direccion)
                    intent.putExtra("modeloElectrodomestico", lista[position].modeloElectrodomestico)
                    intent.putExtra("reparacion", lista[position].reparacion)
                    intent.putExtra("precio", lista[position].precio)
                    intent.putExtra("fecha", lista[position].fecha)
                    it.context.startActivity(intent)
                } catch (e: Exception) {
                    Log.e("Error->", e.message.toString())
                }
            }
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var cliente: TextView
        var direccion: TextView
        var modeloElectrodomestico: TextView
        var reparacion: TextView
        var precio: TextView
        var fecha: TextView
        var ver: MaterialButton

        init {
            cliente = view.findViewById(R.id.recibo_cliente)
            direccion = view.findViewById(R.id.recibo_direccion)
            modeloElectrodomestico = view.findViewById(R.id.recibo_modeloelectrodomestico)
            reparacion = view.findViewById(R.id.recibo_reparacion)
            precio = view.findViewById(R.id.recibo_precio)
            fecha = view.findViewById(R.id.recibo_direccion)
            ver = view.findViewById(R.id.recibo_btn_ver)

        }
    }

}