package com.example.taskmanager_4m.ui.home.adapter


import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.taskmanager_4m.App
import com.example.taskmanager_4m.R
import com.example.taskmanager_4m.databinding.ItemTaskBinding
import com.example.taskmanager_4m.model.Task


class TaskAdapter : Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()
    private val viewTypeWhite = 1
    private val viewTypeBlack = 2

    fun addData(newList: List<Task>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            viewTypeWhite
        } else {
            viewTypeBlack
        }
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc

            if (itemViewType == viewTypeWhite) {
                itemView.setBackgroundColor(Color.WHITE)
                binding.tvTitle.setTextColor(Color.BLACK)
                binding.tvDesc.setTextColor(Color.BLACK)
            } else {
                itemView.setBackgroundColor(Color.BLACK)
                binding.tvDesc.setTextColor(Color.WHITE)
                binding.tvTitle.setTextColor(Color.WHITE)
            }
            binding.root.setOnLongClickListener {
                val alertDialogBuilder = AlertDialog.Builder(itemView.context)

                alertDialogBuilder.setTitle(R.string.deleteTask)
                alertDialogBuilder.setMessage(R.string.areYouSure)

                alertDialogBuilder.setPositiveButton(R.string.yes) { _, _ ->
                    App.db.taskDao().delete(task)
                    list.remove(task)
                    notifyDataSetChanged()

                }
                alertDialogBuilder.setNegativeButton(R.string.no) { _, _ ->

                }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }


}