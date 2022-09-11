package com.app.weather

data class DayItem(
    val city: String,
    val time: String,
    val condition: String,
    val imageUrl: String,
    val currentTemp: String,
    val maxTemp: String,
    val mintTemp: String,
    val hours: String
)
