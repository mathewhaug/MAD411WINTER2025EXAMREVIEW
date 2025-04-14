package com.matthaug.mad411winter2025examreview.models

data class Quote(
    val text: String,
    val author: String? //sometimes the api returns null for the author
)