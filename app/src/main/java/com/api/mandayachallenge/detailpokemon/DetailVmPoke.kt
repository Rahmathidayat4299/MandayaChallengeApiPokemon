package com.api.mandayachallenge.detailpokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.api.mandayachallenge.model.DetailPokemon
import com.api.mandayachallenge.service.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailVmPoke() : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: RetroService = retrofit.create(RetroService::class.java)

    val pokemonInfo = MutableLiveData<DetailPokemon>()

    fun getPokemonInfo(id: Int) {
        val call = service.getPokemonInfo(id)

        call.enqueue(object : Callback<DetailPokemon> {
            override fun onResponse(call: Call<DetailPokemon>, response: Response<DetailPokemon>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                }
            }

            override fun onFailure(call: Call<DetailPokemon>, t: Throwable) {
                call.cancel()
            }

        })
    }
}