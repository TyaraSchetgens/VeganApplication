package be.ehb.veganapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import be.ehb.veganapp.Adapter.ChallengeAdapter;
import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.Viewmodel.ChallengeViewModel;

public class ChallengeFragment extends Fragment {

    //Variables
    RecyclerView challengeRecyclerview;
    private ChallengeViewModel viewModel;

    //=============================================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenges, null);

        // Challenge fragment recyclerview/ adapter
        challengeRecyclerview = (RecyclerView) view.findViewById(R.id.challenge_recyclerview);
        challengeRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ChallengeAdapter adapter = new ChallengeAdapter();
        challengeRecyclerview.setAdapter(adapter);  // Default deze lijst is leeg! Daarom in onChanged

        // VIewmodel
        viewModel = ViewModelProviders.of(this).get(ChallengeViewModel.class);
        viewModel.getAllChallenges().observe(this, new Observer<List<Challenge>>() {
            @Override
            public void onChanged(@Nullable List<Challenge> challenges) {
                adapter.setChallenges(challenges);
            }
        });
        return view;
    }
    //=============================================================
}
