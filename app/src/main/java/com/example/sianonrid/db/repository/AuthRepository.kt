package com.example.sianonrid.db.repository

import com.example.sianonrid.db.models.UserRegistration
import com.example.sianonrid.db.services.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRepository@Inject constructor(
    private val jAuth: FirebaseAuth
): AuthService {
    override fun userRegistration(user: UserRegistration) : Task<AuthResult> {


      return jAuth.createUserWithEmailAndPassword(user.email,user.password)
    }

    override fun userLogin() {

    }

    override fun create(user: UserRegistration) {

    }

}