package com.example.sianonrid.di

import com.example.sianonrid.db.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class Firebasemodule {
    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providesFirebase(jAuth: FirebaseAuth): AuthRepository{
        return AuthRepository(jAuth)
    }
}