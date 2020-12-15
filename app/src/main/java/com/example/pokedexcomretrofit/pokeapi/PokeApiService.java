package com.example.pokedexcomretrofit.pokeapi;

import com.example.pokedexcomretrofit.models.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonResponse> getListPokemons();

}
