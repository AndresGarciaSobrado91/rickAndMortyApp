package com.example.rickandmortyapp.data.remote.api

import com.example.rickandmortyapp.model.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character/{characterList}")
    suspend fun getCharacters(@Path("characterList") characterList : String): Response<List<Character>>

    companion object {
        const val API_URL = "https://rickandmortyapi.com/api/"
    }
}