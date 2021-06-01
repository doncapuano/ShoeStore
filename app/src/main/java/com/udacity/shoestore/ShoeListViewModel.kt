package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.model.Shoe
import com.udacity.shoestore.views.*
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    // LiveData object
    private val _shoeLiveData = MutableLiveData<MutableList<Shoe>>()
    val shoeLiveData: LiveData<MutableList<Shoe>>
        get() = _shoeLiveData

    init {
        Timber.i("ViewModel Created")
        _shoeLiveData.value = mutableListOf()
    }

    /*
       Functions for listener bindings in views for onClick listeners
       Safe Args Navigation (adds Directions to fragment class name)
       Returns NavController
       */

    fun saveShoeListButton(shoe: Shoe, view: View) {
        shoe.let {
            _shoeLiveData.value!!.add(it)
        }
        view.findNavController()
            .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

    fun showWelcomeScreen(view: View) {
        view.findNavController()
            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())
    }

    fun showInstructionsScreen(view: View) {
        view.findNavController()
            .navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment())
    }

    fun showShoeListScreen(view: View) {
        view.findNavController()
            .navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
    }

    fun showShoeDetailScreen(view: View) {
        view.findNavController()
            .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
    }

    fun cancelButton(view: View) {
        view.findNavController()
            .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

}