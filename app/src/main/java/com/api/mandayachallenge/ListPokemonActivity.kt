package com.api.mandayachallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.api.mandayachallenge.ListPokemon.PokemonListAdapter
import com.api.mandayachallenge.ListPokemon.PokemonViewModel
import kotlinx.android.synthetic.main.list_pokemon.*

class ListPokemonActivity : AppCompatActivity() {
    private lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokemon)
        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        listPokemon()
    }

    private fun listPokemon() {
        pokelistRecyclerView.layoutManager = LinearLayoutManager(this)
        pokelistRecyclerView.adapter = PokemonListAdapter {
            val intent = Intent(this, PokeInfoActivity::class.java)
            intent.putExtra("id",it)
            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(this, Observer { list ->
            (pokelistRecyclerView.adapter as PokemonListAdapter).setData(list)
        })
    }
}