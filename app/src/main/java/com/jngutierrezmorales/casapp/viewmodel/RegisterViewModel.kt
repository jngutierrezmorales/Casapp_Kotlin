package com.jngutierrezmorales.casapp.viewmodel

import androidx.lifecycle.*
import com.jngutierrezmorales.casapp.repository.FirebaseRepository

class RegisterViewModel(private val firebaseRepository: FirebaseRepository) : ViewModel() {
    suspend fun createAccount(email: String, password: String) = firebaseRepository.createAccount(email, password)
}

@Suppress("UNCHECKED_CAST")
class RegisterViewModelFactory(private val firebaseRepository: FirebaseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterViewModel(firebaseRepository) as T
    }
}