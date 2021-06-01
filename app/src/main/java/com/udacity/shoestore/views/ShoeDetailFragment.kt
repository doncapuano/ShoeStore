package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.model.Shoe
import com.udacity.shoestore.ui.Converter


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
// Set the viewModel for databinding - this allows the bound layout access to all of the
// data in the viewModel (such as the buttons)
        binding.shoeListViewModel = viewModel
// Specify the current activity as the lifecycle owner of the binding. This is used so that
// the binding can observe LiveData updates
        binding.lifecycleOwner = this

        val shoeArgs = ShoeDetailFragmentArgs.fromBundle(requireArguments()).shoe
//          Bind shoeArgs to shoe and do a null safety check
//        Using Converter in attempt to not show default value for Double(it's still showing)
        binding.shoe = shoeArgs ?: Shoe(
            "",
            _size = Converter.stringToDouble(""),
            "",
            ""
        )

        return binding.root
    }


}