package com.api.mandayachallenge.model


import com.google.gson.annotations.SerializedName

data class ResultPokemon(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)