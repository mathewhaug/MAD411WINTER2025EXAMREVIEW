package com.matthaug.mad411winter2025examreview.fragments

import com.matthaug.mad411winter2025examreview.R
import com.matthaug.mad411winter2025examreview.helpers.loadHabitsFromFile
import com.matthaug.mad411winter2025examreview.helpers.saveHabitsToFile
import com.matthaug.mad411winter2025examreview.models.Habit
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddHabitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_add_habit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameInput = view.findViewById<EditText>(R.id.editHabitName)
        val goalInput = view.findViewById<EditText>(R.id.editHabitGoal)
        val timePicker = view.findViewById<TimePicker>(R.id.habitTimePicker)
        val saveBtn = view.findViewById<Button>(R.id.btnSaveHabit)

        saveBtn.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val goal = goalInput.text.toString().trim()
            val time = String.format("%02d:%02d", timePicker.hour, timePicker.minute)

            if (name.isNotEmpty() && goal.isNotEmpty()) {
                val habit = Habit(name, time, goal)
                val habits = loadHabitsFromFile(requireContext()).toMutableList()
                habits.add(habit)
                saveHabitsToFile(requireContext(), habits)
                Toast.makeText(requireContext(), "Habit saved!", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
