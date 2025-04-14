package com.matthaug.mad411winter2025examreview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.matthaug.mad411winter2025examreview.R
import com.matthaug.mad411winter2025examreview.services.RetrofitClient
import kotlinx.coroutines.launch

class QuoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val quoteText = view.findViewById<TextView>(R.id.textQuote)
        val quoteAuthor = view.findViewById<TextView>(R.id.textAuthor)
        val btnShowQuote = view.findViewById<Button>(R.id.btnShowQuote)

        fun fetchAndDisplayQuote() {
            lifecycleScope.launch {
                try {
                    val quotes = RetrofitClient.api.getQuotes()
                    val random = quotes.random()
                    quoteText.text = "\"${random.text}\""
                    quoteAuthor.text = random.author ?: "Unknown"
                } catch (e: Exception) {
                    quoteText.text = "Could not fetch quote."
                    quoteAuthor.text = ""
                }
            }
        }

        fetchAndDisplayQuote() // Initial load
        btnShowQuote.setOnClickListener { fetchAndDisplayQuote() }
    }

}