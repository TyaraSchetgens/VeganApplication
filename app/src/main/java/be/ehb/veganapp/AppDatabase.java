package be.ehb.veganapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import be.ehb.veganapp.DAO.ChallengeDAO;
import be.ehb.veganapp.DAO.GebruikerDAO;
import be.ehb.veganapp.DAO.GekozenChallengeDAO;
import be.ehb.veganapp.DAO.TrofeeDAO;
import be.ehb.veganapp.DAO.VoltooideChallengeDAO;
import be.ehb.veganapp.DAO.WeetjeDAO;

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
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
