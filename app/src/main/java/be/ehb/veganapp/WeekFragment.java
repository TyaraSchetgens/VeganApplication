package be.ehb.veganapp;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
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

public class WeekFragment extends Fragment {

    //Variables
    RecyclerView weekRecyclerview;
    RecyclerView.Adapter adapter;

    AppDatabase mainDatabase;

    //=============================================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week, null);

        // Week fragment recyclerview/adapter
        weekRecyclerview = (RecyclerView) view.findViewById(R.id.week_recyclerview);
        weekRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainDatabase = ((MainActivity)getActivity()).getDatabase();
        new DatabaseTask().execute(); // Voer database Asynctask uit
        return view;
    }
    //=============================================================

    // Database asynctask
    private class DatabaseTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            List<Weetje>weetjes = mainDatabase.WeetjeDAO().loadAllWeetjes();
            adapter = new AppAdapter(weetjes);
            weekRecyclerview.setAdapter(adapter);
            Log.d("weekFragment", "doInBackground: activated");
            return null;
        }
    }
}
