package ru.izhxx.deliveryapp.presenter.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val cities: List<String> = mutableListOf(
        "Moscow", "Izhevsk", "Kazan")

    fun getCities(): List<String> = cities
}