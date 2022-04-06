package com.api.mandayachallenge.ListPokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.api.mandayachallenge.R
import com.api.mandayachallenge.model.Pokemon
import com.api.mandayachallenge.model.ResultPokemon
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonListAdapter(val pokemonClick: (Int) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.SearchViewHolder>() {
    var pokemonList: List<ResultPokemon> = emptyList<ResultPokemon>()

    fun setData(list: List<ResultPokemon>) {
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"
        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }


    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}