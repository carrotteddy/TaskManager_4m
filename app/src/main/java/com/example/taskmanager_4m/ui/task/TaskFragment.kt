package com.example.taskmanager_4m.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager_4m.R
import com.example.taskmanager_4m.databinding.FragmentTaskBinding
import com.example.taskmanager_4m.model.Task


class TaskFragment : Fragment() {

   private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if(binding.etTitle.text.isNotEmpty() && binding.etDesc.text.isNotEmpty()) {
                val data = Task(
                    title = binding.etTitle.text.toString(),
                    desc = binding.etDesc.text.toString()
                )
                setFragmentResult(RESULT_KEY, bundleOf(TASK_KEY to data))
                findNavController().navigateUp()
            }else{
                binding.etTitle.error = "Поля не могут быть пустыми"
                binding.etDesc.error = "Поля не могут быть пустыми"
            }


        }
    }
    companion object{
        const val  RESULT_KEY = "result.key"
        const val  TASK_KEY = "task.key"
    }

}