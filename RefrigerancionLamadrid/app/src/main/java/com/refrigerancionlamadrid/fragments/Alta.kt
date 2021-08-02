package com.refrigerancionlamadrid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.refrigerancionlamadrid.R
import com.refrigerancionlamadrid.viewmodel.ReciboViewModel



class Alta : Fragment() {

    lateinit var recibo_vm: ReciboViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alta, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cliente: TextInputEditText = view.findViewById(R.id.alta_et_cliente)
        val direccion: TextInputEditText = view.findViewById(R.id.alta_et_direccion)
        val modeloElectrodomestico: TextInputEditText = view.findViewById(R.id.alta_et_electrodomestico)
        val reparacion: TextInputEditText = view.findViewById(R.id.alta_et_reparacion)
        val precio: TextInputEditText = view.findViewById(R.id.alta_et_precio)
        val alta: Button = view.findViewById(R.id.alta_bt_generar)
        recibo_vm = ViewModelProvider(this).get(ReciboViewModel::class.java)

        alta.setOnClickListener(View.OnClickListener {
            var flagOk = true
            if ( cliente.text.isNullOrBlank())
            {
                cliente.error = "Requerido"
                flagOk = false
            } else if ( direccion.text.isNullOrBlank()){
                direccion.error = "Requerido"
                flagOk = false
            }else if ( modeloElectrodomestico.text.isNullOrBlank()) {
                modeloElectrodomestico.error = "Requerido"
                flagOk = false
            }else if ( reparacion.text.isNullOrBlank()) {
                reparacion.error = "Requerido"
                flagOk = false
            }else if ( precio.text.isNullOrBlank()) {
                precio.error = "Requerido"
                flagOk = false
            }

            if(!flagOk) {
                Toast.makeText(context, "Completar los campos obligatorios.", Toast.LENGTH_LONG).show()
            }else{
                recibo_vm.alta(
                    cliente.text.toString(),
                    direccion.text.toString(),
                    modeloElectrodomestico.text.toString(),
                    reparacion.text.toString(),
                    precio.text.toString())
                Snackbar.make(it,"Dado de alta con exito", Snackbar.LENGTH_LONG).show()

                recibo_vm.limpiarCampos(cliente,direccion,modeloElectrodomestico,reparacion, precio)
            }
        })
    }

}