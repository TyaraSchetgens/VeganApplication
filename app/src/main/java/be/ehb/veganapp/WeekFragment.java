package be.ehb.veganapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import be.ehb.veganapp.Adapter.WeetjeAdapter;
import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.Model.Weetje;

public class WeekFragment extends Fragment {

    //Variables
    RecyclerView weekRecyclerview;
    private WeetjeViewModel viewModel;

    //=============================================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week, null);

        // Week fragment recyclerview/adapter
        weekRecyclerview = (RecyclerView) view.findViewById(R.id.weetje_recyclerview);
        weekRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        final WeetjeAdapter adapter = new WeetjeAdapter();
        weekRecyclerview.setAdapter(adapter);

        // TODO: 16/12/2018 random weetje displayen EN enkel een per view

        // VIewmodel
        viewModel = ViewModelProviders.of(this).get(WeetjeViewModel.class);
        viewModel.getAllWeetjes().observe(this, new Observer<List<Weetje>>() {
            @Override
            public void onChanged(@Nullable List<Weetje> weetjes) {
                adapter.setWeetjes(weetjes);
            }
        });

        return view;
    }
    //=============================================================

    /*// Database asynctask
    private class DatabaseTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            List<Weetje>weetjes = mainDatabase.WeetjeDAO().loadAllWeetjes();
            adapter = new WeetjeAdapter(weetjes);
            weekRecyclerview.setAdapter(adapter);
            Log.d("weekFragment", "doInBackground: activated");
            return null;
        }
    }*/
}
