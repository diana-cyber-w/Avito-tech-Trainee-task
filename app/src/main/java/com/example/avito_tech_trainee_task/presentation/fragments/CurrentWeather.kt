package com.example.avito_tech_trainee_task.presentation.fragments

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.avito_tech_trainee_task.DaggerApplication
import com.example.avito_tech_trainee_task.R
import com.example.avito_tech_trainee_task.databinding.CurrentWeatherLayoutBinding
import com.example.avito_tech_trainee_task.presentation.SharedViewModel
import com.example.avito_tech_trainee_task.presentation.recycler.FutureWeatherAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CurrentWeather : Fragment() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private val binding: CurrentWeatherLayoutBinding by viewBinding(CurrentWeatherLayoutBinding::bind)
    private val adapter by lazy { FutureWeatherAdapter() }

    @Inject
    lateinit var viewModel: SharedViewModel

    init {

        DaggerApplication.appComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        getLocation()
        return inflater.inflate(R.layout.current_weather_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObserves()
    }

    override fun onResume() {
        super.onResume()
        binding.searchButton.setOnClickListener {
            viewModel.loadCurrentWeather(binding.searchText.text.toString())
            initObserves()
        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
    }

    private fun initObserves() {
        viewModel.currentWeather.observe(viewLifecycleOwner) { currentWeather ->
            if (currentWeather != null) {
                binding.locationName.text = currentWeather.locationName
                binding.temperature.text = "${currentWeather.tempC}°C"
                binding.conditionText.text = currentWeather.conditionText
                binding.humidity.text = "${currentWeather.humidity}%"
                val imageUri = currentWeather.conditionIcon.split("/")
                val uri = imageUri[imageUri.lastIndex].split(".")
                binding.weatherIcon.setImageURI(Uri.parse("android.resource://" + requireActivity().packageName + "/drawable/" + "image_${uri[0]}"))
                adapter.submitList(currentWeather.forecast)
                binding.lastUpdate.text = currentWeather.lastUpdated.split(" ")[1]
                val date = currentWeather.lastUpdated.split(" ")
                binding.day.text = getDayString(stringToDate(date[0]), Locale("ru"))
            }
        }
    }

    private fun getDayString(date: Date, locale: Locale): String {
        val formatter = SimpleDateFormat("EEEE", locale)
        return formatter.format(date)
    }

    private fun stringToDate(dateString: String): Date {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        return formatter.parse(dateString)
    }

    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                REQUEST_CODE
            )
            return
        }

        val location = fusedLocationProviderClient.lastLocation
        location.addOnSuccessListener { thisLocation ->
            if (thisLocation != null) {
                latitude = thisLocation.latitude
                longitude = thisLocation.longitude
                viewModel.loadCurrentWeather("$latitude, $longitude")
            }
        }
    }

    companion object {
        private const val REQUEST_CODE = 101
    }
}