package com.jngutierrezmorales.casapp.service.protocol

interface FirebaseServiceProtocol {
    suspend fun createAccount (email: String, password: String) {}
}
