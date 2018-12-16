package be.ehb.veganapp.DAO;

import android.arch.lifecycle.LiveData;

import java.util.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import be.ehb.veganapp.Model.VoltooideChallenge;

@Dao
public interface VoltooideChallengeDAO {

    // GET information -----------------------------------------
    // Laadt alle voltooide challenges
    @Query("SELECT * FROM voltooidechallenge")
    LiveData<List<VoltooideChallenge>> getAllVoltooideChallenges();

    // Selecteer voltooideChallenge op id
    @Query("SELECT * FROM voltooidechallenge WHERE voltooide_challenge_id = :id")
    public VoltooideChallenge findVoltooideChallengeById(int id);

    // SET information -----------------------------------------
    @Insert
    public void insertvoltooideChallenge(VoltooideChallenge voltooideChallenge);

    @Update
    public void updatevoltooideChallenge(VoltooideChallenge voltooideChallenge);

    @Delete
    public void deletevoltooideChallenge(VoltooideChallenge voltooideChallenge);
}
