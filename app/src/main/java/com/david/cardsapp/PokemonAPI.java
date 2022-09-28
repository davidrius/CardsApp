package com.david.cardsapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonAPI {

    ArrayList<Pokemon> getPokemons() {

        String url = "https://pokeapi.co/api/v2/pokemon/";

        try {

            String result = HttpUtils.get(url);

            JSONObject jsonResult = new JSONObject(result); //convierto a JSON

            JSONArray results = jsonResult.getJSONArray("results"); //array de resultados que saco del JSON

            ArrayList<Pokemon> pokemons = new ArrayList<>();

            for (int i = 0; i < results.length(); i++) {

                JSONObject pokemon = results.getJSONObject(i); //recorro el array

                Pokemon pokemon = new Pokemon();

                pokemon.setName(pokemonJson.getString("name"));
                pokemon.setDetailsUrl(pokemonJson.getString("url")); //setDetailsUrl lo hemos creado en POkemon.java

                pokemons.add(pokemon);

                //ver logcat para verlo

                String resultDetails = HttpUtils.get(pokemon.getDetailsUrl());
                JSONObject jsonDetails = new JSONObject(resultDetails);

                pokemon.setHeight(jsonDetails.getInt("height"));


            }


            Log.e("XXX POKEMONS", pokemons.toString());
            //return pokemons;

        } catch (IOException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return pokemons;

    }
}
