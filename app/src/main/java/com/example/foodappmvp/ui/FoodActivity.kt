package com.example.foodappmvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.foodappmvp.R
import com.example.foodappmvp.databinding.ActivityFoodBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityFoodBinding

    //Other
    private lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Nav controller
        navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
    }
}