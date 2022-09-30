package com.david.cardsapp.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.david.cardsapp.Pokemon;
import com.david.cardsapp.PokemonAPI;
import com.david.cardsapp.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<Pokemon> items = new ArrayList<Pokemon>();
        ArrayAdapter<Pokemon> adapter;

        //items = new ArrayList<Pokemon>(Arrays.asList(data));

        adapter = new ArrayAdapter<Pokemon>(

                getContext(),
                R.layout.lv_cards_row,
                R.id.txtTitle,
                items

        );

        binding.lvCards.setAdapter(adapter);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {

            PokemonAPI api = new PokemonAPI();
            api.getPokemons();

            ArrayList<Pokemon> Pokemons = api.getPokemons();

            handler.post(() -> {

                adapter.clear();
                adapter.addAll();

            });

            adapter.clear();
            adapter.addAll(Pokemons);

        });

        //Declarar permisos


        //ListView lvCards = view.findViewById(R.id.lvCards);
        //lvCards.setAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}