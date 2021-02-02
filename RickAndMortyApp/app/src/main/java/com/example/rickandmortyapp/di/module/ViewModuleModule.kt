package com.example.rickandmortyapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.di.factory.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory):
            ViewModelProvider.Factory
}