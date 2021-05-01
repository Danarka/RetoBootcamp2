package com.bcp.pokemonproject.rest

import com.bcp.pokemonproject.data.entities.PokemonResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("pokemon/{id}")
    suspend fun getAllCharacters(@Path("id") id: String): Response<PokemonResponse>

}