package com.example.lugares_j.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lugares_j.R
import com.example.lugares_j.databinding.FragmentAddLugarBinding
import com.example.lugares_j.databinding.FragmentLugarBinding
import com.example.lugares_j.model.Lugar
import com.example.lugares_j.viewmodel.LugarViewModel

class AddLugarFragment : Fragment() {

    private lateinit var lugarViewModel: LugarViewModel
    private var _binding: FragmentAddLugarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        lugarViewModel = ViewModelProvider(this).get(LugarViewModel::class.java)

        _binding = FragmentAddLugarBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener { addLugar() }


        return binding.root
    }

    private fun addLugar() {
        val nombre =
            binding.etNombre.text.toString() // se obtiene el texto de lo que escribe el usuario
        if (nombre.isNotEmpty()) { // si se escribe algo en el nombre se puede guardar
            val correo = binding.etCorreo.text.toString() //se obtiene el texto de lo que escribe el usuario
            val telefono = binding.etTelefono.text.toString() //se obtiene el texto de lo que escribe el usuario
            val web = binding.etWeb.text.toString() //se obtiene el texto de lo que escribe el usuario
            val lugar = Lugar(0,nombre, correo, telefono, web,
                0.0, 0.0,0.0,"", "")

            // se procede a registrar el nuevo lugar
            lugarViewModel.saveLugar(lugar)
            Toast.makeText(requireContext(),
                getString(R.string.msg_lugar_added),
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)
        } else{ //no se puede registrar falta info
            Toast.makeText(requireContext(),
                getString(R.string.msg_data),
                Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}