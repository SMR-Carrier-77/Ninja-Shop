package com.example.sianonrid.Views.dasboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sianonrid.R
import com.example.sianonrid.base.Basefragment
import com.example.sianonrid.databinding.FragmentDashboardBinding
import com.example.sianonrid.isEmpty
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Basefragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

      lateinit var jAuth: FirebaseAuth

    override fun setListener() {
        with(binding) {
            
        }
    }

    override fun allObserver() {

    }


}