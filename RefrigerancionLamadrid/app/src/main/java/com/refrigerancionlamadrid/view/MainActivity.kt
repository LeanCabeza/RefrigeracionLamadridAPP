package com.refrigerancionlamadrid.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.google.android.material.internal.ContextUtils.getActivity
import com.refrigerancionlamadrid.R
import com.refrigerancionlamadrid.fragments.Alta
import com.refrigerancionlamadrid.fragments.Lista

class MainActivity : AppCompatActivity() {



    lateinit var alta:ImageButton
    lateinit var listar:ImageButton
    lateinit var salir:ImageButton
    val alta_frg = Alta()
    val lista_frg = Lista()
    val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()

        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frame_container,lista_frg)
        transaction.commit()

        alta.setOnClickListener(View.OnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frame_container,alta_frg)
            transaction.commit()
        })

        listar.setOnClickListener(View.OnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frame_container,lista_frg)
            transaction.commit()
        })

        salir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun inicializar() {
        alta = findViewById(R.id.m_btn_add)
        listar = findViewById(R.id.m_btn_list)
        salir = findViewById(R.id.m_btn_exit)
    }


}