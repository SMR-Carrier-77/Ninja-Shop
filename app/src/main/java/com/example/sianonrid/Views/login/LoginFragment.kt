package com.example.sianonrid.Views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.sianonrid.R
import com.example.sianonrid.Views.register.RegistrationViewModel
import com.example.sianonrid.base.Basefragment
import com.example.sianonrid.databinding.FragmentLoginBinding
import com.example.sianonrid.db.models.UserRegistration
import com.example.sianonrid.isEmpty
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.ReadOnlyProperty

@AndroidEntryPoint
class LoginFragment : Basefragment<FragmentLoginBinding>
    (FragmentLoginBinding::inflate) {
    override fun setListener() {
        with(binding) {
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etEmail.isEmpty() && !etPassword.isEmpty())
                    Toast.makeText(context, "All input done...", Toast.LENGTH_LONG).show()

            }
        }
    }
            override fun allObserver() {

            }


        }