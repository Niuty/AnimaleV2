package com.example.animale.Fracments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animale.R;
import com.example.animale.Adapter.Adapter;
import com.example.animale.model.Entertainment;
import com.example.animale.model.ModelAmerica;
import com.example.animale.model.ModelAsia;
import com.example.animale.model.ModelAustralia;
import com.example.animale.model.ModelEuropa;


import java.util.ArrayList;
import java.util.List;

public class FragmentRecyclerView extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        Log.e("fragmentRV", "onCreateView: ");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.RV_Animals);

        List<Entertainment> animals = new ArrayList<>();
        Log.e("FragmentRecyclerView", "onViewCreated:  merge" );

        animals.add(new ModelEuropa("Urs", "Europa"));
        animals.add(new ModelAsia("Urs", "Europa"));
        animals.add(new ModelAmerica("Urs", "Europa"));
        animals.add(new ModelAustralia("Urs", "Europa"));
        animals.add(new ModelEuropa("Urs", "Europa"));
        animals.add(new ModelEuropa("Urs", "Europa"));
        animals.add(new ModelEuropa("Urs", "Europa"));

        //LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);

        Adapter adapter = new Adapter(animals);

        recyclerView.setAdapter(adapter);
        Log.e("FragmentRV", "onViewCreated: dasdadadadsasdasdas");


    }
}
