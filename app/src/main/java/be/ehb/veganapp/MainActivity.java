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

import be.ehb.veganapp.DAO.ChallengeDAO;
import be.ehb.veganapp.Model.Challenge;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    // Een referentie naar de database.
    private AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BuildDatabase().execute(); // Voer database Asynctask uit

        //BottomNav
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_week);

        // Fragments
        loadFragment(new WeekFragment());
    }

    private class BuildDatabase extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // De roomdatabase die aangemaakt is, builden
            database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDatabase").build();
            return null;
        }
    }


    // laad fragment in de fragment container in MainActivity
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
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

    //Getter voor refentie naar database
    public AppDatabase getDatabase() {
        return database;
    }
}



