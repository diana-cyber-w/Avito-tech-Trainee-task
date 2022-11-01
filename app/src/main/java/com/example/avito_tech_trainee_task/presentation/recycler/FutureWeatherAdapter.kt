package com.example.avito_tech_trainee_task.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avito_tech_trainee_task.domain.model.ForecastData

class FutureWeatherAdapter() : RecyclerView.Adapter<FutureWeatherViewHolder>() {

    private var items: List<ForecastData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutureWeatherViewHolder {
        return FutureWeatherViewHolder.fromParent(parent)
    }

    override fun onBindViewHolder(holder: FutureWeatherViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<ForecastData>) {
        items = data
        notifyDataSetChanged()
    }
}