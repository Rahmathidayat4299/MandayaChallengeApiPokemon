package com.api.mandayachallenge.ListPokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.api.mandayachallenge.model.Pokemon
import com.api.mandayachallenge.model.ResultPokemon
import com.api.mandayachallenge.service.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonViewModel :ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: RetroService = retrofit.create(RetroService::class.java)

    val pokemonList = MutableLiveData<List<ResultPokemon>>()

    fun getPokemonList(){
        val call = service.getPokemonList(20,0)

        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>,response: Response<Pokemon>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                call.cancel()
            }

        })
    }
}