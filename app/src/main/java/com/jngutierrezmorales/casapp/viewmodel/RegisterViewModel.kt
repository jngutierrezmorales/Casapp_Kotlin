package com.jngutierrezmorales.casapp.viewmodel

import com.jngutierrezmorales.casapp.service.protocol.FirebaseServiceProtocol

class RegisterViewModel : FirebaseServiceProtocol {

    override suspend fun createAccount(email: String, password: String) {
        super.createAccount(email, password)
    }
}