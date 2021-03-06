package com.udacity.shoestore.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import kotlinx.android.parcel.Parcelize
import com.udacity.shoestore.BR


//      Bind the data to a data class to make the data avail to the views
@Parcelize
data class Shoe(
    private var _name: String,
    private var _size: Double,
    private var _company: String,
    private var _description: String,
    private val _images: List<String> = mutableListOf()
) : Parcelable, BaseObservable() {

//    Extending BaseObservable class in a data class to convert it to an Observable class. Using @Bindable
//    annotation on getters for DataBinding, notifyPropertyChanged(BR.) on setters to reflect new value.
//    BR class is class generated by DataBinding for storing reactive values.

    var name: String
        @Bindable get() = _name
        set(value) {
            if (_name != value)
                _name = value
            notifyPropertyChanged(BR.name)
        }

    var size: Double
    @Bindable get() = _size
    set(value) {
        if (_size != value)
            _size = value
        notifyPropertyChanged(BR.size)
    }

    var company: String
    @Bindable get() = _company
    set(value) {
        if (_company != value)
            _company = value
        notifyPropertyChanged(BR.company)
    }

    var description: String
    @Bindable get() = _description
    set(value) {
        if (_description != value)
            _description = value
        notifyPropertyChanged(BR.description)
    }

//    Using PropertyChangeRegistry to help with editing Double for Shoe Size in Shoe Detail Screen
//    (Cursor was not working properly without this code)
    private val propertyChangeRegistry = PropertyChangeRegistry()

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        propertyChangeRegistry.remove(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        propertyChangeRegistry.add(callback)
    }
}
