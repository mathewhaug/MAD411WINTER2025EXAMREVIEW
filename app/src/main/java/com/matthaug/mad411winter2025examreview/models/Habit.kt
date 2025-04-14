package com.matthaug.mad411winter2025examreview.models
//Define a habit
data class Habit(
    val name: String,
    val time: String,
    val goal: String,
    val isComplete: Boolean = false
)