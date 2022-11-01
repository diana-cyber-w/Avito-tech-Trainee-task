package com.example.avito_tech_trainee_task.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.avito_tech_trainee_task.R
import com.example.avito_tech_trainee_task.databinding.WeatherItemLayoutBinding
import com.example.avito_tech_trainee_task.domain.model.ForecastData
import java.text.SimpleDateFormat
import java.util.*

class FutureWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun fromParent(parent: ViewGroup) =
            FutureWeatherViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.weather_item_layout, parent, false)
            )
    }

    private val binding: WeatherItemLayoutBinding by viewBinding(WeatherItemLayoutBinding::bind)
    private val itemHumidity by lazy { binding.itemHumidity }
    private val weekDay by lazy { binding.weekDay }
    private val itemWeatherTemperature by lazy { binding.itemWeatherTemperature }

    fun bindView(item: ForecastData) {
        itemHumidity.text = "${item.humidity}%"
        itemWeatherTemperature.text = "${item.maxTempC}°C"
        val date = item.date.split(" ")
        weekDay.text = getDayString(stringToDate(date[0]), Locale("ru"))
    }

    private fun getDayString(date: Date, locale: Locale): String {
        val formatter = SimpleDateFormat("EEEE", locale)
        return formatter.format(date)
    }

    private fun stringToDate(dateString: String): Date {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        return formatter.parse(dateString)
    }
}