package be.ehb.veganapp.DAO;

import android.arch.lifecycle.LiveData;

import java.util.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import be.ehb.veganapp.Challenge;


@Dao
public interface ChallengeDAO {
    // GET information -----------------------------------------

    // Laadt alle challenges
    @Query("SELECT * FROM challenge")
    LiveData<List<Challenge>> getAllChallenges();

    // Selecteer challenge op id
    @Query("SELECT * FROM challenge WHERE challenge_id = :id")
    public Challenge findChallengeById(int id);

    // SET information -----------------------------------------

    @Insert
    public void insertChallenge(Challenge challenge);

    @Update
    public void updateChallenge(Challenge challenge);

    @Delete
    public void deleteChallenge(Challenge challenge);
}
