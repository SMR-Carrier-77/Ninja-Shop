package com.example.sianonrid.Views.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sianonrid.core.DataState
import com.example.sianonrid.db.models.UserRegistration
import com.example.sianonrid.db.repository.AuthRepository
import com.example.sianonrid.db.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class RegistrationViewModel@Inject constructor(
    private val authService: AuthRepository
): ViewModel() {
   private val registrationResponse= MutableLiveData<DataState<UserRegistration>>()
    val rs: LiveData<DataState<UserRegistration>> =registrationResponse

    fun userRegistration(user: UserRegistration){
        registrationResponse.postValue(DataState.Loading())

        authService.userRegistration(user).addOnSuccessListener {

            it.user?.let { createUser->
                user.userID=createUser.uid

                authService.createUser(user).addOnSuccessListener {
                    registrationResponse.postValue(DataState.Success(user))
                    Log.d("Tag","userRegister:success")

                }.addOnFailureListener{error->
                    registrationResponse.postValue(DataState.Error("${error.message}"))
                    Log.d("Tag","userRegister:${error.message}")
                }
            }



        }.addOnFailureListener {error->
            registrationResponse.postValue(DataState.Error("${error.message}"))
            Log.d("Tag","userRegister:${error.message}")
        }
    }

}