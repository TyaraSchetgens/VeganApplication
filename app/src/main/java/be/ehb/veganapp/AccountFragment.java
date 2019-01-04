package be.ehb.veganapp;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import be.ehb.veganapp.DAO.GebruikerDAO;
import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.Model.Gebruiker;
import be.ehb.veganapp.Viewmodel.GebruikerViewModel;

public class AccountFragment extends Fragment {

    // Layout
    private GebruikerViewModel gebruikerViewModel;


    // Variable
    private Gebruiker gebruiker;

    // Textview ACCOUNT
    private TextView gebruikerNaamTextView;
    private TextView gebruikerWeekstreakTextView;
    private TextView gebruikerLevelTextView;
    private ProgressBar gebruikerErvaringProgressBar;
    //=============================================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenges, null);

        // Viewmodel
        gebruikerViewModel = ViewModelProviders.of(this).get(GebruikerViewModel.class);
        //gebruiker = MainActivity.gebruiker;

        return view;
    }
    //=============================================================
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*if (gebruiker == null) {
            Log.i("GebruikerFragment", "NULL");
        } else {
            Log.i("GebrukerFragment", "NOTNULL");
        }*/


        //getGebruikerCardUI();
        //setGebruikerCardUI();
    }

    //=============================================================
    private void getGebruikerCardUI() {
        gebruikerNaamTextView = (TextView) getView().findViewById(R.id.tv_gebruiker_naam);
        gebruikerWeekstreakTextView = (TextView) getView().findViewById(R.id.tv_gebruiker_weekstreak);
        gebruikerLevelTextView = (TextView) getView().findViewById(R.id.tv_gebruiker_level);
        gebruikerErvaringProgressBar = (ProgressBar) getView().findViewById(R.id.pb_gebruiker_ervaring);
    }

    private void setGebruikerCardUI() {
        gebruikerNaamTextView.setText(gebruiker.getNaam());
        gebruikerWeekstreakTextView.setText(toString().valueOf(gebruiker.getWeekStreak()));
        gebruikerLevelTextView.setText(toString().valueOf(gebruiker.getLevel()));
        gebruikerErvaringProgressBar.setProgress(gebruiker.getErvaring());
    }
    //=============================================================
}

//TODO: 12/12/2018 Add adapter and recyclerview