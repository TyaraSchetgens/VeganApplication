package be.ehb.veganapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import be.ehb.veganapp.DAO.ChallengeDAO;
import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.AppDatabase;


public class ChallengeRepository {
    private ChallengeDAO challengeDAO;
    private LiveData<List<Challenge>> allChallenges;        // Used to return all Challenges

    public ChallengeRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);

        //Challenges
        challengeDAO = database.challengeDAO();
        allChallenges = challengeDAO.getAllChallenges();    //LiveData<List>
    }

    // === Alle database operaties:

    // Challenge =====================================
    public void insertChallenge(Challenge challenge) {
        new InsertChallengeAsyncTask(challengeDAO).execute(challenge);
    }

    public void updateChallenge (Challenge challenge) {
        new UpdateChallengeAsyncTask(challengeDAO).execute(challenge);
    }

    public void deleteChallenge (Challenge challenge) {
        new DeleteChallengeAsyncTask(challengeDAO).execute(challenge);
    }

    public LiveData<List<Challenge>> getAllChallenges() {
        return allChallenges;
    }

    // Async tasks om de data uit de database te halen
    // INSERT
    private static class InsertChallengeAsyncTask extends AsyncTask<Challenge, Void, Void> {
        private ChallengeDAO challengeDAOo;

        InsertChallengeAsyncTask(ChallengeDAO challengeDAOo) {
            this.challengeDAOo = challengeDAOo;
        }

        @Override
        protected Void doInBackground(final Challenge... challenges) {
            challengeDAOo.insertChallenge(challenges[0]);
            return null;
        }
    }

    // UPDATE
    private static class UpdateChallengeAsyncTask extends AsyncTask<Challenge, Void, Void> {
        private ChallengeDAO challengeDAOo;

        UpdateChallengeAsyncTask(ChallengeDAO challengeDAOo) {
            this.challengeDAOo = challengeDAOo;
        }

        @Override
        protected Void doInBackground(final Challenge... challenges) {
            challengeDAOo.updateChallenge(challenges[0]);
            return null;
        }
    }

    // DELETE
    private static class DeleteChallengeAsyncTask extends AsyncTask<Challenge, Void, Void> {
        private ChallengeDAO challengeDAOo;

        DeleteChallengeAsyncTask(ChallengeDAO challengeDAOo) {
            this.challengeDAOo = challengeDAOo;
        }

        @Override
        protected Void doInBackground(final Challenge... challenges) {
            challengeDAOo.deleteChallenge(challenges[0]);
            return null;
        }
    }
}
