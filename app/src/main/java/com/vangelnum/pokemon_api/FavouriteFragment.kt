package com.vangelnum.pokemon_api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vangelnum.pokemon_api.databinding.FragmentSearchBinding
import com.vangelnum.pokemon_api.databinding.FragmentSecondBinding


class FavouriteFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.back.setOnClickListener {
//            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
//        }
//    }
}