package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShoeViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListViewModel::class.java)) {
            return ShoeListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}