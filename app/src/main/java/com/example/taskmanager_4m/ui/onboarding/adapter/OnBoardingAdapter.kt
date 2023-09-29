package com.example.taskmanager_4m.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager_4m.databinding.ItemOnboardingBinding
import com.example.taskmanager_4m.model.OnBoarding
import java.util.zip.Inflater

class OnBoardingAdapter : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    val data = arrayListOf(
        OnBoarding("", "title 1", "desc 1"),
        OnBoarding("", "title 2", "desc 2"),
        OnBoarding("", "title 3", "desc 3")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])

    }


    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc

        }
    }


}