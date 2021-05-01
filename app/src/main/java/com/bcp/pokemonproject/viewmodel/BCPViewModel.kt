package com.bcp.pokemonproject.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bcp.pokemonproject.data.entities.PokemonResponse
import com.bcp.pokemonproject.repository.BCPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.bcp.pokemonproject.remote.Result

@HiltViewModel
class BCPViewModel @Inject constructor(private val repository: BCPRepository) :
    BaseViewModel() {

    public val _character = MutableLiveData<PokemonResponse>()
    val character: LiveData<PokemonResponse> = _character

    fun doCharacterFetch(id: String) {
        _isViewLoading.postValue(true)

        viewModelScope.launch {

            val result: Result<PokemonResponse> = withContext(Dispatchers.IO) {
                repository.getAllCharacters(id)
            }


            _isViewLoading.postValue(false)

            when (result) {
                is Result.Success -> {
                    _character.value = result.data
                    print(_character.value)

                }
                is Result.ApiError -> _onMessageError.postValue(result.exception)

            }

        }

    }



}