package com.udacity.shoestore.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.ShoeViewModelFactory
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

//      lateinit delays initialization of var to offer null safety
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
//    Set up property delegation for viewModel in fragments w by ActivityViewModels()
    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        viewModelFactory = ShoeViewModelFactory()
//        ViewModelProvider - get the viewModel, pass in viewModelFactory
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListViewModel::class.java)

//        Sets up binding for the toolbar(w toolbar, don't need onSupportNavigateUp)
        toolbar = binding.toolbar
//        Finds the navController (each navHost has a navController)
        val navController = this.findNavController(R.id.nav_host_frag)
//        Set a Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(toolbar)

//        If appBarConfig is init, hooks up to navGraph and sets nav button
        appBarConfiguration = AppBarConfiguration(navController.graph)
//        Sets up toolbar w navController, updates title label, calls navigateUp
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
    }


}
