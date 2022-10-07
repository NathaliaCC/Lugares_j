package com.example.lugares_j.ui.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lugares_j.R
import com.example.lugares_j.adapter.LugarAdapter
import com.example.lugares_j.databinding.FragmentLugarBinding
import com.example.lugares_j.viewmodel.LugarViewModel

class LugarFragment : Fragment() {

    private var _binding: FragmentLugarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val lugarViewModel =
            ViewModelProvider(this)[(LugarViewModel::class.java)]

        _binding = FragmentLugarBinding.inflate(inflater, container, false)

        binding.addLugarFabButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)
        }

        // se genera el reciclear view para ver la información
        val lugarAdapter=LugarAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = lugarAdapter // es quien reemplaza la info
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        lugarViewModel.getLugares.observe(viewLifecycleOwner){
            lugares -> lugarAdapter.setListaLugares(lugares)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}