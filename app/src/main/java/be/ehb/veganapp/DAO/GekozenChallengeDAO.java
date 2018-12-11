package be.ehb.veganapp.DAO;

import android.arch.lifecycle.LiveData;

import java.util.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import be.ehb.veganapp.GekozenChallenge;

@Dao
public interface GekozenChallengeDAO {

    // GET information -----------------------------------------
    // Laadt alle gekozen challenges
    @Query("SELECT * FROM gekozenchallenge")
    LiveData<List<GekozenChallenge>> getAllGekozenChallenges();

    // Selecteer gekozenChallenge op id
    @Query("SELECT * FROM gekozenchallenge WHERE gekozen_challenge_id = :id")
    public GekozenChallenge findGekozenChallengeById(int id);

    // SET information -----------------------------------------
    @Insert
    public void insertGekozenChallenge(GekozenChallenge challenge);

    @Update
    public void updateGekozenChallenge(GekozenChallenge challenge);

    @Delete
    public void deleteGekozenChallenge(GekozenChallenge challenge);
}
