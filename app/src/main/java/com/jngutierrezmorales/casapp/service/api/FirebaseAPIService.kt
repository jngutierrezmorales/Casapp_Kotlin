package com.jngutierrezmorales.casapp.service.api

import com.jngutierrezmorales.casapp.service.protocol.FirebaseServiceProtocol
import com.jngutierrezmorales.casapp.utils.FirebaseUtils
import kotlinx.coroutines.tasks.await

class FirebaseAPIService : FirebaseServiceProtocol {
    private lateinit var firebaseUtils: FirebaseUtils

    override suspend fun createAccount(email: String, password: String) {
        //firebaseUtils.firebaseAuth.signInWithEmailAndPassword(email, password).await()

        firebaseUtils.firebaseAuth.createUserWithEmailAndPassword(email, password).await()

//        firebaseUtils.firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() { task ->
//            if (task.isSuccessful) {
//                Log.d(TAG, "Usuario creado")
//            } else {
//                Log.w(TAG, "Error al crear usuario")
//            }
//        }
    }
}
