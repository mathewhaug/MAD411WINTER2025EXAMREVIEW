package com.matthaug.mad411winter2025examreview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matthaug.mad411winter2025examreview.R
import com.matthaug.mad411winter2025examreview.models.Habit

class HabitAdapter : ListAdapter<Habit, HabitAdapter.HabitViewHolder>(DIFF_CALLBACK) {

    //Companion object, because why not - Makes copying from me a little harder
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Habit>() {
            override fun areItemsTheSame(oldItem: Habit, newItem: Habit) = oldItem.name == newItem.name
            override fun areContentsTheSame(oldItem: Habit, newItem: Habit) = oldItem == newItem
        }
    }

    class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.habit_name)
        val time = itemView.findViewById<TextView>(R.id.habit_time)
        val goal = itemView.findViewById<TextView>(R.id.habit_goal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_habit, parent, false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = getItem(position)
        holder.name.text = habit.name
        holder.time.text = habit.time
        holder.goal.text = habit.goal
    }
}
