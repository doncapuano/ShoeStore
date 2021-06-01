package com.udacity.shoestore.ui

import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(value: String): Double {
        return if (value.isNotEmpty()) {
            value.toDouble()
        } else {
            "0".toDouble()
        }
    }
}

//      Using Converter object for Double in two way binding instead of `` shortcut, tried to use
//      Converter to get rid of default value 0.0 for Double being displayed in Detail screen