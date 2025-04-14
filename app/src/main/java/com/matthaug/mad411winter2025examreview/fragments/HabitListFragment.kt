package com.matthaug.mad411winter2025examreview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matthaug.mad411winter2025examreview.R
import com.matthaug.mad411winter2025examreview.adapters.HabitAdapter
import com.matthaug.mad411winter2025examreview.helpers.loadHabitsFromFile
import com.matthaug.mad411winter2025examreview.helpers.saveHabitsToFile
import com.matthaug.mad411winter2025examreview.models.Habit

class HabitListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = HabitAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_habit_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        adapter.submitList(loadHabitsFromFile(requireContext()))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val addButton = view.findViewById<Button>(R.id.btnAddHabit)
        val defaultButton = view.findViewById<Button>(R.id.btnLoadDefaults)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val quoteButton = view.findViewById<Button>(R.id.btnShowQuote)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = HabitAdapter()
        recyclerView.adapter = adapter

        adapter.submitList(loadHabitsFromFile(requireContext()))

        addButton.setOnClickListener {
            findNavController().navigate(R.id.action_habitList_to_addHabit)
        }

        quoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_habitList_to_quoteFragment)
        }


        defaultButton.setOnClickListener {
            val defaultHabits = listOf(
                Habit("Drink Water", "08:00", "8 cups/day"),
                Habit("Read Book", "21:00", "30 mins/day"),
                Habit("Sleep", "23:30", "6 Hours")
            )
            saveHabitsToFile(requireContext(), defaultHabits)
            adapter.submitList(defaultHabits)
            //Toast.makeText(context, "Loaded default habits", Toast.LENGTH_SHORT).show()
        }
    }

}
