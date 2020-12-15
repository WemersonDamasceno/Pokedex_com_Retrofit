package com.example.pokedexcomretrofit.models;

import java.util.ArrayList;

public class PokemonResponse {
    private ArrayList<Pokemon> results;

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }
}
