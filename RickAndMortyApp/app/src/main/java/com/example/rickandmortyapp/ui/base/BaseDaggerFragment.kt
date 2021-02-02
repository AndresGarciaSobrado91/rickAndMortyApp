package com.example.rickandmortyapp.ui.base

import com.example.rickandmortyapp.util.ui.LoadingViewManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseDaggerFragment : DaggerFragment() {

    @Inject
    lateinit var loadingViewManager: LoadingViewManager

    fun showLoading(message: String, autoClear: Boolean = true) = loadingViewManager.showLoading(message, autoClear)

    fun hideLoading() = loadingViewManager.hideLoading()

}