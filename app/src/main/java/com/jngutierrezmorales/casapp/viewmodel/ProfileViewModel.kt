package com.jngutierrezmorales.casapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jngutierrezmorales.casapp.repository.FirebaseRepository

class ProfileViewModel(private val firebaseRepository: FirebaseRepository) : ViewModel() {
    fun signOut() = firebaseRepository.signOut()
    suspend fun updatePassword(password: String) = firebaseRepository.updatePassword(password)
}

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory (private val firebaseRepository: FirebaseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(firebaseRepository) as T
    }
}
