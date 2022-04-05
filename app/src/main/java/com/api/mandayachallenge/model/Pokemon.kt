package com.api.mandayachallenge.model


import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<ResultPokemon>
)