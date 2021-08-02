package com.refrigerancionlamadrid.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.refrigerancionlamadrid.R
import com.refrigerancionlamadrid.viewmodel.ReciboViewModel

class activity_recibo : AppCompatActivity() {

    lateinit var cliente: TextView
    lateinit var direccion: TextView
    lateinit var modeloElectrodomestico: TextView
    lateinit var reparacion: TextView
    lateinit var precio: TextView
    lateinit var fecha: TextView
    lateinit var recibo_vm: ReciboViewModel
    lateinit var borrar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibo)
        recibo_vm = ViewModelProvider(this).get(ReciboViewModel::class.java)
        inicializar()
        mapperElements()
        borrarPersona()
    }


    private fun borrarPersona() {
        borrar.setOnClickListener(
            View.OnClickListener {
                MaterialAlertDialogBuilder(this)
                    .setIcon(R.drawable.ic_no)
                    .setTitle(resources.getString(R.string.title))
                    .setMessage(resources.getString(R.string.supporting_text))
                    .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                        Snackbar.make(it,"Operacion cancelada", Snackbar.LENGTH_LONG).show()
                    }
                    .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                        //BORRAR POR DNI
                        recibo_vm.delete(cliente)
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    .show()
            }
        )
    }

    private fun mapperElements() {
        cliente.text = intent.getStringExtra("cliente")
        direccion.setText(intent.getStringExtra("direccion"))
        modeloElectrodomestico.setText(intent.getStringExtra("modeloElectrodomestico"))
        reparacion.setText(intent.getStringExtra("reparacion"))
        precio.setText(intent.getStringExtra("precio"))
        fecha.setText(intent.getStringExtra("fecha"))


    }

    private fun inicializar() {
        cliente = findViewById(R.id.r_cliente)
        direccion = findViewById(R.id.r_direccion)
        modeloElectrodomestico = findViewById(R.id.r_electrodomestico)
        reparacion = findViewById(R.id.r_reparacion)
        precio = findViewById(R.id.r_precio)
        fecha = findViewById(R.id.r_fecha)
        borrar = findViewById(R.id.r_borrar)

    }

}