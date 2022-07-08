package com.jngutierrezmorales.casapp.service.api

import com.jngutierrezmorales.casapp.service.protocol.FirebaseServiceProtocol
import com.jngutierrezmorales.casapp.utils.FirebaseUtils
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class FirebaseAPIService : FirebaseServiceProtocol() {
    private lateinit var firebaseUtils: FirebaseUtils

    override suspend fun createAccount(email: String, password: String) {
        try {
            firebaseUtils.firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        } catch (exception: Exception) {
            exception.localizedMessage
        }
    }

    override suspend fun signIn(email: String, password: String) {
        try {
            firebaseUtils.firebaseAuth.signInWithEmailAndPassword(email, password).await()
        } catch (exception: Exception) {
            exception.localizedMessage
        }
    }

    override suspend fun signOut() {
        try {
            firebaseUtils.firebaseAuth.signOut()
        } catch (exception: Exception) {
            exception.localizedMessage
        }
    }
}
