package com.example.sianonrid.Views.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sianonrid.core.DataState
import com.example.sianonrid.db.models.UserLogin
import com.example.sianonrid.db.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val userAuth: AuthRepository
): ViewModel() {
    private val logInResponse= MutableLiveData<DataState<UserLogin>>()
    val logIn_Response: LiveData<DataState<UserLogin>> =logInResponse

    fun userLogIn(user: UserLogin) {
        logInResponse.postValue(DataState.Loading())

        userAuth.userLogin(user).addOnSuccessListener {
            logInResponse.postValue(DataState.Success(user))


        }.addOnFailureListener {
            logInResponse.postValue(DataState.Error(it.message.toString()))

        }
    }
}