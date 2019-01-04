package be.ehb.veganapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;


import be.ehb.veganapp.DAO.ChallengeDAO;
import be.ehb.veganapp.DAO.GebruikerDAO;
import be.ehb.veganapp.DAO.GekozenChallengeDAO;
import be.ehb.veganapp.DAO.TrofeeDAO;
import be.ehb.veganapp.DAO.VoltooideChallengeDAO;
import be.ehb.veganapp.DAO.WeetjeDAO;
import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.Model.Gebruiker;
import be.ehb.veganapp.Model.GekozenChallenge;
import be.ehb.veganapp.Model.Trofee;
import be.ehb.veganapp.Model.VoltooideChallenge;
import be.ehb.veganapp.Model.Weetje;

@Database(entities = {Gebruiker.class, Challenge.class, Trofee.class, Weetje.class, GekozenChallenge.class, VoltooideChallenge.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GebruikerDAO gebruikerDAO();
    public abstract ChallengeDAO challengeDAO();
    public abstract TrofeeDAO trofeeDAO();
    public abstract WeetjeDAO WeetjeDAO();
    public abstract GekozenChallengeDAO gekozenChallengeDAO();
    public abstract VoltooideChallengeDAO voltooideChallengeDAO();

    // Dit zorgt ervoor dat de Appdatabase een singleton wordt. Voorkomt dat meerdere instanties tegenlijkertijd openstaan
    private static volatile AppDatabase INSTANCE;
    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Wanneer er nog geen database bestaat, maak deze hier >
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .fallbackToDestructiveMigration()
                            //.addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //===================================================================
    // Testing purposes snel de database populaten
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final GebruikerDAO gebruikerDAO;

        PopulateDbAsync(AppDatabase db) {
            gebruikerDAO = db.gebruikerDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            Gebruiker gc = new Gebruiker("Jane Doe", 1, 1, 0);
            gebruikerDAO.insertGebruiker(gc);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.i("APPDATABASE", "werkt");
        }
    }
}

