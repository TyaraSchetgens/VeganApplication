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

import java.util.concurrent.ExecutionException;

import be.ehb.veganapp.DAO.ChallengeDAO;
import be.ehb.veganapp.DAO.GebruikerDAO;
import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.Model.Gebruiker;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    // Een referentie naar de database.
    private AppDatabase database;
    protected GebruikerDAO gebruikerDAO;

    // Gebruiker
    private int userId;
    public static Gebruiker gebruiker;


    //----------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BuildDatabase().execute(); // Voer database Asynctask uit

        // Find gebruiker
        gebruikerDAO = database.gebruikerDAO();
        userId = 1;
        getGebruikerbyId(userId);

        Log.i("MAIN", "onCreate: " + gebruiker.getNaam());

        //BottomNav
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_week);

        // Fragments
        loadFragment(new WeekFragment());
    }
    //----------------------------------------------------------------------------------------

    private class BuildDatabase extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // De roomdatabase die aangemaakt is, builden
            database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDatabase").build();
            return null;
        }
    }

    // ------
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
    // ------

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
    // ------

    // Get gebruikerById. Nodig voor de lifetime van hele app
    public Gebruiker getGebruikerbyId(int id) {
        Gebruiker g = null;
        try {
            g = new GetGebruikerByIdAsyncTask(gebruikerDAO).execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return g;
    }

    private class GetGebruikerByIdAsyncTask extends AsyncTask<Integer, Void, Gebruiker> {
        private GebruikerDAO gebruikerDAO;

        public GetGebruikerByIdAsyncTask(GebruikerDAO gebruikerDAO) {
            this.gebruikerDAO = gebruikerDAO;
        }

        @Override
        protected Gebruiker doInBackground(final Integer... params) {
            Gebruiker g;
            g = gebruikerDAO.getGebruikerById(params[0]);
            return  g;
        }

        @Override
        protected void onPostExecute(Gebruiker gebruiker) {
            Log.i("REPO", "onPostExecute: " + gebruiker.getNaam());
        }

    }
}



