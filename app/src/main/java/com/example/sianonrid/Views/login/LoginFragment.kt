package com.example.sianonrid.Views.login


import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sianonrid.R
import com.example.sianonrid.Views.dasboard.seller.SellerDashboard
import com.example.sianonrid.base.Basefragment
import com.example.sianonrid.core.DataState
import com.example.sianonrid.databinding.FragmentLoginBinding
import com.example.sianonrid.db.models.UserLogin
import com.example.sianonrid.isEmpty
import dagger.hilt.android.AndroidEntryPoint




@AndroidEntryPoint
class LoginFragment : Basefragment<FragmentLoginBinding>
    (FragmentLoginBinding::inflate) {
        private val viewModel: LoginViewModel by viewModels()
    override fun setListener() {

        with(binding) {


            btnLogin.setOnClickListener {

                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){

                    var user= UserLogin(

                        email = etEmail.text.toString(),
                        password = etPassword.text.toString()
                    )
              viewModel.userLogIn(user)

                }

            }

            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.registerFragment)
            }
        }
    }

           //OOAD..........................
            override fun allObserver() {
               viewModel.logIn_Response.observe(viewLifecycleOwner){

                   when(it){
                       is DataState.Error -> {
                           loading.dismiss()
                           Toast.makeText(context,it.message.toString(), Toast.LENGTH_SHORT).show()
                       }
                       is DataState.Loading ->{

                       }
                       is DataState.Success -> {
                           loading.dismiss()
                           Toast.makeText(context,"log in success", Toast.LENGTH_SHORT).show()
                           startActivity(Intent(requireContext(), SellerDashboard::class.java))
                           requireActivity().finish()
                       }
                   }
               }
            }


        }


