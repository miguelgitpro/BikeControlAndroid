package com.jrivera.bikecontrolandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import com.jrivera.bikecontrolandroid.R;
import com.jrivera.bikecontrolandroid.adapters.HistoryAdapter;
import com.jrivera.bikecontrolandroid.components.CardViews;


/**
 * Created by ANDRES on 28-08-2016.
 */
public class SecondHistoryFragment extends Fragment {

    public SecondHistoryFragment() {
        // Require empty public constructor
    }

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout linearView2 = (LinearLayout)inflater.inflate(R.layout.fragmenthistory, container, false);
        // Inicializar Animes
        ArrayList<CardViews> items = new ArrayList<CardViews>();
        items.add(new CardViews(R.drawable.logobc, "20 Minutos", "Osorno - 11:30 AM"));
        items.add(new CardViews(R.drawable.logobc, "23 Minutos", "Osorno - 12:30 AM"));
        items.add(new CardViews(R.drawable.logobc, "30 Minutos", "Osorno - 10:30 AM"));
        items.add(new CardViews(R.drawable.logobc, "10 Minutos", "Osorno - 17:30 AM"));
        items.add(new CardViews(R.drawable.logobc, "15 Minutos", "Osorno - 11:30 AM"));

// Obtener el Recycler
        recycler = (RecyclerView)linearView2.findViewById(R.id.recycler);
        //recycler.setHasFixedSize(true);
// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new HistoryAdapter(items);
        recycler.setAdapter(adapter);

        return linearView2;

    }


}
