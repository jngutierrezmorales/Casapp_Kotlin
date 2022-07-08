package com.jngutierrezmorales.casapp.service.protocol

abstract class FirebaseServiceProtocol {
    open suspend fun createAccount(email: String, password: String) {}
    open suspend fun signIn(email: String, password: String) {}
    open suspend fun signOut() {}
}
