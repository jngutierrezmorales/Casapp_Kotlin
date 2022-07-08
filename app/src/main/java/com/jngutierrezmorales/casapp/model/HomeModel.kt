package com.jngutierrezmorales.casapp.model

data class HomeModel(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val price: String = "",
    val size: String = "",
    val location: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val phone: String = "",
    val homeState: String = "",
    val isFavorite: Boolean = false
)
