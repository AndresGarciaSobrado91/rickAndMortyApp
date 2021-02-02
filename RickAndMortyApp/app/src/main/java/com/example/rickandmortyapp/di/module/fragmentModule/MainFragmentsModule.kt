package com.example.rickandmortyapp.di.module.fragmentModule

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.di.annotation.FragmentScoped
import com.example.rickandmortyapp.di.annotation.ViewModelKey
import com.example.rickandmortyapp.ui.MainViewModel
import com.example.rickandmortyapp.ui.fragments.DetailFragment
import com.example.rickandmortyapp.ui.fragments.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentsModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindDetailViewModel(viewModel: MainViewModel): ViewModel
}