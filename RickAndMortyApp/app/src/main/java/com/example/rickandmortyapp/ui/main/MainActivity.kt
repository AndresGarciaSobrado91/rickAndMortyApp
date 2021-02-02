package com.example.rickandmortyapp.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.ui.base.DaggerAppCompatActivity
import com.example.rickandmortyapp.util.ui.LoadingViewManager
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var loadingViewManager: LoadingViewManager

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        loadingViewManager.loadingView = findViewById(R.id.loadingView)
    }
}