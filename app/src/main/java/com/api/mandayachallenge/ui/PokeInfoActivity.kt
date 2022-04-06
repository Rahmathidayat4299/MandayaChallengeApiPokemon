package com.api.mandayachallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.api.mandayachallenge.R
import com.api.mandayachallenge.detailpokemon.DetailVmPoke
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_poke_info.*

class PokeInfoActivity : AppCompatActivity() {
    lateinit var viewModel: DetailVmPoke
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_info)

        viewModel = ViewModelProvider(this).get(DetailVmPoke::class.java)

        detailUIPokemon()
    }

    private fun detailUIPokemon() {
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, Observer { detailpokemon ->
            nameTextView.text = detailpokemon.name
            heightText.text = "Altura: ${detailpokemon.height / 10.0}m"
            weightText.text = "Peso: ${detailpokemon.weight / 10.0}"
            Glide.with(this).load(detailpokemon.sprites.frontDefault).into(imageView)
        })
    }
}
