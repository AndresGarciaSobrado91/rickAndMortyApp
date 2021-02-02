package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.data.remote.api.ApiService
import com.example.rickandmortyapp.model.Character
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val apiService : ApiService
) {

    suspend fun getCharacters(characterIdList : String) : Response<List<Character>> {
        return apiService.getCharacters(characterIdList)
    }

}