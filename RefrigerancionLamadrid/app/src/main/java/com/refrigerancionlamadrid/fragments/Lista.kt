package com.refrigerancionlamadrid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.refrigerancionlamadrid.R
import com.refrigerancionlamadrid.adapters.ReciboAdapter
import com.refrigerancionlamadrid.model.Recibo
import com.refrigerancionlamadrid.viewmodel.ReciboViewModel


class Lista : Fragment() {

    private lateinit var rv_Recibos: RecyclerView
    private lateinit var arrayRecibos: ArrayList<Recibo>
    private lateinit var reciboAdapter: ReciboAdapter
    lateinit var recibo_vm: ReciboViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recibo_vm = ViewModelProvider(this).get(ReciboViewModel::class.java)
        rv_Recibos= view.findViewById(R.id.rv_recibos)
        rv_Recibos.layoutManager = LinearLayoutManager(context)
        rv_Recibos.setHasFixedSize(true)
        arrayRecibos = arrayListOf()
        reciboAdapter = ReciboAdapter(arrayRecibos)
        rv_Recibos.adapter = reciboAdapter
        recibo_vm.listar(arrayRecibos,reciboAdapter)
    }


}