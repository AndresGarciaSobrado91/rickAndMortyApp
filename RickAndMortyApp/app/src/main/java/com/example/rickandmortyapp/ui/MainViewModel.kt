package com.example.rickandmortyapp.ui

import androidx.lifecycle.LiveData
import com.example.rickandmortyapp.domain.GetCharactersUseCase
import com.example.rickandmortyapp.domain.GetCharactersUseCaseParams
import com.example.rickandmortyapp.domain.GetCharactersUseCaseResult
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.ui.base.ScopedViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ScopedViewModel() {

    var characterList : List<Character> = listOf()
        get() = field
        private set

    private var _getCharactersResultObservable = getCharactersUseCase.observe()
    val charactersResult : LiveData<GetCharactersUseCaseResult>
     get() = _getCharactersResultObservable


    init {
        getCharacters()
    }

    fun setCharacterList(characterList : List<Character>?){
        if (characterList != null) this.characterList = characterList
    }

    private fun getCharacters(){
        getCharactersUseCase.execute(
            GetCharactersUseCaseParams.GetData(
                coroutineScope,
                Dispatchers.IO
            )
        )
    }
}