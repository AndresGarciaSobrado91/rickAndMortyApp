package com.example.rickandmortyapp.domain

import androidx.lifecycle.MediatorLiveData

abstract class MediatorUseCase<in P, R> {
    protected val result = MediatorLiveData<R>()

    // "open" in order to mock in tests
    open fun observe(): MediatorLiveData<R> {
        return result
    }

    abstract fun execute(parameters: P)
}