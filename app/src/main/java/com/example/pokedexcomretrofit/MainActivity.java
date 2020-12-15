package com.example.pokedexcomretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokedexcomretrofit.models.Pokemon;
import com.example.pokedexcomretrofit.models.PokemonResponse;
import com.example.pokedexcomretrofit.pokeapi.PokeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //para consumir a api
    Retrofit retrofit;
    RecyclerView recyclerView;
    PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcListPokemons);
        adapter = new PokemonAdapter(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setReverseLayout(false);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        //Inicializando o retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obterDados();


    }

    private void obterDados() {
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokemonResponse> pokemonResponseCall = service.getListPokemons();


        //Enfileirar
        pokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                //Quando a chamada tiver um retorno
                if(response.isSuccessful()){
                    PokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> listPokemons = pokemonResponse.getResults();

                    for(int i = 0; i<listPokemons.size();i++){
                        Pokemon p = listPokemons.get(i);
                        adapter.add(p);
                        adapter.notifyDataSetChanged();
                    }

                }else {
                    Log.i("teste", "Erro de retorno: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                //Quando na chamada acontecer alguma falha
                Log.i("teste", "Erro: "+t.getMessage());
            }
        });

    }
}