package com.example.lugares_j.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lugares_j.databinding.LugarFilaBinding
import com.example.lugares_j.model.Lugar
import com.example.lugares_j.ui.lugar.LugarFragmentDirections

class LugarAdapter : RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    // clase interna que se encarga de finalmente dibujar la información
    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(lugar: Lugar) {
            itemBinding.tvNombre.text = lugar.nombre
            itemBinding.tvCorreo.text = lugar.correo
            itemBinding.tvTelefono.text = lugar.telefono
            itemBinding.vistaFila.setOnClickListener {
                //Crea una acción para navegar a updateLugar pasando un argumento Lugar
                val action = LugarFragmentDirections
                    .actionNavLugarToUpdateLugarFragment(lugar)

                // pasa efectivamente el fragmento
                itemView.findNavController().navigate(action)
            }
        }

    }

    // lista donde están los objetos Lugar a dibujarse
    private var listaLugares = emptyList<Lugar>()

    // función para crear las cajas de cada lugar en memoria
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder { //vista
        val itemBinding = LugarFilaBinding. //lugar fila es la clase que se genera de lugar_fila xml
        inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LugarViewHolder(itemBinding)
    }

    // función toma un lugar y lo envía a dibujar
    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.dibuja(lugar) // pasa los datos a los textos de una caja
    }

    // función devuelve la cantidad de elementos a dibujar (o sea las cajitas a crear)
    override fun getItemCount(): Int {
        return listaLugares.size
    }

    fun setListaLugares(lugares:List<Lugar>){
        this.listaLugares = lugares
        notifyDataSetChanged() //notifica el cambio de la información
    }
}