package com.bcp.pokemonproject.remote
import com.bcp.pokemonproject.rest.ApiService
import javax.inject.Inject

class BCPRemoteDataSource @Inject constructor(
    private val service: ApiService
) : BaseDataSource() {

    suspend fun getAllCharacters(id: String) =
            safeApiCall { service.getAllCharacters(id = id) }

}


