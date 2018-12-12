package be.ehb.veganapp;

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

    //=============================================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week, null);

        // Week fragment recyclerview/adapter
        weekRecyclerview = (RecyclerView) view.findViewById(R.id.week_recyclerview);
        weekRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        new DatabaseTask().execute(); // Voer database Asynctask uit
        return view;
    }
    //=============================================================

    // Database asynctask
    private class DatabaseTask extends AsyncTask<Void, Void, Void> {
        // Wat uitgevoerd wordt voor de eigenlijke Asynctask
        // Eventueel laadscherm laten zien
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //Asynchrone taak uitvoeren uit de weg van de Main thread (voorkomt crashes!)
        // Eventueel netwerk calls maken/database communicatie
        @Override
        protected Void doInBackground(Void... voids) {
            // De roomdatabase die aangemaakt is, builden MAY INVOKE NULLPOINTER on getApplicationContext
            AppDatabase database = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "appDatabase").build();
            List<Weetje>weetjes = database.WeetjeDAO().loadAllWeetjes();
            adapter = new AppAdapter(weetjes);
            weekRecyclerview.setAdapter(adapter);
            Log.i("Main", "doInBackground: activated");
            return null;
        }

        // Wat uitgevoerd wordt nadat de Asynctask is uitgevoerd
        // Eventueel UI updaten
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
