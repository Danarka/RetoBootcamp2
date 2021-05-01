package com.bcp.pokemonproject.repository

import com.bcp.pokemonproject.data.entities.PokemonResponse
import com.bcp.pokemonproject.remote.BCPRemoteDataSource
import com.bcp.pokemonproject.remote.Result
import javax.inject.Inject

class BCPRepository @Inject constructor(
    private val remoteDataSource: BCPRemoteDataSource
) {


    suspend fun getAllCharacters(id: String): Result<PokemonResponse> = remoteDataSource.getAllCharacters(id)


}


