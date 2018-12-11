package be.ehb.veganapp;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    // Recyclerview variables
    RecyclerView weekRecyclerview;
    RecyclerView.Adapter adapter;

    // Araaylist test
    //ArrayList<Weetje> weetjes;
    AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DatabaseTask().execute(); // Voer database Asynctask uit

        //=============================================================

        // Week fragment recyclerview/adapter
        weekRecyclerview = (RecyclerView) findViewById(R.id.week_recyclerview);
        weekRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        /* Test loop
       weetjes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Weetje weetje = new Weetje(i, "weetje nr" + i, "milieu");
            weetjes.add(weetje);
        }*/

        // TODO: 11/12/2018 check out RxJava and implement this on the database call
        /*// De roomdatabase die aangemaakt is, builden
        AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDatabase")
                .allowMainThreadQueries() // DIT MAG NORMAAL DUS NIET
                .build();*/


        /*List<Weetje> weetjes = database.WeetjeDAO().loadAllWeetjes();*/

       /* adapter = new AppAdapter(weetjes);
        weekRecyclerview.setAdapter(adapter);*/

        //=============================================================

        //BottomNav
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_week);

        // Fragments
        //loadFragment(new WeekFragment());
        // TODO: 06/12/2018 Place back fragments after testing

    }

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
            // De roomdatabase die aangemaakt is, builden
            AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDatabase").build();
            List<Weetje> weetjes = database.WeetjeDAO().loadAllWeetjes();
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


    // laad fragment in de fragment container in MainActivity
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        } else {
            return false;
        }
    }

    // Switch case om te checken welk navItem de gebruiker geselecteerd heeft
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.navigation_challenges:
                fragment = new ChallengeFragment();
                break;

            case R.id.navigation_week:
                fragment = new WeekFragment();
                break;

            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }
}



