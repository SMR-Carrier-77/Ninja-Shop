package com.example.sianonrid.Views.stater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sianonrid.R
import com.example.sianonrid.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentStartBinding.inflate(inflater,container, false)

        setListener()
        return binding.root



    }

    private fun setListener() {
      with(binding){
          btnLogin.setOnClickListener {
           findNavController().navigate(R.id.action_startFragment_to_loginFragment)
          }

          btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_registerFragment)
          }
      }
    }

}