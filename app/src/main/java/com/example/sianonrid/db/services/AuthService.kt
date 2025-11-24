package com.example.sianonrid.db.services

import com.example.sianonrid.db.models.UserLogin
import com.example.sianonrid.db.models.UserRegistration
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {
    fun userRegistration(user: UserRegistration):Task<AuthResult>
    fun userLogin(userLogin: UserLogin): Task<AuthResult>
    fun createUser(user: UserRegistration): Task<Void>
}