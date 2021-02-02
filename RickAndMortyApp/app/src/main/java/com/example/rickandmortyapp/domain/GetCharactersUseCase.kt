package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.repository.CharacterRepository
import com.example.rickandmortyapp.model.Character
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : MediatorUseCase<GetCharactersUseCaseParams, GetCharactersUseCaseResult>() {

    override fun execute(parameters: GetCharactersUseCaseParams) {
        result.postValue(GetCharactersUseCaseResult.Loading)
        when(parameters){
            is GetCharactersUseCaseParams.GetData -> getData(parameters)
        }
    }

    private fun getData(parameters: GetCharactersUseCaseParams.GetData) {
        parameters.coroutineScope.launch {
            withContext(parameters.dispatcher) {
                getData()
            }
        }
    }

    private suspend fun getData(){
        val response = characterRepository.getCharacters("1,2")
        result.postValue(GetCharactersUseCaseResult.Result(response.body()))
    }
}


sealed class GetCharactersUseCaseParams{
    class GetData(
        val coroutineScope: CoroutineScope,
        val dispatcher: CoroutineDispatcher
    ) : GetCharactersUseCaseParams()
}

sealed class GetCharactersUseCaseResult {
    object Loading : GetCharactersUseCaseResult()
    data class Result(val characterList: List<Character>?) : GetCharactersUseCaseResult()
}