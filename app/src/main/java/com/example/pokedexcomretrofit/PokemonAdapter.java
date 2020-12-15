package com.example.pokedexcomretrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexcomretrofit.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolderPokemon> {
    private ArrayList<Pokemon> listPokemon;
    private Context getContext;

    public PokemonAdapter(Context getContext) {
        listPokemon = new ArrayList<>();
        this.getContext = getContext;
    }


    @NonNull
    @Override
    public ViewHolderPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, null, false);
        return new ViewHolderPokemon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPokemon holder, int position) {
        holder.setDados(listPokemon.get(position));
    }


    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public void add(Pokemon pokemon) {
        listPokemon.add(pokemon);
    }


    class ViewHolderPokemon extends RecyclerView.ViewHolder {
        TextView namePokemon;
        ImageView imgPokemon;

        ViewHolderPokemon(@NonNull View itemView) {
            super(itemView);
            namePokemon = itemView.findViewById(R.id.namePokemon);
            imgPokemon = itemView.findViewById(R.id.imgPokemon);


        }

        private void setDados(final Pokemon pokemon) {
            //setar os dados
            namePokemon.setText(pokemon.getName());
            Picasso.with(getContext).load("https://pokeapi.co/api/v2/pokemon/"+pokemon.getNumberImg()+".png");
        }


    }


}