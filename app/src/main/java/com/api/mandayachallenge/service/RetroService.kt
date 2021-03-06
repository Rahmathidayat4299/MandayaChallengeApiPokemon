package com.api.mandayachallenge.service

import com.api.mandayachallenge.model.DetailPokemon
import com.api.mandayachallenge.model.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<DetailPokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<Pokemon>
}