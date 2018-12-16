package be.ehb.veganapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import be.ehb.veganapp.Model.Challenge;

public class ChallengeViewModel extends AndroidViewModel {
   private ChallengeRepository repository;
   private LiveData<List<Challenge>> allChallenges;

    public ChallengeViewModel(@NonNull Application application) {
        super(application);
        repository = new ChallengeRepository((application));
        allChallenges = repository.getAllChallenges();
    }

    // INSERT
    public void insertChallenge(Challenge challenge) {
        repository.insertChallenge(challenge);
    }

    // UPDATE
    public void updateChallenge(Challenge challenge) {
        repository.updateChallenge(challenge);
    }

    // DELETE
    public void deleteChallenge(Challenge challenge) {
        repository.deleteChallenge(challenge);
    }

    //GET ALL CHALLENGES
    public LiveData<List<Challenge>> getAllChallenges() {
        return allChallenges;
    }
}
