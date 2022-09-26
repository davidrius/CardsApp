package com.david.cardsapp.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.david.cardsapp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        String[] data = {

            "Los 400 golpes",
            "El odio",
            "El Padrino",
            "El Padrino Parte II",
            "Ocurrió cerca de su casa",
            "Infiltrados",
            "Umberto D."

        };

        items = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<String>(

              getContext(),
              R.layout.lv_cards_row,
              R.id.txtTitle,
              items

        );

        ListView lvCards = view.findViewById(R.id.lvCards);
        lvCards.setAdapter(adapter);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}