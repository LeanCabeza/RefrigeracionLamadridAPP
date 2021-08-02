package com.refrigerancionlamadrid.viewmodel
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import com.refrigerancionlamadrid.adapters.ReciboAdapter
import com.refrigerancionlamadrid.model.Recibo
import java.text.SimpleDateFormat
import java.util.*


class ReciboViewModel: ViewModel() {

    fun alta(cliente: String,
             direccion: String,
             modeloElectrodomestico: String,
             reparacion: String,
             precio: String)
    {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fecha = sdf.format(Date())

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("Recibos").document(cliente).set(
            hashMapOf(
                "cliente" to cliente,
                "direccion" to direccion,
                "modeloElectrodomestico" to modeloElectrodomestico,
                "reparacion" to reparacion,
                "precio" to precio,
                "fecha" to fecha
            )
        )
    }

    fun listar(arrayRecibos:ArrayList<Recibo>,
               reciboAdapter: ReciboAdapter)
    {
        val db:FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("Recibos").
        addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {

                if(error!=null){
                    Log.e("Firestore Error",error.message.toString())
                    return
                }
                for(dc: DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){
                        arrayRecibos.add(dc.document.toObject(Recibo::class.java))
                    }
                }
                reciboAdapter.notifyDataSetChanged()
            }
        })
    }

    fun delete(cliente: TextView){
        val db:FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("Recibos").document(cliente.text.toString()).delete()
    }

    fun limpiarCampos(cliente:TextInputEditText,
                      direccion: TextInputEditText,
                      modeloElectrodomestico: TextInputEditText,
                      reparacion: TextInputEditText,
                      precio: TextInputEditText)
    {
        cliente.setText("")
        direccion.setText("")
        modeloElectrodomestico.setText("")
        reparacion.setText("")
        precio.setText("")
    }

}