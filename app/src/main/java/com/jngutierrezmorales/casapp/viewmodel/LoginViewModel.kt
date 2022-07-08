package com.jngutierrezmorales.casapp.viewmodel

import androidx.lifecycle.*
import com.jngutierrezmorales.casapp.repository.FirebaseRepository

class LoginViewModel(private val firebaseRepository: FirebaseRepository) : ViewModel() {
    suspend fun signIn(email: String, password: String) = firebaseRepository.signIn(email, password)
}

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(private val firebaseRepository: FirebaseRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(firebaseRepository) as T
    }
}
