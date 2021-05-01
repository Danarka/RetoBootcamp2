package com.bcp.pokemonproject.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PokemonResponse(
    val name: String,
    val sprites: List<Sprite>
) : Parcelable

@Parcelize
data class Sprite (
    val back_default: String
): Parcelable
